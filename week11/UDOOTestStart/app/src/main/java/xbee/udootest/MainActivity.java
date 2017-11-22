package xbee.udootest;

import android.app.Activity;
import android.content.Context;
import android.hardware.usb.UsbManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import me.palazzetti.adktoolkit.AdkManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

import weka.classifiers.Classifier;
import weka.classifiers.lazy.IBk;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import wlsvm.WLSVM;


public class MainActivity extends Activity {
    // private static final String TAG = "UDOO_AndroidADKFULL";
    private AdkManager mAdkManager;

    private ToggleButton buttonLED;
    private TextView distance;
    private TextView pulse;
    private TextView position;

    private AdkReadTask mAdkReadTask;
    private Instances testingSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdkManager = new AdkManager((UsbManager) getSystemService(Context.USB_SERVICE));

        // register a BroadcastReceiver to catch UsbManager.ACTION_USB_ACCESSORY_DETACHED action
        registerReceiver(mAdkManager.getUsbReceiver(), mAdkManager.getDetachedFilter());

        buttonLED = (ToggleButton) findViewById(R.id.toggleButtonLED);
        distance = (TextView) findViewById(R.id.textView_distance);
        pulse = (TextView) findViewById(R.id.textView_pulse);
        position = (TextView) findViewById(R.id.textView_position);

        File root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File f = new File(root, "iris_train.arff");
        Classifier ibk = new IBk();
        WLSVM svmCls = new WLSVM();
        BufferedReader inputReader;

        int correct = 0;
        int incorrect = 0;
        int[][] confusionMatrix = new int[3][3];

        try {
            inputReader = readFile(f);
            Instances data = new Instances(inputReader);
            data.setClassIndex(data.numAttributes() - 1);
            ibk.buildClassifier(data);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        f = new File(root, "iris_test.arff");

        try {
            inputReader = readFile(f);
            Instances test = new Instances(inputReader);
            test.setClassIndex(test.numAttributes() - 1);

            for (int i = 0; i < test.numInstances(); i++) {
                double pred = ibk.classifyInstance(test.instance(i));
                double act = test.instance(i).classValue();

                if (pred == act) {
                    confusionMatrix[(int) act][(int) act]++;
                    correct++;
                } else {
                    confusionMatrix[(int) pred][(int) act]++;
                    incorrect++;
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int[] x : confusionMatrix) {
            String temp = format(x[0]) + format(x[1]) + format(x[2]);
            stringBuilder.append(temp);
            stringBuilder.append("\n");
        }

        TextView cmTextView = (TextView) findViewById(R.id.confusion_matrix);
        cmTextView.setText(stringBuilder.toString());

        double accuracy = (double) correct / (incorrect + correct);
        TextView accTextView = (TextView) findViewById(R.id.accuracy);
        String temp = "Correct: " + correct + "\n"
                + "Incorrect: " + incorrect + "\n"
                + "Accuracy: " + accuracy + "\n";
        accTextView.setText(temp);
    }

    private void makeInstance(double slValue, double swValue, double plValue, double pwValue) {
        Attribute Attribute1 = new Attribute("sepallength");
        Attribute Attribute2 = new Attribute("sepalwidth");
        Attribute Attribute3 = new Attribute("petallength");
        Attribute Attribute4 = new Attribute("petalwidth");

        // Declare the class attribute along with its values(nominal)
        FastVector fvClassVal = new FastVector(3);
        fvClassVal.addElement("Iris-setosa");
        fvClassVal.addElement("Iris-versicolor");
        fvClassVal.addElement("Iris-virginica");
        Attribute ClassAttribute = new Attribute("class", fvClassVal);

        // Declare the feature vector template
        FastVector fvWekaAttributes = new FastVector(5);
        fvWekaAttributes.addElement(Attribute1);
        fvWekaAttributes.addElement(Attribute2);
        fvWekaAttributes.addElement(Attribute3);
        fvWekaAttributes.addElement(Attribute4);
        fvWekaAttributes.addElement(ClassAttribute);

        // Creating testing instances object with name "TestingInstance"
        // using the feature vector template we declared above
        // and with initial capacity of 1
        testingSet = new Instances("TestingInstance", fvWekaAttributes, 1);

        // Setting the column containing class labels:
        testingSet.setClassIndex(testingSet.numAttributes() - 1);

        // Create and fill an instance, and add it to the testingSet
        Instance iExample = new Instance(testingSet.numAttributes());
        iExample.setValue((Attribute) fvWekaAttributes.elementAt(0), slValue);
        iExample.setValue((Attribute) fvWekaAttributes.elementAt(1), swValue);
        iExample.setValue((Attribute) fvWekaAttributes.elementAt(2), plValue);
        iExample.setValue((Attribute) fvWekaAttributes.elementAt(3), pwValue);
        iExample.setValue((Attribute) fvWekaAttributes.elementAt(4), "Iris-setosa");

        // add the instance
        testingSet.add(iExample);
    }

    private String format(int i) {
        return String.format(Locale.getDefault(), "%5d", i);
    }

    private BufferedReader readFile(File f) throws FileNotFoundException {
        FileReader fReader = new FileReader(f);
        return new BufferedReader(fReader);
    }

    @Override
    public void onResume() {
        super.onResume();
        mAdkManager.open();

        mAdkReadTask = new AdkReadTask();
        mAdkReadTask.execute();
    }

    @Override
    public void onPause() {
        super.onPause();
        mAdkManager.close();

        mAdkReadTask.pause();
        mAdkReadTask = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mAdkManager.getUsbReceiver());
    }

    // ToggleButton method - send message to SAM3X
    public void blinkLED(View v) {
        if (buttonLED.isChecked()) {
            // writeSerial() allows you to write a single char or a String object.
            mAdkManager.writeSerial("1");
        } else {
            mAdkManager.writeSerial("0");
        }
    }

    /*
     * We put the readSerial() method in an AsyncTask to run the
     * continuous read task out of the UI main thread
     */
    private class AdkReadTask extends AsyncTask<Void, String, Void> {

        private boolean running = true;

        public void pause() {
            running = false;
        }

        protected Void doInBackground(Void... params) {
//	    	Log.i("ADK demo bi", "start adkreadtask");
            while (running) {
                publishProgress(mAdkManager.readSerial());
            }
            return null;
        }

        protected void onProgressUpdate(String... progress) {

            float pulseRate = (int) progress[0].charAt(0);
            float oxygenLvl = (int) progress[0].charAt(1);
            float pos = (int) progress[0].charAt(2);
            int max = 255;
            if (pulseRate > max) pulseRate = max;
            if (oxygenLvl > max) oxygenLvl = max;
            if (pos > max) pos = max;

//            DecimalFormat df = new DecimalFormat("#.#");
            distance.setText(pulseRate + " (bpm)");
            pulse.setText(oxygenLvl + " (pct)");
            position.setText(pos + "");
        }
    }
}

package xbee.udootest;

import android.app.Activity;
import android.content.Context;
import android.hardware.usb.UsbManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import me.palazzetti.adktoolkit.AdkManager;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import wlsvm.WLSVM;

public class MainActivity extends Activity {
    private static final int INSTANCES_CAPACITY = 4;

    // private static final String TAG = "UDOO_AndroidADKFULL";
    private AdkManager mAdkManager;
    private String stressBool;
    private int instanceNo = 0;

    private ToggleButton buttonLED;
    private TextView distance;
    private TextView pulse;
    private TextView position;

    private WLSVM svmCls;
    private Instances set;
    private FastVector fvWekaAttributes;

    private AdkReadTask mAdkReadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdkManager = new AdkManager((UsbManager) getSystemService(Context.USB_SERVICE));
        registerReceiver(mAdkManager.getUsbReceiver(), mAdkManager.getDetachedFilter());

        initInstances();

        buttonLED = (ToggleButton) findViewById(R.id.toggleButtonLED);
        distance = (TextView) findViewById(R.id.textView_distance);
        pulse = (TextView) findViewById(R.id.textView_pulse);
        position = (TextView) findViewById(R.id.textView_position);

        // Set to Rest
        Button trainRest = (Button) findViewById(R.id.train_rest);
        trainRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stressBool = "rest";
                Toast.makeText(MainActivity.this, "stressBool set to rest.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Set to Stress
        Button trainStress = (Button) findViewById(R.id.train_stress);
        trainStress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stressBool = "stress";
                Toast.makeText(MainActivity.this, "stressBool set to stress.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Start training data
        Button startTrain = (Button) findViewById(R.id.start_train);
        startTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (instanceNo != 4) {
                    Toast.makeText(MainActivity.this,
                            "Capacity not reached.\nPlease add more data.", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    svmCls.buildClassifier(set);
                    Toast.makeText(MainActivity.this, "Training done.",
                            Toast.LENGTH_SHORT).show();

                } catch (Exception ex) {
                    Toast.makeText(MainActivity.this, "Training error!",
                            Toast.LENGTH_SHORT).show();
                    ex.printStackTrace();
                }
            }
        });
    }

    private void initInstances() {
        Attribute Attribute1 = new Attribute("oxygen");
        Attribute Attribute2 = new Attribute("pulse");

        FastVector fvClassVal = new FastVector(2);
        fvClassVal.addElement("rest");
        fvClassVal.addElement("stress");
        Attribute ClassAttribute = new Attribute("class", fvClassVal);

        fvWekaAttributes = new FastVector(3);
        fvWekaAttributes.addElement(Attribute1);
        fvWekaAttributes.addElement(Attribute2);
        fvWekaAttributes.addElement(ClassAttribute);

        set = new Instances("StressLevel", fvWekaAttributes, INSTANCES_CAPACITY);
        set.setClassIndex(set.numAttributes() - 1);
    }

    private void addToInstances(double oxygen, double pulse, String stressBool) {
        if (instanceNo >= INSTANCES_CAPACITY) {
            Toast.makeText(this, "Capacity reached!\nNew Instances is not added.",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        Instance instance = new Instance(set.numAttributes());
        instance.setValue((Attribute) fvWekaAttributes.elementAt(0), oxygen);
        instance.setValue((Attribute) fvWekaAttributes.elementAt(1), pulse);
        instance.setValue((Attribute) fvWekaAttributes.elementAt(2), stressBool);

        set.add(instance);
        instanceNo++;
        Toast.makeText(this, "Instance added.", Toast.LENGTH_SHORT).show();
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
            // Log.i("ADK demo bi", "start adkreadtask");
            while (running) {
                publishProgress(mAdkManager.readSerial());
            }
            return null;
        }

        protected void onProgressUpdate(String... progress) {
            double pulseRate = (int) progress[0].charAt(0);
            double oxygenLvl = (int) progress[0].charAt(1);
            double pos = (int) progress[0].charAt(2);
            int max = 255;

            if (pulseRate > max) pulseRate = max;
            if (oxygenLvl > max) oxygenLvl = max;
            if (pos > max) pos = max;

            // DecimalFormat df = new DecimalFormat("#.#");
            distance.setText(pulseRate + " (bpm)");
            pulse.setText(oxygenLvl + " (pct)");
            position.setText(pos + "");

            final String finalStressBool = stressBool;
            addToInstances(pulseRate, oxygenLvl, finalStressBool);
        }
    }
}

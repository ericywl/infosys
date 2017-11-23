package xbee.udootest;

import android.app.Activity;
import android.content.Context;
import android.hardware.usb.UsbManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
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


public class Main2Activity extends Activity {
    // private static final String TAG = "UDOO_AndroidADKFULL";
    private AdkManager mAdkManager;
    private Instances testingSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdkManager = new AdkManager((UsbManager) getSystemService(Context.USB_SERVICE));

        // register a BroadcastReceiver to catch UsbManager.ACTION_USB_ACCESSORY_DETACHED action
        registerReceiver(mAdkManager.getUsbReceiver(), mAdkManager.getDetachedFilter());

        final EditText sepalLengthInput = findViewById(R.id.sepal_length_input);
        final EditText sepalWidthInput = findViewById(R.id.sepal_width_input);
        final EditText petalLengthInput = findViewById(R.id.petal_length_input);
        final EditText petalWidthInput = findViewById(R.id.petal_width_input);
        Button trainBtn = findViewById(R.id.train_btn);
        trainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BufferedReader inputReader;
                WLSVM svmCls = new WLSVM();
                File root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                File f = new File(root, "iris_train.arff");

                try {
                    inputReader = readFile(f);
                    Instances data = new Instances(inputReader);
                    data.setClassIndex(data.numAttributes() - 1);
                    svmCls.buildClassifier(data);
                    weka.core.SerializationHelper.write("svmModel", svmCls);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                Toast.makeText(Main2Activity.this, "Training done!", Toast.LENGTH_SHORT).show();
            }
        });

        Button classifyBtn = findViewById(R.id.classify_btn);
        classifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    WLSVM svmCls = (WLSVM) weka.core.SerializationHelper.read("svmModel");
                    double slValue = Double.parseDouble(sepalLengthInput);
                    double swValue = Double.parseDouble(sepalWidthInput);
                    double plValue = Double.parseDouble(petalLengthInput);
                    double pwValue = Double.parseDouble(petalWidthInput);

                    double classified =
                            svmCls.classifyInstance(makeInstance(slValue, swValue, plValue, pwValue));
                    Toast.makeText(Main2Activity.this, "The class is " + classified,
                            Toast.LENGTH_SHORT).show();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });
    }

    private Instance makeInstance(double slValue, double swValue, double plValue, double pwValue) {
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
        return iExample;
    }

    private BufferedReader readFile(File f) throws FileNotFoundException {
        FileReader fReader = new FileReader(f);
        return new BufferedReader(fReader);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mAdkManager.getUsbReceiver());
    }
}


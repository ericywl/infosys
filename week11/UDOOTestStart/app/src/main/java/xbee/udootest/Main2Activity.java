package xbee.udootest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import wlsvm.WLSVM;


public class Main2Activity extends Activity {
    // private static final String TAG = "UDOO_AndroidADKFULL";
    private Instances testingSet;
    private WLSVM svmCls = new WLSVM();
    private static final String[] flowers = {"Iris-setosa", "Iris-versicolor", "Iris-virginica"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final EditText sepalLengthInput = (EditText) findViewById(R.id.sepal_length_input);
        final EditText sepalWidthInput = (EditText) findViewById(R.id.sepal_width_input);
        final EditText petalLengthInput = (EditText) findViewById(R.id.petal_length_input);
        final EditText petalWidthInput = (EditText) findViewById(R.id.petal_width_input);
        Button trainBtn = (Button) findViewById(R.id.train_btn);
        trainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BufferedReader inputReader;
                File root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                File f = new File(root, "iris_train.arff");

                try {
                    inputReader = readFile(f);
                    Instances data = new Instances(inputReader);
                    data.setClassIndex(data.numAttributes() - 1);
                    svmCls.buildClassifier(data);

                    Toast.makeText(Main2Activity.this, "Training done!",
                            Toast.LENGTH_SHORT).show();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        Button classifyBtn = (Button) findViewById(R.id.classify_btn);
        classifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double slValue = Double.parseDouble(sepalLengthInput.getText().toString());
                    double swValue = Double.parseDouble(sepalWidthInput.getText().toString());
                    double plValue = Double.parseDouble(petalLengthInput.getText().toString());
                    double pwValue = Double.parseDouble(petalWidthInput.getText().toString());

                    Instance instance = makeInstance(slValue, swValue, plValue, pwValue);
                    double classified = svmCls.classifyInstance(testingSet.firstInstance());

                    Toast.makeText(Main2Activity.this, "The class is "
                                    + flowers[(int) classified], Toast.LENGTH_SHORT).show();

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

        // add the instance
        testingSet.add(iExample);
        return iExample;
    }

    private BufferedReader readFile(File f) throws FileNotFoundException {
        FileReader fReader = new FileReader(f);
        return new BufferedReader(fReader);
    }
}


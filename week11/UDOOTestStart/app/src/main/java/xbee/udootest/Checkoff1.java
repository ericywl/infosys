package xbee.udootest;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;

import weka.classifiers.Classifier;
import weka.classifiers.lazy.IBk;
import weka.core.Instances;

public class Checkoff1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkoff1);

        File root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File f = new File(root, "iris_train.arff");
        Classifier ibk = new IBk();
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

    private String format(int i) {
        return String.format(Locale.getDefault(), "%5d", i);
    }

    private BufferedReader readFile(File f) throws FileNotFoundException {
        FileReader fReader = new FileReader(f);
        return new BufferedReader(fReader);
    }

}

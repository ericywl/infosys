package eric.quiz3_2017;

//—copy and paste code from this place onwards 

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements EstimatePi.AsyncResponse {
    TextView textViewResult;
    EditText editTextNumIters;
    Button buttonRun;

    private String numItersStr;
    private int currNumIters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumIters = (EditText) findViewById(R.id.num_iters);
        textViewResult = (TextView) findViewById(R.id.result);
        buttonRun = (Button) findViewById(R.id.run);
    }

    public void runOnClick(View view) {
        EstimatePi estimatePi = new EstimatePi(this);
        numItersStr = editTextNumIters.getText().toString();
        if (numItersStr.equals("")) {
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setTitle("Error!");
            adb.setMessage("Please enter a value.");
            return;
        }

        int numIters = Integer.parseInt(numItersStr);
        for (int i = 100000; i <= numIters; i += 100000) {
            currNumIters = i;
            estimatePi.execute(i);
        }
    }

    @Override
    public void processFinish(Double d) {
        String result = "After " + currNumIters
                + " iterations the estimate of pi is " + d + ".";
        textViewResult.setText(result);

        Toast.makeText(this, "Iterations are complete.", Toast.LENGTH_SHORT).show();
    }
}

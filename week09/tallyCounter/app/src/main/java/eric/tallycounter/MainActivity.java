package eric.tallycounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tally;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tally = findViewById(R.id.tally);

        Button incrementButton = findViewById(R.id.increment);
        Button resetButton = findViewById(R.id.reset);

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tallyCount = tally.getText().toString();
                int tallyCountVal = Integer.parseInt(tallyCount);

                tally.setText(String.valueOf(tallyCountVal + 1));
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tally.setText(String.valueOf(0));
            }
        });
    }
}

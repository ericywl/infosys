package eric.week09;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button sutdButton;
    TextView sutdAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sutdAddress = findViewById(R.id.sutdAddress);
        sutdAddress.setVisibility(View.INVISIBLE);

        sutdButton = findViewById(R.id.sutdButton);
    }

    protected void whenClick(View view) {
        if (view.getVisibility() == View.INVISIBLE) {
            view.setVisibility(View.VISIBLE);
            sutdButton.setText(R.string.buttonText2);
        } else {
            view.setVisibility(View.INVISIBLE);
            sutdButton.setText(R.string.buttonText);
        }
    }
}

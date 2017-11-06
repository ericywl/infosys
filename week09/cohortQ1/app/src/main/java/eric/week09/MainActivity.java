package eric.week09;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView sutdAddress;
    Button sutdButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sutdAddress = findViewById(R.id.sutdAddress);
        sutdAddress.setVisibility(View.INVISIBLE);

        sutdButton = findViewById(R.id.sutdButton);
        sutdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shortClick();
            }
        });

        sutdButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                longClick();
                return true;
            }
        });
    }

    private void shortClick() {
        if (sutdAddress.getVisibility() == View.INVISIBLE) {
            sutdAddress.setVisibility(View.VISIBLE);
            sutdButton.setText(R.string.buttonText2);
        } else {
            sutdAddress.setVisibility(View.INVISIBLE);
            sutdButton.setText(R.string.buttonText);
        }
    }

    private void longClick() {
        String address = getString(R.string.uni_address);
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("addr", address);

        if (clipboard != null) {
            clipboard.setPrimaryClip(clip);

            Context appCtx = getApplicationContext();
            Toast.makeText(appCtx, "SUTD Address copied to clipboard.", Toast.LENGTH_SHORT).show();
        }
    }
}

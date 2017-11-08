package eric.cohortq2;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Intent intent = getIntent();
        String username = intent.getStringExtra(MainActivity.KEY);

        TextView hello = findViewById(R.id.myMessage);
        Resources res = getResources();
        String text = res.getString(R.string.hello, username);
        hello.setText(text);
    }
}

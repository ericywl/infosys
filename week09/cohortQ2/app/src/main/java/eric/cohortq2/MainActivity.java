package eric.cohortq2;

import android.content.Context;
import android.content.Intent;
import android.renderscript.ScriptGroup;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText pwd;
    private EditText name;
    public static final String KEY = "eric.cohortq2.main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.myName);
        pwd = findViewById(R.id.passwordField);

        Button submitBtn = findViewById(R.id.submitButton);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean passwordMatch = pwd.getText().toString().matches("password");
                Log.i("eric", "Password match = " + passwordMatch);
                Context appCtx = view.getContext();

                if (passwordMatch) {
                    // go next activity
                    Intent intent = new Intent(appCtx, NextActivity.class);
                    String message = name.getText().toString();
                    intent.putExtra(KEY, message);
                    startActivity(intent);
                } else {
                    Toast.makeText(appCtx, "Incorrect Password!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        RadioGroup showHidePwd = findViewById(R.id.showHidePassword);
        showHidePwd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {
                switch(checkedId)
                {
                    case R.id.showPassword:
                        pwd.setTransformationMethod(null);
                        break;
                    case R.id.hidePassword:
                        pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        break;

                }
            }
        });
    }
}

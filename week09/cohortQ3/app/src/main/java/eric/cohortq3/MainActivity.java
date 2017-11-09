package eric.cohortq3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements SharedPreferences.OnSharedPreferenceChangeListener {
    SharedPreferences sharedPref;
    EditText searchLocation;
    Button getMap;
    Button getNav;
    String travelMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get references to widgets
        searchLocation = findViewById(R.id.location);
        getMap = findViewById(R.id.btn_getMap);
        getNav = findViewById(R.id.btn_navigation);

        // reading from shared preferences
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPref.registerOnSharedPreferenceChangeListener(this);

        // get setting from shared preferences and change button font size
        String chkBoxLargeFontKey = getString(R.string.chkBoxLargeFontKey);
        boolean isButtonLargeFont = sharedPref.getBoolean(chkBoxLargeFontKey, false);
        setBtnFontSize(isButtonLargeFont);

        // set mode of travel for map navigation
        RadioGroup setMode = findViewById(R.id.mode);
        setMode.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.mode_bike:
                        travelMode = "b";
                        break;

                    case R.id.mode_car:
                        travelMode = "d";
                        break;

                    case R.id.mode_walk:
                        travelMode = "w";
                        break;
                }
            }
        });
    }

    // display map of search location
    public void onClick(View view) {
        String myLocation = searchLocation.getText().toString().trim();
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("geo").opaquePart("0,0").appendQueryParameter("q", myLocation);

        Uri geoLocation = builder.build();
        getMapLocation(geoLocation);
    }

    private void getMapLocation(Uri geoLocation) {
        Intent mapIntent = new Intent(Intent.ACTION_VIEW);
        mapIntent.setData(geoLocation);

        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    // show navigation to search location
    public void onClickNavigate(View view) {
        String navLocation = searchLocation.getText().toString().trim();
        Uri gmmIntentUri = Uri.parse("google.navigation:q=" + navLocation + "&travelMode=" + travelMode);

        getNav(gmmIntentUri);
    }

    private void getNav(Uri gmmIntentUri) {
        Intent navIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        navIntent.setPackage("com.google.android.apps.maps");

        if (navIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(navIntent);
        }
    }

    @Override
    // inflate menu on top-right
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Context ctx = getApplicationContext();

        switch (id) {
            case R.id.settings:
                // go to SettingsActivity
                Intent settingsIntent = new Intent(ctx, SettingsActivity.class);
                startActivity(settingsIntent);
                return true;

            case R.id.help:
                // display toast
                Toast.makeText(this, R.string.jebait, Toast.LENGTH_SHORT).show();
                return true;
        }

        return true;
    }

    @Override
    // override shared preferences
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals(getString(R.string.chkBoxLargeFontKey))) {
            boolean checked = sharedPreferences.getBoolean(key, false);
            setBtnFontSize(checked);
        }
    }

    // set button font size based on checkbox setting
    private void setBtnFontSize(boolean checked) {
        int unit = TypedValue.COMPLEX_UNIT_DIP;
        int largeSize = 30;
        int smallSize = 14;

        if (checked) {
            getMap.setTextSize(unit, largeSize);
            getNav.setTextSize(unit, largeSize);
        } else {
            getMap.setTextSize(unit, smallSize);
            getNav.setTextSize(unit, smallSize);
        }
    }
}

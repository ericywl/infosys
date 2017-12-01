package eric.quiz3_2017;

// - - copy and paste from this point onwards 

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import static eric.quiz3_2017.FolksongsDatabase.FolksongsTable.COL_COUNTRY;
import static eric.quiz3_2017.FolksongsDatabase.FolksongsTable.COL_TITLE;
import static eric.quiz3_2017.FolksongsDatabase.FolksongsTable.TABLE_NAME;

public class MainActivity extends AppCompatActivity {

    JSONArray jsonArray;
    SQLiteDatabase folksongsDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String JSONString = convertJsonToString(R.raw.folksongs);
        jsonArray = parseJSON(JSONString);

        FolksongsDbHelper folksongsDbHelper = new FolksongsDbHelper(this, jsonArray);
        folksongsDatabase = folksongsDbHelper.getReadableDatabase();

        EditText editText = (EditText) findViewById(R.id.country);
        String countryStr = editText.getText().toString().toLowerCase();
        final String formatCountryStr = countryStr.substring(0, 1).toUpperCase()
                + countryStr.substring(1, countryStr.length());

        TextView textView = (TextView) findViewById(R.id.result);
        Button getFolksong = (Button) findViewById(R.id.get_folksong);
        getFolksong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String whereClause = COL_COUNTRY + "=?";
                String[] whereArgs = {formatCountryStr};
                Cursor cursor = folksongsDatabase.query(TABLE_NAME, null,
                        whereClause, whereArgs, null, null, null);

                int index = cursor.getColumnIndex(COL_TITLE);
            }
        });
    }

    private String convertJsonToString(int resource) {
        String line;
        String output = "";

        InputStream inputStream = getResources().openRawResource(resource);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            while ((line = reader.readLine()) != null) {
                output = output + line;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return output;
    }

    private JSONArray parseJSON(String JSONString) {
        JSONArray array = null;

        try {
            array = new JSONArray(JSONString);
        } catch (JSONException ex) {
            ex.printStackTrace();
        }

        return array;
    }
}

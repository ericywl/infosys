package eric.cohortq2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static eric.cohortq2.SpendingContract.SpendingEntry.*;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase spendingDB;

    private EditText remarks;
    private EditText amount;
    private EditText delete;
    private TextView dbView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        remarks = findViewById(R.id.editTextRemarks);
        amount = findViewById(R.id.editTextAmount);
        delete = findViewById(R.id.editTextID);
        dbView = findViewById(R.id.textViewEntireDatabase);

        SpendingDBHelper spendingDBHelper = new SpendingDBHelper(this);
        spendingDB = spendingDBHelper.getWritableDatabase();
    }

    public void onClickAddToDb(View view) {
        ContentValues values = new ContentValues();
        String remarksStr = remarks.getText().toString();
        String amountStr = amount.getText().toString();
        values.put(COL_REMARKS, remarksStr);
        values.put(COL_AMOUNT, amountStr);
        spendingDB.insert(TABLE_NAME, null, values);

        Toast.makeText(this,
                "New entry added: (" + remarksStr + ", " + amountStr + ")",
                Toast.LENGTH_SHORT).show();
    }

    public void onClickDeleteFromDb(View view) {
        String deleteStr = delete.getText().toString();

        if (!checkDb(deleteStr)) {
            Toast.makeText(this, "Item doesn't exist.", Toast.LENGTH_SHORT).show();
            return;
        }

        String whereClause = _ID + "=?";
        String[] whereArgs = {deleteStr};
        spendingDB.delete(TABLE_NAME, whereClause, whereArgs);
    }

    private boolean checkDb(String str) {
        Cursor cursor = spendingDB.query(TABLE_NAME, null,
                null, null, null, null, null);

        int idIndex = cursor.getColumnIndex(_ID);
        while (cursor.moveToNext()) {
            if (cursor.getString(idIndex).equals(str)) {
                return true;
            }
        }

        cursor.close();
        return false;
    }

    public void onClickGetEntireDb(View view) {
        Cursor cursor = spendingDB.query(TABLE_NAME, null,
                null, null, null, null, _ID);

        StringBuilder output = new StringBuilder();
        int idIndex = cursor.getColumnIndex(_ID);
        int remarksIndex = cursor.getColumnIndex(COL_REMARKS);
        int amountIndex = cursor.getColumnIndex(COL_AMOUNT);

        while (cursor.moveToNext()) {
            String str = cursor.getString(idIndex) + ". "
                    + cursor.getString(remarksIndex) + ": "
                    + cursor.getString(amountIndex);
            output.append(str);
            output.append("\n");
        }

        dbView.setText(output.toString());
        cursor.close();
    }
}

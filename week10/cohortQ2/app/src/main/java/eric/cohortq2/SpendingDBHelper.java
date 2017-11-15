package eric.cohortq2;

import static eric.cohortq2.SpendingContract.SpendingEntry.*;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SpendingDBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VER = 1;

    SpendingDBHelper(Context context) {
        super(context, TABLE_NAME, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_AMOUNT + " TEXT NOT NULL, "
                + COL_REMARKS + " TEXT NOT NULL)";

        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVer, int newVer) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}

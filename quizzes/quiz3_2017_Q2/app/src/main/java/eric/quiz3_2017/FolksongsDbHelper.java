package eric.quiz3_2017;

//— -copy and paste from this line onwards — -

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.json.JSONArray;
import org.json.JSONObject;

import static eric.quiz3_2017.FolksongsDatabase.FolksongsTable.*;


public class FolksongsDbHelper extends SQLiteOpenHelper {

    Context context;
    JSONArray jsonArray;
    public static final int DATABASE_VERSION = 1;

    FolksongsDbHelper(Context context, JSONArray jsonArray){
        super(context, TABLE_NAME, null,DATABASE_VERSION);
        this.context = context;
        this.jsonArray = jsonArray;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE ="CREATE TABLE " + TABLE_NAME + "("
                + COL_COUNTRY + " TEXT PRIMARY KEY, "
                + COL_TITLE + " TEXT NOT NULL)";
        sqLiteDatabase.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    private void initalize() {
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
            }
        }
    }

}

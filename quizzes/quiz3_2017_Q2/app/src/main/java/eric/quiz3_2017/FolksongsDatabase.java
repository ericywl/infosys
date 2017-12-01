package eric.quiz3_2017;

//- - - copy and paste from this point onwards  - - -

import android.provider.BaseColumns;

public class FolksongsDatabase {
    public static final class FolksongsTable implements BaseColumns{
        public static final String TABLE_NAME = "Folksongs";
        public static final String COL_TITLE = "title";
        public static final String COL_COUNTRY = "country";
    }
}

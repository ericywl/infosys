package eric.cohortq2;


import android.provider.BaseColumns;

public class SpendingContract {
    public static final class SpendingEntry implements BaseColumns {
        public static final String TABLE_NAME = "SpendingRecord";
        public static final String COL_AMOUNT = "Amount";
        public static final String COL_REMARKS = "Remarks";
    }
}

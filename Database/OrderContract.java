package za.ac.cput.browse.Database;

import android.net.Uri;
import android.provider.BaseColumns;

public class OrderContract {

    public OrderContract() {
    }

    //study sqllite datase to learn more
    // contentauthority requires you to enter your package name
    public static final String CONTENT_AUTHORITY = "za.ac.cput.browse";
    public static final Uri BASE_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    // this should be similar to your table name
    public static final String PATH = "orderig";

    public static abstract class OrderEntry implements BaseColumns {

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_URI, PATH);

        public static final String TABLE_NAME = "orderig";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PRICE = "price";
    }

}

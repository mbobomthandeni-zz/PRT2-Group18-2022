package za.ac.cput.browse;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import za.ac.cput.browse.Database.OrderContract;

public class CartAdapter extends CursorAdapter {


    public CartAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.cartlist, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // getting theviews

        TextView bookName, price ;


        bookName = view.findViewById(R.id.bookNameinOrderSummary);
        price = view.findViewById(R.id.priceinOrderSummary);

        // getting the values by first getting the position of their columns

        int name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
        int priceofbook = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);

        String nameofbook = cursor.getString(name);
        String pricesofbook = cursor.getString(priceofbook);


        bookName.setText(nameofbook);
        price.setText(pricesofbook);

    }
}

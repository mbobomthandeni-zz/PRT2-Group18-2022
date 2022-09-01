package za.ac.cput.browse;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import za.ac.cput.browse.Database.OrderContract;

public class InfoActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    //views that are present in the layout on info

    ImageView imageView;
    TextView bookName, bookPrice;
    Button buyBook;
    public Uri mCurrentCartUri;
    boolean hasAllRequiredValues = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        imageView = findViewById(R.id.imageViewInfo);
        bookName = findViewById(R.id.bookNameinInfo);
        bookPrice = findViewById(R.id.bookPrice);
        buyBook = findViewById(R.id.buy);

        // setting the name of drink

        bookName.setText("Book 1");

        buyBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InfoActivity.this, SummaryActivity.class);
                startActivity(intent);
                // once this button is clicked we want to save our values in the database and send those values
                // right away to summary activity where we display the order info

                SaveCart();
            }
        });

    }

    private boolean SaveCart() {
        // getting the values from our views
        String name = bookName.getText().toString();
        String price = bookPrice.getText().toString();

        ContentValues values = new ContentValues();
        values.put(OrderContract.OrderEntry.COLUMN_NAME, name);
        values.put(OrderContract.OrderEntry.COLUMN_PRICE, price);

        if (mCurrentCartUri == null) {
            Uri newUri = getContentResolver().insert(OrderContract.OrderEntry.CONTENT_URI, values);
            if (newUri==null) {
                Toast.makeText(this, "Failed to add to Cart", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Success  adding to Cart", Toast.LENGTH_SHORT).show();

            }
        }

        hasAllRequiredValues = true;
        return hasAllRequiredValues;
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        String[] projection = {OrderContract.OrderEntry._ID,
                OrderContract.OrderEntry.COLUMN_NAME,
                OrderContract.OrderEntry.COLUMN_PRICE,
        };

        return new CursorLoader(this,
                mCurrentCartUri,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if  (cursor == null || cursor.getCount() < 1) {
            return;
        }

        if (cursor.moveToFirst()) {

            int name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
            int price = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);


            String nameofbook = cursor.getString(name);
            String priceofbook = cursor.getString(price);

            bookName.setText(nameofbook);
            bookPrice.setText(priceofbook);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        bookName.setText("");
        bookPrice.setText("");
    }
}
 package za.ac.cput.browse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

 public class MainActivity extends AppCompatActivity {
    List<Model> modelList;
    RecyclerView recyclerView;
    OrderAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // creating an arraylist
        modelList = new ArrayList<>();
        modelList.add(new Model("Book 1", getString(R.string.book1), R.drawable.book1));
        modelList.add(new Model("Book 2", getString(R.string.book2), R.drawable.book2));
        modelList.add(new Model("Book 3", getString(R.string.book3), R.drawable.book3));
        modelList.add(new Model("Book 4", getString(R.string.book4), R.drawable.book4));
        modelList.add(new Model("Book 5", getString(R.string.book5), R.drawable.book5));
        modelList.add(new Model("Book 6", getString(R.string.book6), R.drawable.book6));
        modelList.add(new Model("Book 7", getString(R.string.book7), R.drawable.book7));
        modelList.add(new Model("Book 8", getString(R.string.book8), R.drawable.book8));
        modelList.add(new Model("Book 9", getString(R.string.book9), R.drawable.book9));

        // recyclerview
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));
        // adapter
        mAdapter = new OrderAdapter(this, modelList);
        recyclerView.setAdapter(mAdapter);
    }
}
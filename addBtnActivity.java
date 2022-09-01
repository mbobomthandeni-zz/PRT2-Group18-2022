package com.example.bookalot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class addBtnActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_btn);
        recyclerView= findViewById(R.id.recycle);
        add=findViewById(R.id.addnew);
        add.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent= new Intent(addBtnActivity.this,AddBooks.class);
        startActivity(intent);
    }
});
    }
}

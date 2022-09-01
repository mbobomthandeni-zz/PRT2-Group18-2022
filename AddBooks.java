package com.example.bookalot;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;


public class AddBooks extends AppCompatActivity {
    Button addBook;
    EditText txtSubject,txtTitle,txtIsbn,txtDescription;
    Spinner spinnerStream;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_books);
        addBook = findViewById(R.id.btnAddBook);
        Database myDb= new Database(AddBooks.this);

        addBook.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        myDb.addBook((String)spinnerStream.getSelectedItem().toString().trim(),txtSubject.getText().toString().trim(),
        txtTitle.getText().toString().trim(),Integer.parseInt(txtIsbn.getText().toString().trim()),
                txtDescription.getText().toString().trim());
    }
});

    }


    /*public void insertBookData(){
        String stream= ((Spinner) findViewById(R.id.spinnerStream)).getSelectedItem().toString();
        String subject= ((EditText) findViewById(R.id.txtSubject)).getText().toString();
        String title = ((EditText) findViewById(R.id.txtTitle)).getText().toString();
        String isbn= ((EditText) findViewById(R.id.txtIsbn)).getText().toString();
        String description= ((EditText) findViewById(R.id.txtDescription)).getText().toString();





        /*FirebaseUser user = fAuth.getCurrentUser();

        Toast.makeText(AddBooks.this, "Account Created ", Toast.LENGTH_SHORT).show();

        DocumentReference documentReference = fStore.collection("Book").document(user.getUid());

        Map<String, Object> bookInformation = new HashMap<>();

        bookInformation.put("Stream", stream);

        bookInformation.put("Subject",subject );

        bookInformation.put("Title", title);

        bookInformation.put("ISBN", isbn);

        bookInformation.put("Description", description);


        documentReference.set(bookInformation);


        Toast.makeText(AddBooks.this, "Book uploaded ", Toast.LENGTH_SHORT).show();
        //startActivity(new Intent(getApplicationContext(), MainActivity.class));

        finish();*/


    }

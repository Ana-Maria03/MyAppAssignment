package com.is6144.myappassignment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.review);


        Book book1 = new Book("The Shining by Stephen King", 1);
        Book book2 = new Book("Animal Farm by George Orwell", 2);
        Book book3 = new Book("Jane Eyre by Charlotte Bronte", 3);
        Book book4 = new Book("Communist Manifest by Marx and Engels", 4);
        Book book5 = new Book("The Wonderful Wizard of Oz by L. Frank Baum", 5);
        Book book6 = new Book("Alice in Wonderland by Lewis Carroll", 6);
        Book book7 = new Book("Just Kids by Patti Smith", 7);
        Book book8 = new Book("Moby Dick by Herman Melville", 8);
        Book[] arrayBook={book1, book2, book3,book4,book5,book6,book7,book8};

        RecyclerView recyclerView = findViewById(R.id.rView);
        BookViewHolderAdapter adapter= new BookViewHolderAdapter(arrayBook);
        recyclerView.setLayoutManager(new LinearLayoutManager(this
        ));
        recyclerView.setAdapter(adapter);





    }



}

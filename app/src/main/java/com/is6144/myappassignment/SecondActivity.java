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


        Book book1 = new Book("The Shining", 1);
        Book book2 = new Book("Animal Farm", 2);
        Book book3 = new Book("Jane Eyre", 3);
        Book[] arrayBook={book1, book2, book3};

        RecyclerView recyclerView = findViewById(R.id.rView);
        BookViewHolderAdapter adapter= new BookViewHolderAdapter(arrayBook);
        recyclerView.setLayoutManager(new LinearLayoutManager(this
        ));
        recyclerView.setAdapter(adapter);





    }



}

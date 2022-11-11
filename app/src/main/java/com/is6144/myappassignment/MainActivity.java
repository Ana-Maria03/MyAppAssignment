package com.is6144.myappassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



import androidx.appcompat.app.AppCompatActivity;




public class MainActivity extends AppCompatActivity {


    Button btn1;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn1= findViewById(R.id.btn1);


        btn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this ,SecondActivity.class);

                startActivity(i);
            }
        });

    }





}
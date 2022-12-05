package com.is6144.myappassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyAccount extends AppCompatActivity implements View.OnClickListener {


    Button btn1;
    Button btn_scan;
    TextView loggingOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        btn1 = findViewById(R.id.btn1);

        btn_scan = findViewById (R.id.btn_scan);
        loggingOut = (TextView)findViewById (R.id.logOut);
        loggingOut.setOnClickListener(this);




        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(MyAccount.this, ScannerClass.class);
                startActivity(a);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent i= new Intent(MyAccount.this ,SecondActivity.class);

                startActivity(i);
            }
        });

    }


    @Override
    public void onClick(View view) {
        Intent log = new Intent(MyAccount.this, MainActivity.class);
        startActivity(log);
    }
}

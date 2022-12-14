package com.is6144.myappassignment;



import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView register;
    private EditText textEmail, textPassword;
    private Button signIn;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register=(TextView) findViewById(R.id.register);
        register.setOnClickListener(this);

        signIn =(Button) findViewById(R.id.login);
        signIn.setOnClickListener(this);

        textEmail= (EditText) findViewById(R.id.email);
        textPassword = (EditText) findViewById(R.id.password);

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.register:
                startActivity(new Intent(this, register_activity.class));
                break;
            case R.id.login:
                userLogin();
                break;



        }
    }

    private void userLogin() {
        String email = textEmail.getText().toString().trim();
        String password = textPassword.getText().toString().trim();

        if(email.isEmpty()){
            textEmail.setError("Email is required!");
            textEmail.requestFocus();
            return;

        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            textEmail.setError("Please enter a valid email");
            textEmail.requestFocus();
            return;
        }

        if(password.isEmpty()){
            textPassword.setError("Password is required!");
            textPassword.requestFocus();
            return;

        }
        if(password.length() < 6){
            textPassword.setError("Min password length is 6 characters!");
            textPassword.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    // redirect to user profile
                    startActivity(new Intent(MainActivity.this, MyAccount.class));

                }else{
                    Toast.makeText(MainActivity.this, "Failed to login! Please check your credentials", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
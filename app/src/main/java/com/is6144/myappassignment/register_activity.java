package com.is6144.myappassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class register_activity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private EditText textFullName, textEmailAddress, textPassword;
    private TextView goBack;
    private Button btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        goBack = (TextView) findViewById(R.id.goBack);
        goBack.setOnClickListener(this);

        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);

        textFullName = (EditText) findViewById(R.id.fullName);
        textEmailAddress = (EditText) findViewById(R.id.email);
        textPassword = (EditText) findViewById(R.id.password2);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.goBack:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.btnRegister:
                btnRegister();
                break;


        }


    }

    private void btnRegister() {

        String email = textEmailAddress.getText().toString().trim();
        String passwordRegister = textPassword.getText().toString().trim();
        String fullName = textFullName.getText().toString().trim();

        if (fullName.isEmpty()) {
            textFullName.setError("Full name is required");
            textFullName.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            textEmailAddress.setError("Email address is required");
            textEmailAddress.requestFocus();
            return;

        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            textEmailAddress.setError("Please provide valid email");
            textEmailAddress.requestFocus();
            return;

        }

        if (passwordRegister.isEmpty()) {
            textPassword.setError("Password is required");
            textPassword.requestFocus();
            return;
        }

        if (passwordRegister.length() < 6){
            textPassword.setError("Min password length should be 6 characters");
            textPassword.requestFocus();
            return;
        }

            mAuth
                .createUserWithEmailAndPassword(email, passwordRegister)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            User user = new User(fullName, email);
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(register_activity.this, "User has been registered successfully!", Toast.LENGTH_SHORT).show();
                                                Intent in = new Intent(register_activity.this, MainActivity.class);
                                                startActivity(in);

                                                //redirect to login layout
                                            } else {
                                                Toast.makeText(register_activity.this, "Failed to register, try again!", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                        }
                    }
                });
    }

}
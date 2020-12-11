package com.example.ugdmedipal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
EditText mFullname, mEmail, mPassword, mRepass, mBloodgrp, mHeight, mWeight;
Button register;
String name, email, pass, repass, bg, height, weight;
FirebaseAuth mAuth;
DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Registered User");

        mFullname = (EditText)findViewById(R.id.fullname);
        mEmail = (EditText)findViewById(R.id.r_email);
        mPassword = (EditText)findViewById(R.id.r_password);
        mRepass = (EditText)findViewById(R.id.repassword);
        mBloodgrp = (EditText)findViewById(R.id.bloodgroup);
        mHeight = (EditText)findViewById(R.id.height);
        mWeight = (EditText)findViewById(R.id.weight);
        register = (Button)findViewById(R.id.r_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = mFullname.getText().toString();
                email = mEmail.getText().toString();
                pass = mPassword.getText().toString();
                repass = mRepass.getText().toString();
                bg = mBloodgrp.getText().toString();
                height = mHeight.getText().toString();
                weight = mWeight.getText().toString();
                if (TextUtils.isEmpty(name)){
                    mFullname.setError("Name is Required.");
                }
                if (TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required.");
                }
                if (TextUtils.isEmpty(pass)){
                    mPassword.setError("Password id Required");
                }
                if (TextUtils.isEmpty(repass) || !repass.equals(pass)){
                    mRepass.setError("Please re-enter your password correctly.");
                }
                if (pass.length() < 6){
                    mPassword.setError("Password must be >=6 Characters.");
                }
                mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this,"User Created.",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                        }else {
                            Toast.makeText(RegisterActivity.this,"Error:" + task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
                String id = databaseReference.push().getKey();
                RegisteredUser registeredUser = new RegisteredUser(name,bg,height,weight);
                databaseReference.child(id).setValue(registeredUser);
            }
        });
    }
}

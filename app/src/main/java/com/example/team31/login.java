package com.example.team31;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import kotlin.Suppress;

public class login extends AppCompatActivity {
    EditText mEmail,mpassword;
    Button mLoginBtn;
    TextView mCreateBtn;
    ProgressBar progressbar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEmail=findViewById(R.id.email);
        mpassword=findViewById(R.id.password);
        progressbar=findViewById(R.id.progressbar);
        mLoginBtn=findViewById(R.id.registerbtn);
        mCreateBtn=findViewById(R.id.createtext);
        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),register.class));


            }
        });
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString().trim();
                String password =mpassword.getText().toString().trim();
                if(TextUtils.isEmpty(email))
                {
                    mEmail.setError("email is required");
                    return;
                }
                if(TextUtils.isEmpty(password)) {
                    mpassword.setError("password is required");
                    return;
                }
                if(password.length() <6) {
                    mpassword.setError("password must be >= 6 character");
                    return;
                }
                progressbar.setVisibility(View.VISIBLE);


            }
        });
    }
}
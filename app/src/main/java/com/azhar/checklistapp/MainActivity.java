package com.azhar.checklistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.azhar.checklistapp.login.LoginActivity;
import com.azhar.checklistapp.register.RegisterActivity;

public class MainActivity extends AppCompatActivity {

    CardView cvLogin;
    CardView cvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cvLogin = findViewById(R.id.cvLogin);
        cvRegister = findViewById(R.id.cvRegister);

        cvLogin.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(i);
        });

        cvRegister.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(i);
        });


    }
}
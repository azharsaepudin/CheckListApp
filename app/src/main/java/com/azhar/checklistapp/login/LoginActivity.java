package com.azhar.checklistapp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.azhar.checklistapp.R;
import com.azhar.checklistapp.network.MyService;

public class LoginActivity extends AppCompatActivity {

    MyService myService;

    EditText edtUsernameLogin, edtPasswordLogin;

    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myService = new MyService(this);

        edtUsernameLogin = findViewById(R.id.edtUsernameLogin);
        edtPasswordLogin = findViewById(R.id.edtPasswordLogin);

        btnLogin.setOnClickListener(view -> loginUser());
    }

    private void loginUser(){

        String mUserNameLogin = edtUsernameLogin.getText().toString().trim();
        String mPasswordLogin = edtPasswordLogin.getText().toString().trim();

        try {

        //myService.getInstance().



        }catch (Exception e){

        }
    }
}
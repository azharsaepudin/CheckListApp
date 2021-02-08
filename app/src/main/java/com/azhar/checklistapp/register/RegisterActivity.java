package com.azhar.checklistapp.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.azhar.checklistapp.R;
import com.azhar.checklistapp.model.MyRegisterResponse;
import com.azhar.checklistapp.network.MyService;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    MyService myService;

    Button btnRegister;

    EditText edtEmail, edtPassword, edtUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        myService = new MyService(this);

        btnRegister = findViewById(R.id.btnRegister);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtUserName = findViewById(R.id.edtUserName);

        btnRegister.setOnClickListener(view -> registerSendJSON());

    }



    private void registerSendJSON(){

        String mEmail = edtEmail.getText().toString().trim();
        String mPass = edtPassword.getText().toString().trim();
        String mUserName = edtUserName.getText().toString().trim();

        try{


            JSONObject json = new JSONObject();
            json.put("email", mEmail);
            json.put("password", mPass);
            json.put("username", mUserName);


            myService.getInstance().registerUser(json.toString()).enqueue(new Callback<MyRegisterResponse>() {
                @Override
                public void onResponse(Call<MyRegisterResponse> call, Response<MyRegisterResponse> response) {

                    if (response.isSuccessful()){

                        MyRegisterResponse resp = response.body();

                        assert resp != null;
                        if (resp.getStatusCode() == 2000){

                            String message = resp.getMessage();

                            Toast.makeText(RegisterActivity.this, message + " Silakan kembali ke halaman login", Toast.LENGTH_SHORT).show();

                        }else{

                            String errorMessage = resp.getErrorMessage();

                            Toast.makeText(RegisterActivity.this, errorMessage+" Register Gagal", Toast.LENGTH_SHORT).show();
                        }

                    }

                }

                @Override
                public void onFailure(Call<MyRegisterResponse> call, Throwable t) {
                    Toast.makeText(RegisterActivity.this, t + " Register Gagal", Toast.LENGTH_SHORT).show();
                }
            });

        }catch (Exception e){
            Toast.makeText(RegisterActivity.this, e + " Register Gagal", Toast.LENGTH_SHORT).show();
        }
    }
}
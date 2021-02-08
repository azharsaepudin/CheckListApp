package com.azhar.checklistapp.network.interfaces;

import com.azhar.checklistapp.model.MyRegisterResponse;
import com.azhar.checklistapp.network.Config.Config;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface MyAppInterface {


    @Headers("Content-Type: application/json")
    @POST(Config.REGISTER_USER)
    Call<MyRegisterResponse> registerUser(@Body String body);

    @Headers("Content-Type: application/json")
    @POST(Config.LOGIN_USER)
    Call<MyRegisterResponse> loginUser(@Body String body);
}

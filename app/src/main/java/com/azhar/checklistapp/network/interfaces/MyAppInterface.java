package com.azhar.checklistapp.network.interfaces;

import com.azhar.checklistapp.model.MyRegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface MyAppInterface {


    @Headers("Content-Type: application/json")
    @POST("register")
    Call<MyRegisterResponse> registerUser(@Body String body);

}

package com.azhar.checklistapp.network;

import android.content.Context;

import com.azhar.checklistapp.network.Config.RetrofitBuilder;
import com.azhar.checklistapp.network.interfaces.MyAppInterface;

public class MyService {

    MyAppInterface myAppInterface;

    public MyService(Context context) {
        myAppInterface = RetrofitBuilder
                .builder(context)
                .create(MyAppInterface.class);
    }

    public MyAppInterface getInstance() {
        return myAppInterface;
    }

}

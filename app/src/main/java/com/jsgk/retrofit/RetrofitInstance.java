package com.jsgk.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    public static RetrofitInstance instance;
    APIgetrequest apigetrequest;
    String s1 = "https://reqres.in/";

    RetrofitInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(s1)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apigetrequest = retrofit.create(APIgetrequest.class);

    }


    public static RetrofitInstance getInstance() {

        if (instance == null) {
            instance = new RetrofitInstance();
        }
        return instance;
    }
}

package com.example.demoinovant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "https://klinq.com/rest/V1/";
    private static Retrofit instance;

    public  static Retrofit getClient(){

        if (instance==null){
            instance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  instance;
    }
}

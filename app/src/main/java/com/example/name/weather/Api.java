package com.example.name.weather;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Erik on 21/08/2017.
 */

public class Api {
    public static final String BASE_URL = "http://api.wunderground.com/";
    public static final String KEY = "38f9f855597455c1";


    private static Retrofit retrofit = null;

    public static Retrofit getApi(){
        if(retrofit == null){
            retrofit =new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return;
    }
}

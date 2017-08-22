package com.example.name.weather;


import com.example.name.weather.Model.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by Erik on 21/08/2017.
 */

public interface GetWeather {

    @GET("api/{key38f9f855597455c1/conditions/q/{city}.json")
    Call<Weather> getWeather (@Path("key") String key, @Path("city") String city );
}

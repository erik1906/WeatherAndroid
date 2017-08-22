package com.example.name.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.name.weather.Model.CurrentObservation;
import com.example.name.weather.Model.Weather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private GetWeather getWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWeather = Api.getApi().create(GetWeather.class);

        getCity("Mexico_city");


    }
    public void getCity(String cityName){
        Call<Weather> cityWeather = getWeather.getWeather( Api.KEY, "Mexico_City");
        cityWeather.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                CurrentObservation res = response.body().getCurrent_observation();
                Log.d("temp", res.getTempC().toString());
                Log.d("city", res.getDisplayLocation().getCity().toString());
                Log.d("weather", res.getWeather());
                Log.d("icon", res.getIcon());
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Sorry, can't refresh right now.",Toast.LENGTH_LONG).show();
            }
        });
    }
}

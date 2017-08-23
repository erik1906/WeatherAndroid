package com.example.name.weather;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.name.weather.Model.CurrentObservation;
import com.example.name.weather.Model.Weather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.name;

public class WeatherActivity extends AppCompatActivity {

    private GetWeather getWeather;
    private TextView tvCity;
    private TextView tvTemp;
    private TextView tvWeather;
    private ImageView ivBackground;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        tvCity = (TextView) findViewById(R.id.tvCity);
        tvTemp = (TextView) findViewById(R.id.tvTemp);
        tvWeather = (TextView) findViewById(R.id.tvWeather);
        ivBackground =(ImageView) findViewById(R.id.ivBackground);

        getWeather = Api.getApi().create(GetWeather.class);
        getCity(getIntent().getStringExtra("cityName"));
        setContentView(R.layout.activity_weather);
    }

    public void getCity(String cityName){
        Call<Weather> cityWeather = getWeather.getWeather( Api.KEY, cityName);
        cityWeather.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                CurrentObservation res = response.body().getCurrent_observation();
                tvCity.setText(res.getDisplayLocation().getCity().toString());
                tvTemp.setText(res.getTempC().toString());
                tvWeather.setText(res.getWeather());
                int resourceId = getBaseContext().getResources().getIdentifier(res.getIcon(), "drawable",
                        getBaseContext().getPackageName());
                Log.d("id",  res.getIcon());
                if(resourceId != 0) {
                    ivBackground.setBackgroundResource(resourceId);
                }else{
                    ivBackground.setBackgroundResource(R.drawable.sunny);
                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Toast.makeText(WeatherActivity.this,"Sorry, can't get the city weather.",Toast.LENGTH_LONG).show();
            }
        });
    }
}



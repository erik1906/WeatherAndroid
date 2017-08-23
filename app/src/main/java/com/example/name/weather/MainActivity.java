package com.example.name.weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.name.weather.Model.CurrentObservation;
import com.example.name.weather.Model.Weather;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    String [] cities = new String[]{"Mexico city", "Guatemala city", "Madrid Spain"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = (ListView) findViewById(R.id.listView);

        List<String> cities_list = new ArrayList<>(Arrays.asList(cities));
        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, cities_list);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos,
                                    long id) {
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                String city =(listView.getItemAtPosition(pos).toString());
                intent.putExtra("cityName", city);
                startActivity(intent);
            }
        });

        listView.setAdapter(adapter);



    }

}

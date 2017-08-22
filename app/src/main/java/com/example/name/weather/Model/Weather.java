package com.example.name.weather.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Erik on 21/08/2017.
 */

public class Weather implements Serializable {
    @SerializedName("current_observation")
    private CurrentObservation current_observation;

    public CurrentObservation getCurrent_observation() {
        return current_observation;
    }

    public void setCurrent_observation(CurrentObservation current_observation) {
        this.current_observation = current_observation;
    }
}

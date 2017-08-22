package com.example.name.weather.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Erik on 21/08/2017.
 */

public class CurrentObservation implements Serializable {
    @SerializedName("display_location")
    private DisplayLocation displayLocation;
    @SerializedName("temp_c")
    Float tempC;
    String icon;
    String weather;

    public DisplayLocation getDisplayLocation() {
        return displayLocation;
    }

    public void setDisplayLocation(DisplayLocation displayLocation) {
        this.displayLocation = displayLocation;
    }

    public Float getTempC() {
        return tempC;
    }

    public void setTempC(Float tempC) {
        this.tempC = tempC;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}

package com.example.name.weather.Model;

import java.io.Serializable;

/**
 * Created by Erik on 21/08/2017.
 */

public class DisplayLocation implements Serializable {
    String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

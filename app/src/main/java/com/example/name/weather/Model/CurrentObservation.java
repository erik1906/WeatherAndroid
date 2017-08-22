package com.example.name.weather.Model;

/**
 * Created by Erik on 21/08/2017.
 */

class CurrentObservation {
    private DisplayLocation displayLocation;
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
}

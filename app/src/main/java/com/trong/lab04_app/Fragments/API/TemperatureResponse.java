package com.trong.lab04_app.Fragments.API;

import com.google.gson.annotations.SerializedName;

public class TemperatureResponse {
        @SerializedName("temperature")
        private String _id;
        private double temperature, humidity;

    public TemperatureResponse() {
    }

    public TemperatureResponse(String _id, double temperature, double humidity) {
        this._id = _id;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
}

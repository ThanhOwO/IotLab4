package com.trong.lab04_app.Fragments.API;

import com.google.gson.annotations.SerializedName;

public class TemperatureResponse {
        @SerializedName("temperature")
        private String temperature;

        public String getTemperature() {
            return temperature;
        }
}

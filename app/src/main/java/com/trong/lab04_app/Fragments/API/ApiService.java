package com.trong.lab04_app.Fragments.API;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api/dhtdata")
    abstract // replace with your actual endpoint
    Call<TemperatureResponse> getTemperature();
}

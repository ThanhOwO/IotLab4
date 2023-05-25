package com.trong.lab04_app.Fragments.ControlFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.trong.lab04_app.Fragments.API.ApiService;
import com.trong.lab04_app.Fragments.API.TemperatureResponse;
import com.trong.lab04_app.R;

import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Temperature extends Fragment {

    private TextView temperatureTextView;
    private Handler handler;
    private Runnable runnable;
    private Timer timer;

    public Temperature() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_temperature, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        temperatureTextView = view.findViewById(R.id.temperatureTextView);
        handler = new Handler();

        // Create Retrofit instance
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8000/") // replace with your actual base URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create ApiService instance
        ApiService apiService = retrofit.create(ApiService.class);

        // Set up a timer to retrieve the temperature every 5 seconds
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // Make API request
                Call<TemperatureResponse> call = apiService.getTemperature();
                call.enqueue(new Callback<TemperatureResponse>() {
                    @Override
                    public void onResponse(Call<TemperatureResponse> call, Response<TemperatureResponse> response) {
                        if (response.isSuccessful()) {
                            TemperatureResponse temperatureResponse = response.body();
                            if (temperatureResponse != null) {
                                String temperature = temperatureResponse.getTemperature();
                                updateTemperature(temperature);
                            }
                        } else {
                            // Handle error case
                        }
                    }

                    @Override
                    public void onFailure(Call<TemperatureResponse> call, Throwable t) {
                        // Handle network failure
                    }
                });
            }
        }, 0, 5000); // Delay: 0 milliseconds, Period: 5000 milliseconds (5 seconds)
    }

    private void updateTemperature(final String temperature) {
        // Run the update on the UI thread
        handler.post(new Runnable() {
            @Override
            public void run() {
                temperatureTextView.setText(temperature);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Cancel the timer when the activity is destroyed
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }
}
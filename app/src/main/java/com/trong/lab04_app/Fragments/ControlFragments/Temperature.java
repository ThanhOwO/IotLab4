package com.trong.lab04_app.Fragments.ControlFragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.trong.lab04_app.Fragments.API.ApiService;
import com.trong.lab04_app.Fragments.API.DHTmodel;
import com.trong.lab04_app.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Temperature extends Fragment {

    private TextView temperatureTextView;


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

        //Retrofit builder

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.8:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService api = retrofit.create(ApiService.class);

        Call<DHTmodel> call = api.getTemperature();

        call.enqueue(new Callback<DHTmodel>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<DHTmodel> call, Response<DHTmodel> response) {
                if (!response.isSuccessful()) {
                    // Handle unsuccessful response
                    Toast.makeText(getContext(), "Failed to retrieve temperature data", Toast.LENGTH_SHORT).show();
                    return;
                }

                DHTmodel dhtModel = response.body();
                if (dhtModel != null) {
                    double data = dhtModel.getTemperature();
                    temperatureTextView.setText(String.valueOf(data));
                } else {
                    // Handle null response body
                    Toast.makeText(getContext(), "Temperature data is empty", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DHTmodel> call, Throwable t) {
                // Handle network failure
                Toast.makeText(getContext(), "Failed to connect to the server", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
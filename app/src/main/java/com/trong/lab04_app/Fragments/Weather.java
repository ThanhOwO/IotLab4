package com.trong.lab04_app.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.trong.lab04_app.R;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Weather extends Fragment {

    private EditText Input;
    private TextView Output;
    private Button button;

    public Weather() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Input = view.findViewById(R.id.input);
        Output = view.findViewById(R.id.data);
        button = view.findViewById(R.id.Exbutton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = Input.getText().toString();

                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OkHttpClient client = new OkHttpClient();
                        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
                        String requestBody = "{\"Humidity\": \"" + value + "\"}";
                        RequestBody body = RequestBody.create(requestBody, mediaType);
                        Request request = new Request.Builder()
                                .url("https://api-weather-tin.onrender.com/")
                                .post(body)
                                .build();

                        try {
                            Response response = client.newCall(request).execute();
                            if (response.isSuccessful()) {
                                String responseBody = response.body().string();
                                JsonParser parser = new JsonParser();
                                JsonObject jsonObject = parser.parse(responseBody).getAsJsonObject();

                                if (jsonObject.has("prediction")) {
                                    int prediction = jsonObject.get("prediction").getAsInt();
                                    Output.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            Output.setText("" + prediction);
                                        }
                                    });
                                } else {
                                }
                            } else {
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        });
    }
}
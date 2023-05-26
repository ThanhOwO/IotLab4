package com.trong.lab04_app.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.trong.lab04_app.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class Chart extends Fragment {

    BarChart humidityBarchart;
    LineChart tempLinechart, lightLinechart;


    public Chart() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lightLinechart = view.findViewById(R.id.lightlinechart);
        tempLinechart = view.findViewById(R.id.templinechart);
        humidityBarchart = view.findViewById(R.id.humibarchart);

        //humidity
        ArrayList<BarEntry> humidity = new ArrayList<>();
        humidity.add(new BarEntry(1, 78));
        humidity.add(new BarEntry(2, 81));
        humidity.add(new BarEntry(3, 74));
        humidity.add(new BarEntry(4, 76));
        humidity.add(new BarEntry(5, 73));
        humidity.add(new BarEntry(6, 69));
        humidity.add(new BarEntry(7, 70));
        humidity.add(new BarEntry(8, 72));
        humidity.add(new BarEntry(9, 74));
        humidity.add(new BarEntry(10, 78));

        BarDataSet barDataSet = new BarDataSet(humidity, "Humidity");
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData = new BarData(barDataSet);

        humidityBarchart.setFitBars(true);
        humidityBarchart.setData(barData);
        humidityBarchart.getDescription().setText("Bar chart");
        humidityBarchart.animateY(2000);

        //temperature
        List<Entry> temperature = new ArrayList<>();
        temperature.add(new Entry(1, 25.3f));
        temperature.add(new Entry(2, 26.2f));
        temperature.add(new Entry(3, 24.8f));
        temperature.add(new Entry(4, 25.0f));
        temperature.add(new Entry(5, 26.5f));
        temperature.add(new Entry(6, 24.8f));
        temperature.add(new Entry(7, 25.0f));
        temperature.add(new Entry(8, 26.5f));
        temperature.add(new Entry(9, 24.8f));
        temperature.add(new Entry(10, 24.8f));

        LineDataSet dataSet = new LineDataSet(temperature, "Temperature");
        dataSet.setColor(Color.GREEN);
        dataSet.setCircleColor(Color.BLUE);
        LineData lineData = new LineData(dataSet);

        tempLinechart.setData(lineData);

        Description description = new Description();
        description.setText("Temperature Chart");
        tempLinechart.setDescription(description);

        tempLinechart.invalidate();

        //Light
        List<Entry> light = new ArrayList<>();
        light.add(new Entry(1, 60));
        light.add(new Entry(2, 32));
        light.add(new Entry(3, 28));
        light.add(new Entry(4, 8));
        light.add(new Entry(5, 26));
        light.add(new Entry(6, 60));
        light.add(new Entry(7, 50));
        light.add(new Entry(8, 133));
        light.add(new Entry(9, 43));
        light.add(new Entry(10, 12));

        LineDataSet lightdataSet = new LineDataSet(light, "Light");
        lightdataSet.setColor(Color.YELLOW);
        lightdataSet.setCircleColor(Color.BLUE);
        LineData lightlineData = new LineData(lightdataSet);

        lightLinechart.setData(lightlineData);

        Description lightdescription = new Description();
        lightdescription.setText("light Chart");
        lightLinechart.setDescription(lightdescription);

        lightLinechart.invalidate();

    }
}
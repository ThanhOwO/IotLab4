package com.trong.lab04_app.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.trong.lab04_app.Adapters.ViewControlAdapter;
import com.trong.lab04_app.R;
import com.trong.lab04_app.ViewPageAdapter;


public class Control extends Fragment {

    private TabLayout optionTabLayout;
    private ViewPager controlViewPager;
    ViewControlAdapter controlAdapter;

    public Control() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_control, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init(view);
        addTabs();
    }

    private void init(View view){
        optionTabLayout = view.findViewById(R.id.optionLayout);
        controlViewPager = view.findViewById(R.id.controlViewpager);
    }

    private void addTabs(){
        optionTabLayout.addTab(optionTabLayout.newTab().setIcon(R.drawable.ic_temp));
        optionTabLayout.addTab(optionTabLayout.newTab().setIcon(R.drawable.ic_water));
        optionTabLayout.addTab(optionTabLayout.newTab().setIcon(R.drawable.ic_light));

        optionTabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        optionTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        controlAdapter = new ViewControlAdapter(getChildFragmentManager(), optionTabLayout.getTabCount());
        controlViewPager.setAdapter(controlAdapter);

        controlViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(optionTabLayout));

        optionTabLayout.getTabAt(0).setIcon(R.drawable.ic_temp_fill);

        optionTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                controlViewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()){
                    case 0:
                        optionTabLayout.getTabAt(0).setIcon(R.drawable.ic_temp_fill);
                        break;
                    case 1:
                        optionTabLayout.getTabAt(1).setIcon(R.drawable.ic_water_fill);
                        break;
                    case 2:
                        optionTabLayout.getTabAt(2).setIcon(R.drawable.ic_light_fill);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        optionTabLayout.getTabAt(0).setIcon(R.drawable.ic_temp);
                        break;
                    case 1:
                        optionTabLayout.getTabAt(1).setIcon(R.drawable.ic_water);
                        break;
                    case 2:
                        optionTabLayout.getTabAt(2).setIcon(R.drawable.ic_light);
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

                switch (tab.getPosition()){
                    case 0:
                        optionTabLayout.getTabAt(0).setIcon(R.drawable.ic_temp_fill);
                        break;
                    case 1:
                        optionTabLayout.getTabAt(1).setIcon(R.drawable.ic_water_fill);
                        break;
                    case 2:
                        optionTabLayout.getTabAt(2).setIcon(R.drawable.ic_light_fill);
                        break;
                }

            }
        });

    }
}
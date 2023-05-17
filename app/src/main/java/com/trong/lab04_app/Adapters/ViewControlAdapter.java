package com.trong.lab04_app.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.trong.lab04_app.Fragments.ControlFragments.Humidity;
import com.trong.lab04_app.Fragments.ControlFragments.Light;
import com.trong.lab04_app.Fragments.ControlFragments.Temperature;

public class ViewControlAdapter extends FragmentStatePagerAdapter {
    public ViewControlAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Temperature();
            case 1:
                return new Humidity();
            case 2:
                return new Light();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}

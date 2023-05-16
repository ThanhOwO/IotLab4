package com.trong.lab04_app;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.trong.lab04_app.Fragments.Chart;
import com.trong.lab04_app.Fragments.Control;
import com.trong.lab04_app.Fragments.Home;
import com.trong.lab04_app.Fragments.Info;

public class ViewPageAdapter extends FragmentStatePagerAdapter{

    public ViewPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Home();
            case 1:
                return new Control();
            case 2:
                return new Chart();
            case 3:
                return new Info();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

}

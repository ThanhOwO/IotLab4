package com.trong.lab04_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    ViewPageAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        addTabs();
    }

    private void init(){

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
    }

    //Create tab layout for UI
    private void addTabs(){
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_home));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_control));
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_chart));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_dash));


        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        pagerAdapter = new ViewPageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_fill);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()){
                    case 0:
                        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_fill);
                        break;
                    case 1:
                        tabLayout.getTabAt(1).setIcon(R.drawable.ic_control_fill);
                        break;
                    case 2:
                        tabLayout.getTabAt(3).select();// do nothing since the empty tab cannot be selected
                        break;
                    case 3:
                        tabLayout.getTabAt(3).setIcon(R.drawable.ic_chart_fill);
                        break;
                    case 4:
                        tabLayout.getTabAt(4).setIcon(R.drawable.ic_menu_fill);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
                        break;
                    case 1:
                        tabLayout.getTabAt(1).setIcon(R.drawable.ic_control);
                        break;
                    case 2:
                        // do nothing since the empty tab cannot be selected
                        break;
                    case 3:
                        tabLayout.getTabAt(3).setIcon(R.drawable.ic_chart);
                        break;
                    case 4:
                        tabLayout.getTabAt(4).setIcon(R.drawable.ic_dash);
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

                switch (tab.getPosition()){
                    case 0:
                        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_fill);
                        break;
                    case 1:
                        tabLayout.getTabAt(1).setIcon(R.drawable.ic_control_fill);
                        break;
                    case 2:
                        // do nothing since the empty tab cannot be selected
                        break;
                    case 3:
                        tabLayout.getTabAt(3).setIcon(R.drawable.ic_chart_fill);
                        break;
                    case 4:
                        tabLayout.getTabAt(4).setIcon(R.drawable.ic_menu_fill);
                        break;
                }

            }
        });
    }
}
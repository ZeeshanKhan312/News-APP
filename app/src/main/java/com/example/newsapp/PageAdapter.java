package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {
    int count;
    public PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        count=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1: {
//                SportsFragment fragment = new SportsFragment();
//                Bundle data = new Bundle();
//                data.putString("Category", "Sports");
//                fragment.setArguments(data);
//                return fragment;
                return new SportsFragment();
            }
            case 2:
                return new BusinessFragment();
            case 3:
                return new EntertainmentFragment();
            case 4:
                return new HealthFragment();
            case 5:
                return new ScienceFragment();
            case 6:
                return new TechnologyFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return count;
    }
}

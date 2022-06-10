package com.slinky.foodies;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.slinky.foodies.data.Restaurant;

import java.util.ArrayList;
import java.util.Collections;

public class FeaturedPager extends FragmentPagerAdapter {
    ArrayList<Restaurant> restaurants;

    public FeaturedPager(@NonNull FragmentManager fm) {
        super(fm);
        this.restaurants = Utilities.getFeaturedRestaurants();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1:
                return new FeatureFragment(restaurants.get(1));
            case 2:
                return new FeatureFragment(restaurants.get(2));
            default:
                return new FeatureFragment(restaurants.get(0));
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "restaurant1";
        } else if (position == 1) {
            return "restaurant2";
        }else if (position == 2) {
            return "restaurant3";
        }
        return super.getPageTitle(position);
    }

}

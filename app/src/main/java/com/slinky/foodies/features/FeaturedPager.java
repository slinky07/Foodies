package com.slinky.foodies.features;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.slinky.foodies.Utilities;
import com.slinky.foodies.data.Restaurant;

import java.util.ArrayList;

public class FeaturedPager extends FragmentPagerAdapter {
    ArrayList<Restaurant> restaurants;

    public FeaturedPager(@NonNull FragmentManager fm) {
        super(fm);

        // get featured restaurants list when constructor is called.
        this.restaurants = Utilities.getFeaturedRestaurants();
        //TODO: make the 3 dots to show what page is currently selected.
    }

    /**
     * method that returns the fragment at the given position in featured list.
     * @param position the position of the fragment in the featured list.
     * @return the fragment at the given position.
     */
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

    /**
     * method that returns the number of fragments in featured list.
     * @return 3
     */
    @Override
    public int getCount() {
        return 3;
    }

    /**
     * method that returns the title of the fragment at the given position.
     * @param position the position of the fragment in the featured list.
     * @return the title of the fragment at the given position.
     */
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

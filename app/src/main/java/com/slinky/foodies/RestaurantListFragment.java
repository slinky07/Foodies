package com.slinky.foodies;

import com.slinky.foodies.data.Restaurant;

import java.util.ArrayList;

public class RestaurantListFragment extends androidx.fragment.app.ListFragment {
    ArrayList<Restaurant> restaurants = DataSource.getRestaurantList();
}

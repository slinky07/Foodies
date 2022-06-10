package com.slinky.foodies;

import android.content.DialogInterface;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.slinky.foodies.data.Restaurant;

import java.util.ArrayList;


public class RestaurantListFragment extends androidx.fragment.app.ListFragment {
    ArrayList<Restaurant> restaurants;

    public RestaurantListFragment(ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
    public RestaurantListFragment() {
        this.restaurants = DataSource.getRestaurantList();
    }

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        this.setListAdapter(new RestaurantListAdapter(getActivity(), restaurants));

        return inflater.inflate(R.layout.restaurant_list_fragment, container, false);
    }

    // method to deflate the list view in the fragment
    public void deflateListView() {
        this.setListAdapter(null);
    }

}
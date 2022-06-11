package com.slinky.foodies.listview;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.slinky.foodies.R;
import com.slinky.foodies.data.DataSource;
import com.slinky.foodies.data.Restaurant;

import java.util.ArrayList;

public class RestaurantListFragment extends androidx.fragment.app.ListFragment {
    ArrayList<Restaurant> restaurants;

    /**
     * Create a new instance of RestaurantListFragment with the given restaurants list.
     * @param restaurants The list of restaurants to display.
     */
    public RestaurantListFragment(ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    /**
     * new instance with default restaurants list from DataSource.
     */
    public RestaurantListFragment() {
        this.restaurants = DataSource.getRestaurantList();
    }

    /**
     * Inflate the layout for this fragment with help of my base adapter
     */
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.setListAdapter(new RestaurantListAdapter(getActivity(), restaurants));
        return inflater.inflate(R.layout.restaurant_list_fragment, container, false);
    }

    /**
     * this method is called when user desire to show a new list of restaurants from menu.
     * setting adapter to null will allow the list to be refreshed.
     */
    public void deflateListView() {
        this.setListAdapter(null);
    }

}
package com.slinky.foodies;

import android.widget.TextView;

import com.slinky.foodies.data.Restaurant;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Utilities extends DataSource {
    private static ArrayList<Restaurant> copyRestaurants = new ArrayList<>(DataSource.getRestaurantList());
    private static ArrayList<Restaurant> featuredRestaurants = new ArrayList<>();

    public void setTextView(TextView textView, String text) {
        textView.setText(text);
    }

    // get Featured Restaurants from DataSource static list o(n)
    public static ArrayList<Restaurant> getFeaturedRestaurants() {

        for (Restaurant restaurant : getRestaurantList()) {
            if (restaurant.isFeatured()) {
                featuredRestaurants.add(restaurant);
            }
        }
        Collections.shuffle(featuredRestaurants);
        return featuredRestaurants;
    }

    // get vegan Restaurants from DataSource static list o(n)
    public static ArrayList<Restaurant> getVeganRestaurants() {
        ArrayList<Restaurant> veganRestaurants = new ArrayList<>();
        for (Restaurant restaurant : getRestaurantList()) {
            if (restaurant.isVegetarian()) {
                veganRestaurants.add(restaurant);
            }
        }
        return veganRestaurants;
    }

    // get Restaurants from DataSource static list
    // and sort by rating descending with quicksort o(n log n)

    public static ArrayList<Restaurant> getByRatings() {
        return sortByRating(copyRestaurants);
    }

    private static ArrayList<Restaurant> sortByRating(ArrayList<Restaurant> restaurants) {
        if (restaurants.size() <= 1) {
            return restaurants;
        }
        Restaurant pivot = restaurants.get(0);
        ArrayList<Restaurant> left = new ArrayList<>();
        ArrayList<Restaurant> right = new ArrayList<>();
        for (int i = 1; i < restaurants.size(); i++) {
            if (restaurants.get(i).getRating() > pivot.getRating()) {
                left.add(restaurants.get(i));
            } else {
                right.add(restaurants.get(i));
            }
        }
        left = sortByRating(left);
        right = sortByRating(right);
        left.add(pivot);
        left.addAll(right);
        return left;
    }

    // get Restaurants from DataSource static list
    // and sort by min price ascending with quicksort o(n log n)
    public static ArrayList<Restaurant> getByPriceAsc() {
        return sortByPriceAsc(copyRestaurants);
    }

    private static ArrayList<Restaurant> sortByPriceAsc(ArrayList<Restaurant> restaurants) {
        if (restaurants.size() <= 1) {
            return restaurants;
        }
        Restaurant pivot = restaurants.get(0);
        ArrayList<Restaurant> left = new ArrayList<>();
        ArrayList<Restaurant> right = new ArrayList<>();
        for (int i = 1; i < restaurants.size(); i++) {
            if (restaurants.get(i).getMinPrice() < pivot.getMinPrice()) {
                left.add(restaurants.get(i));
            } else {
                right.add(restaurants.get(i));
            }
        }
        left = sortByPriceAsc(left);
        right = sortByPriceAsc(right);
        left.add(pivot);
        left.addAll(right);
        return left;
    }

    // get Restaurants from DataSource static list
    // and sort by min price descending with quicksort o(n log n)
    public static ArrayList<Restaurant> getByPriceDesc() {
        return sortByPriceDesc(copyRestaurants);
    }

    private static ArrayList<Restaurant> sortByPriceDesc(ArrayList<Restaurant> restaurants) {
        if (restaurants.size() <= 1) {
            return restaurants;
        }
        Restaurant pivot = restaurants.get(0);
        ArrayList<Restaurant> left = new ArrayList<>();
        ArrayList<Restaurant> right = new ArrayList<>();
        for (int i = 1; i < restaurants.size(); i++) {
            if (restaurants.get(i).getMinPrice() > pivot.getMinPrice()) {
                left.add(restaurants.get(i));
            } else {
                right.add(restaurants.get(i));
            }
        }
        left = sortByPriceDesc(left);
        right = sortByPriceDesc(right);
        left.add(pivot);
        left.addAll(right);
        return left;
    }
}

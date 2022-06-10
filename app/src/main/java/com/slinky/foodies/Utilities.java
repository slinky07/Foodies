package com.slinky.foodies;

import android.widget.TextView;

import com.slinky.foodies.data.Restaurant;

import java.util.ArrayList;

public class Utilities extends DataSource {

    public void setTextView(TextView textView, String text) {
        textView.setText(text);
    }

    // set rating in TextView from Restaurant object
    public void setRating(TextView textView, Restaurant restaurant) {
        textView.setText(String.valueOf(restaurant.getRating()));
    }

    // get Featured Restaurants from DataSource static list o(n)
    public static ArrayList<Restaurant> getFeaturedRestaurants() {
        ArrayList<Restaurant> featuredRestaurants = new ArrayList<>();
        for (Restaurant restaurant : getRestaurantList()) {
            if (restaurant.isFeatured()) {
                featuredRestaurants.add(restaurant);
            }
        }
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
    ArrayList<Restaurant> unsortedRestaurants = new ArrayList<>();
        return sortByRating(unsortedRestaurants);
    }

    private static ArrayList<Restaurant> sortByRating(ArrayList<Restaurant> restaurants) {
        if (restaurants.size() > 1) {
            int pivot = restaurants.size() / 2;
            ArrayList<Restaurant> left = new ArrayList<>();
            ArrayList<Restaurant> right = new ArrayList<>();
            for (int i = 0; i < restaurants.size(); i++) {
                if (i != pivot) {
                    if (restaurants.get(i).getRating() > restaurants.get(pivot).getRating()) {
                        left.add(restaurants.get(i));
                    } else {
                        right.add(restaurants.get(i));
                    }
                }
            }
            sortByRating(left);
            sortByRating(right);
            restaurants.clear();
            restaurants.addAll(left);
            restaurants.add(restaurants.get(pivot));
            restaurants.addAll(right);
        }
        return restaurants;
    }

    // get Restaurants from DataSource static list
    // and sort by price ascending with quicksort o(n log n)
    public static ArrayList<Restaurant> getByPrice() {
        ArrayList<Restaurant> unsortedRestaurants = new ArrayList<>();
        return sortByPriceAsc(unsortedRestaurants);
    }

    private static ArrayList<Restaurant> sortByPriceAsc(ArrayList<Restaurant> restaurants) {
        if (restaurants.size() > 1) {
            int pivot = restaurants.size() / 2;
            ArrayList<Restaurant> left = new ArrayList<>();
            ArrayList<Restaurant> right = new ArrayList<>();
            for (int i = 0; i < restaurants.size(); i++) {
                if (i != pivot) {
                    if (restaurants.get(i).getMinPrice() < restaurants.get(pivot).getMinPrice()) {
                        left.add(restaurants.get(i));
                    } else {
                        right.add(restaurants.get(i));
                    }
                }
            }
            sortByPriceAsc(left);
            sortByPriceAsc(right);
            restaurants.clear();
            restaurants.addAll(left);
            restaurants.add(restaurants.get(pivot));
            restaurants.addAll(right);
        }
        return restaurants;
    }

    // get Restaurants from DataSource static list
    // and sort by price descending with quicksort o(n log n)
    public static ArrayList<Restaurant> getByPriceDesc() {
        ArrayList<Restaurant> unsortedRestaurants = new ArrayList<>();
        return sortByPriceDesc(unsortedRestaurants);
    }

    private static ArrayList<Restaurant> sortByPriceDesc(ArrayList<Restaurant> restaurants) {
        if (restaurants.size() > 1) {
            int pivot = restaurants.size() / 2;
            ArrayList<Restaurant> left = new ArrayList<>();
            ArrayList<Restaurant> right = new ArrayList<>();
            for (int i = 0; i < restaurants.size(); i++) {
                if (i != pivot) {
                    if (restaurants.get(i).getMinPrice() > restaurants.get(pivot).getMinPrice()) {
                        left.add(restaurants.get(i));
                    } else {
                        right.add(restaurants.get(i));
                    }
                }
            }
            sortByPriceDesc(left);
            sortByPriceDesc(right);
            restaurants.clear();
            restaurants.addAll(left);
            restaurants.add(restaurants.get(pivot));
            restaurants.addAll(right);
        }
        return restaurants;
    }
}

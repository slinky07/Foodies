package com.slinky.foodies;

import com.slinky.foodies.data.DataSource;
import com.slinky.foodies.data.Restaurant;

import java.util.ArrayList;
import java.util.Collections;
//TODO : add a 5th sorting option
public class Utilities extends DataSource {
    private static ArrayList<Restaurant> copyRestaurants = new ArrayList<>(DataSource.getRestaurantList());
    private static ArrayList<Restaurant> featuredRestaurants = new ArrayList<>();

    /**
     * getFeaturedRestaurants returns a list of restaurants that are featured. O(N)
     * <br>
     * note that the list is being shuffled to randomize the order of the featured restaurants
     * at every call of this method. this should be called only once at the beginning of the app.
     * @return ArrayList<Restaurant> of featured restaurants.
     */
    public static ArrayList<Restaurant> getFeaturedRestaurants() {

        for (Restaurant restaurant : getRestaurantList()) {
            if (restaurant.isFeatured()) {
                featuredRestaurants.add(restaurant);
            }
        }
        Collections.shuffle(featuredRestaurants);
        return featuredRestaurants;
    }

    /**
     * sends vegan restaurants list. O(N)
     * @return ArrayList<Restaurant> of vegan restaurants.
     */
    public static ArrayList<Restaurant> getVeganRestaurants() {
        ArrayList<Restaurant> veganRestaurants = new ArrayList<>();
        for (Restaurant restaurant : getRestaurantList()) {
            if (restaurant.isVegetarian()) {
                veganRestaurants.add(restaurant);
            }
        }
        return veganRestaurants;
    }

    // make a list of all restaurants located in montreal
    public static ArrayList<Restaurant> getMontrealRestaurants() {
        ArrayList<Restaurant> montrealRestaurants = new ArrayList<>();
        for (Restaurant restaurant : getRestaurantList()) {
            if (restaurant.getCity().equals("Montreal")) {
                montrealRestaurants.add(restaurant);
            }
        }
        return montrealRestaurants;
    }

    /**
     * sorts restaurants by name with quick sort O(n log n)
     * @return sorted restaurants by rating.
     */
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

    /**
     * sorts restaurants by price ascending with quick sort O(n log n)
     * @return sorted restaurants by price ascending.
     */
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

    /**
     * sorts restaurants by price descending with quick sort O(n log n)
     * @return sorted restaurants by price descending.
     */
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

package com.slinky.foodies.data;

public abstract class RestaurantInterface {

    public static String makeTitle(Restaurant restaurant) {
        return restaurant.getName() + ", " +
                restaurant.getAddress1() + ", " +
                restaurant.getCity();
    }

    public static String makeDeliveryLine(Restaurant restaurant) {
        return "$" +
                restaurant.getDeliveryFee() + " Delivery Fee^ - " +
                restaurant.getDeliveryTime() + " min";
    }

    public static String makeFeaturedTitle(Restaurant restaurant) {
        return restaurant.getName() + "\n" +
                restaurant.getAddress1();
    }
}

package com.slinky.foodies.data;

public abstract class AbstractRestaurant {

    /**
     * send string to make a title for the restaurant ListView.
     * @param restaurant the restaurant to make a title for.
     * @return the title of the restaurant.
     */
    public static String makeTitle(Restaurant restaurant) {
        return restaurant.getName() + ", " +
                restaurant.getAddress1() + ", " +
                restaurant.getCity();
    }

    /**
     * send string to make a Delivery line for the restaurant ListView.
     * @param restaurant the restaurant to make a Delivery line for.
     * @return the Delivery line of the restaurant.
     */
    public static String makeDeliveryLine(Restaurant restaurant) {
        return "$" +
                restaurant.getDeliveryFee() + " Delivery Fee^ - " +
                restaurant.getDeliveryTime() + " min";
    }

    /**
     * send string to make Feature line for the restaurant ListView.
     * @param restaurant the restaurant to make a Feature line for.
     * @return the Feature line of the restaurant.
     */
    public static String makeFeaturedTitle(Restaurant restaurant) {
        return restaurant.getName() + "\n" +
                restaurant.getAddress1();
    }
}

package com.slinky.foodies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.slinky.foodies.data.Restaurant;
import com.slinky.foodies.features.FeaturedPager;
import com.slinky.foodies.listview.RestaurantListFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setIds();
        setViewPager();
        setListFragment();
    }

    private void setIds() {
        viewPager = findViewById(R.id.picture_pager);
    }

    /** Sets the view pager to the featured restaurants */
    private void setViewPager() {
        FeaturedPager featuredPagerAdapter = new FeaturedPager(getSupportFragmentManager());
        viewPager.setAdapter(featuredPagerAdapter);
    }

    /**
     * This method sets the list fragment to the main activity
     * @param menu The menu to be inflated
     * @return true if the menu is inflated
     */
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * This method is called when the user clicks on the search icon in the action bar.
     * @param item The menu item that was clicked.
     * @return true if the event was handled, false otherwise.
     */
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {

        int id = item.getItemId();

        switch(id){
            case R.id.sort_low_high_ID:
                setListFragment(Utilities.getByPriceAsc());
//                Toast.makeText(this, "Low to High", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sort_high_low_ID:
                setListFragment(Utilities.getByPriceDesc());
//                Toast.makeText(this, "High to Low", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sort_rating_ID:
                setListFragment(Utilities.getByRatings());
//                Toast.makeText(this, "Rating", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sort_vegan_ID:
                setListFragment(Utilities.getVeganRestaurants());
//                Toast.makeText(this, "Vegan", Toast.LENGTH_SHORT).show();
                break;
            case R.id.show_montreal_list_ID:
                setListFragment(Utilities.getMontrealRestaurants());
//                Toast.makeText(this, "Montreal", Toast.LENGTH_SHORT).show();
                break;
            case R.id.show_back_default_list_ID:
                clearList();
                setListFragment();
//                Toast.makeText(this, "Default", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * This method sets the list fragment to the given list of restaurants with default arraylist.
     */
    private void setListFragment() {
        RestaurantListFragment restaurantListFragment = new RestaurantListFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.list_container, restaurantListFragment).commit();
    }

    /**
     * overloaded method to set the list fragment with a list of restaurants
     * @param restaurants the list of restaurants to be displayed
     */
    private void setListFragment(ArrayList<Restaurant> restaurants) {
        clearList();
        RestaurantListFragment restaurantListFragment = new RestaurantListFragment(restaurants);
        getSupportFragmentManager().beginTransaction().add(R.id.list_container, restaurantListFragment).commit();
    }

    /**
     * This method clears the list fragment so that new list of restaurants can be displayed.
     */
    public void clearList() {
        RestaurantListFragment restaurantListFragment = (RestaurantListFragment) getSupportFragmentManager().findFragmentById(R.id.list_container);
        assert restaurantListFragment != null;
        restaurantListFragment.deflateListView();
    }


}


package com.slinky.foodies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.slinky.foodies.data.Restaurant;

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

    private void setViewPager() {
        FeaturedPager featuredPagerAdapter = new FeaturedPager(getSupportFragmentManager());
        viewPager.setAdapter(featuredPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {

        int id = item.getItemId();

        switch(id){
            case R.id.sort_low_high_ID:
                setListFragment(Utilities.getByPriceAsc());
                Toast.makeText(this, "Low to High", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sort_high_low_ID:
                setListFragment(Utilities.getByPriceDesc());
                Toast.makeText(this, "High to Low", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sort_rating_ID:
                setListFragment(Utilities.getByRatings());
                Toast.makeText(this, "Rating", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sort_vegan_ID:
                setListFragment(Utilities.getVeganRestaurants());
                Toast.makeText(this, "Vegan", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setListFragment() {
        RestaurantListFragment restaurantListFragment = new RestaurantListFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.list_container, restaurantListFragment).commit();
    }
    private void setListFragment(ArrayList<Restaurant> restaurants) {
        clearList();
        RestaurantListFragment restaurantListFragment = new RestaurantListFragment(restaurants);
        getSupportFragmentManager().beginTransaction().add(R.id.list_container, restaurantListFragment).commit();
    }

    // remove all items in list
    public void clearList() {
        RestaurantListFragment restaurantListFragment = (RestaurantListFragment) getSupportFragmentManager().findFragmentById(R.id.list_container);
        assert restaurantListFragment != null;
        restaurantListFragment.deflateListView();
    }


}


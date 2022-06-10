package com.slinky.foodies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.picture_pager);
        FeaturedPager featuredPagerAdapter = new FeaturedPager(getSupportFragmentManager());
        viewPager.setAdapter(featuredPagerAdapter);

        RestaurantListFragment restaurantListFragment = new RestaurantListFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.list_container, restaurantListFragment).commit();

    }

}
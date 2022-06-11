package com.slinky.foodies.features;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.slinky.foodies.R;
import com.slinky.foodies.data.Restaurant;


public class FeatureFragment extends Fragment {
    String textView;
    int imageView;

    /**
     * Create a new instance of FeatureFragment with the given restaurant.
     * @param restaurant The restaurant to display in ViewPager.
     */
    public FeatureFragment(Restaurant restaurant) {
        this.imageView = restaurant.getBannerImage();
        this.textView = Restaurant.makeFeaturedTitle(restaurant);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.feature_pager_layout, container, false);

        ImageView imageView = v.findViewById(R.id.feature_IV);
        TextView textView = v.findViewById(R.id.feature_TV);

        imageView.setImageResource(this.imageView);
        textView.setText(this.textView);

        return v;
    }
}
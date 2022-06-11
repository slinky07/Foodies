package com.slinky.foodies.listview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.slinky.foodies.R;
import com.slinky.foodies.data.Restaurant;

import java.util.List;

public class RestaurantListAdapter extends BaseAdapter {
    List<Restaurant> data;
    Context context;

    public RestaurantListAdapter(Context context, List<Restaurant> data){
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View newView = View.inflate(context, R.layout.restaurant_adapter_layout, null);

        ImageView imageView = newView.findViewById(R.id.restaurant_IV);
        TextView titleTV = newView.findViewById(R.id.restaurant_title_TV);
        TextView deliveryTV = newView.findViewById(R.id.restaurant_delivery_TV);
        TextView rating = newView.findViewById(R.id.restaurant_rating_TV);

        ImageView veganIcon = newView.findViewById(R.id.restaurant_vegan_icon_TV);

        Restaurant restaurant = data.get(position);

        imageView.setImageResource(restaurant.getBannerImage());
        titleTV.setText(Restaurant.makeTitle(restaurant));
        deliveryTV.setText(Restaurant.makeDeliveryLine(restaurant));
        rating.setText(String.valueOf(restaurant.getRating()));

        if(!restaurant.isVegetarian()){
            veganIcon.setVisibility(View.GONE); // hide the icon if the restaurant is not vegetarian
        }

        return newView;
    }
}

package com.example.android.foodlocator;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zainabiftikharmalhi on 2017-05-16.
 */

public class HotelAdapter  extends ArrayAdapter<Hotel> {
    /**
     * The part of the location string from the USGS service that we use to determine
     * whether or not there is a location offset present ("5km N of Cairo, Egypt").
     */
    private static final String LOCATION_SEPARATOR = " of ";


    public HotelAdapter(Context context, List<Hotel> hotels) {
        super(context, 0, hotels);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Find the earthquake at the given position in the list of earthquakes
        Hotel currentHotel = getItem(position);

        //Setting the Hotel Name
        TextView hotelNameTextView = (TextView) listItemView.findViewById(R.id.Hotel_name_text_view);
        hotelNameTextView.setText(currentHotel.getHotelName());

        //Setting the Hotel Address
        TextView hotelDistanceTextView = (TextView) listItemView.findViewById(R.id.Hotel_address_text_view);
        hotelDistanceTextView.setText(currentHotel.getAddress());

        //Setting whether the hotel is closed or open
        ImageView hotelopenimage = (ImageView) listItemView.findViewById(R.id.open);
        hotelopenimage.setImageResource(R.drawable.not);
        if(currentHotel.getOpened()=="true")
        {
            hotelopenimage.setImageResource(R.drawable.open);
        }
        if(currentHotel.getOpened()=="false")
        {
            hotelopenimage.setImageResource(R.drawable.close);
        }



        // Find the TextView with view ID magnitude
        TextView ratingView = (TextView) listItemView.findViewById(R.id.rating);
        ratingView.setText(currentHotel.getRating());

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable ratingCircle = (GradientDrawable) ratingView.getBackground();
        // Get the appropriate background color based on the current rating magnitude
        int ratingColor = getRatingColor(Double.parseDouble(currentHotel.getRating()));
        // Set the color on the rating circle
        ratingCircle.setColor(ratingColor);


        return listItemView;
    }


    private int getRatingColor(double rating) {
        int ratingColorResourceId;
        int ratingFloor = (int) Math.floor(rating);
        switch (ratingFloor) {
            case 0:
            case 1:
                ratingColorResourceId = R.color.rating1;
                break;
            case 2:
                ratingColorResourceId = R.color.rating2;
                break;
            case 3:
                ratingColorResourceId = R.color.rating3;
                break;
            case 4:
                ratingColorResourceId = R.color.rating4;
                break;
            case 5:
                ratingColorResourceId = R.color.rating5;
                break;
            case 6:
                ratingColorResourceId = R.color.rating6;
                break;
            case 7:
                ratingColorResourceId = R.color.rating7;
                break;
            case 8:
                ratingColorResourceId = R.color.rating8;
                break;
            case 9:
                ratingColorResourceId = R.color.rating9;
                break;
            default:
                ratingColorResourceId = R.color.rating10;
                break;
        }

        return ContextCompat.getColor(getContext(), ratingColorResourceId);
    }

}

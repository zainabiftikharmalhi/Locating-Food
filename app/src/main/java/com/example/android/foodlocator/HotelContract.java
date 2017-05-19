package com.example.android.foodlocator;

import android.provider.BaseColumns;

/**
 * Created by zainabiftikharmalhi on 2017-05-16.
 */

public class HotelContract {


    private HotelContract() {}

    public static final class HotelEntry implements BaseColumns {

        public final static String TABLE_NAME = "hotels";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_HOTEL_NAME ="name";
        public final static String COLUMN_HOTEL_DISTANCE = "distance";
        public final static String COLUMN_HOTEL_RATING = "rating";
        public final static String COLUMN_HOTEL_PRICE = "price";
        public final static String COLUMN_HOTEL_CLOSE = "close";
        public final static String COLUMN_HOTEL_OPEN = "open";
        public final static String COLUMN_HOTEL_LATITUDE = "latitude";
        public final static String COLUMN_HOTEL_LONGITUDE = "longitiude";
        public final static String COLUMN_HOTEL_CATEGORY = "category";

    }

}


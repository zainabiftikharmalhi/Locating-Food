package com.example.android.foodlocator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.android.foodlocator.HotelContract.HotelEntry;


/**
 * Created by zainabiftikharmalhi on 2017-05-16.
 */

public class HotelDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = HotelDbHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "hotels.db";
    private static final int DATABASE_VERSION = 1;

    public HotelDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_HOTELS_TABLE = "CREATE TABLE " + HotelEntry.TABLE_NAME + " ("
                + HotelEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HotelEntry.COLUMN_HOTEL_NAME + " TEXT NOT NULL, "
                + HotelEntry.COLUMN_HOTEL_DISTANCE + " DOUBLE NOT NULL, "
                + HotelEntry.COLUMN_HOTEL_LATITUDE + " DOUBLE NOT NULL, "
                + HotelEntry.COLUMN_HOTEL_LONGITUDE + " DOUBLE NOT NULL, "
                + HotelEntry.COLUMN_HOTEL_CLOSE + " TEXT NOT NULL, "
                + HotelEntry.COLUMN_HOTEL_OPEN + " TEXT NOT NULL, "
                + HotelEntry.COLUMN_HOTEL_PRICE + " TEXT NOT NULL, "
                + HotelEntry.COLUMN_HOTEL_CATEGORY + " TEXT NOT NULL, "
                + HotelEntry.COLUMN_HOTEL_RATING + " TEXT NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_HOTELS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }
}

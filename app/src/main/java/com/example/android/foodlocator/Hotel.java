package com.example.android.foodlocator;

/**
 * Created by zainabiftikharmalhi on 2017-05-16.
 */

public class Hotel {

      private String rating;
      private String hotelName;
      private String address;
      private String lng;
      private String lat;
      private String opened;

    public String getOpened() {
        return opened;
    }

    public void setOpened(String opened) {
        this.opened = opened;
    }

    public Hotel(String rating, String hotelName, String address, String lng, String lat, String opened) {
        this.rating = rating;
        this.hotelName = hotelName;
        this.address = address;
        this.lng = lng;
        this.lat = lat;
        this.opened = opened;
    }

    public String getRating() {

        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

}

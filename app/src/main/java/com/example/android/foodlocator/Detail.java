package com.example.android.foodlocator;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;

import static android.R.attr.category;
import static android.R.attr.radius;
import static android.R.attr.type;
import static android.os.Build.VERSION_CODES.M;

public class Detail extends AppCompatActivity implements
        GoogleApiClient.ConnectionCallbacks,
        OnConnectionFailedListener,AsyncResponse{


    GoogleApiClient mGoogleApiClient;
    LocationRequest mLocationRequest;
    static String Longitude;
    static String Latitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);


    }


    public ArrayList<Hotel> extractHotels(){

        ArrayList<Hotel> hotels = new ArrayList<>();
        return hotels;
    }



    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mGoogleApiClient.disconnect();
    }

    @Override
    public void onConnected(Bundle bundle) {
        Location mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);
        if (mLastLocation != null) {
            Detail.Longitude = String.valueOf(mLastLocation.getLongitude());
            Detail.Latitude = String.valueOf(mLastLocation.getLatitude());

            //Detail.Latitude = "31.4977";
            //Detail.Latitude ="74.3390";
          /*  String search = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?" +
                    "location="+ Detail.Longitude+ ","+
                    Detail.Latitude +
                    "&radius=500&type=restaurant&key="+
                    "AIzaSyAq6pQ73quLIQbowMOM-xWf2QxCqmiSSUg";

             search  ="https://maps.googleapis.com/maps/api/place/textsearch/json?query=restaurants+in+" +
                   "Lahore&key=AIzaSyAq6pQ73quLIQbowMOM-xWf2QxCqmiSSUg";*/


            String search = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?" +
                     "location=" + Detail.Latitude +"," +Detail.Longitude+
                    "&radius=1000000&type=cafe&" +
                    "key=AIzaSyAq6pQ73quLIQbowMOM-xWf2QxCqmiSSUg";

            DownloadRepoTask downloadRepoTask = new DownloadRepoTask();
            downloadRepoTask.delegate = this;
            downloadRepoTask = (DownloadRepoTask) downloadRepoTask.execute(search);
        }

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }


    @Override
    public void processFinish(ArrayList<Hotel> hotels) {
        ListView earthquakeListView = (ListView) findViewById(R.id.Hotels_list_view);
        // Create a new adapter that takes the list of hotels as input
        final HotelAdapter adapter = new HotelAdapter(this, hotels);
        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);

    }
}

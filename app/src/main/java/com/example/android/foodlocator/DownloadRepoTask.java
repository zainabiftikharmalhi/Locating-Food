package com.example.android.foodlocator;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static android.R.attr.name;

/**
 * Created by zainabiftikharmalhi on 2017-05-09.
 */

public class DownloadRepoTask extends AsyncTask<String, Void, ArrayList<Hotel>> {


    public AsyncResponse delegate=null;

    public DownloadRepoTask() {

    }

    @Override
    protected ArrayList<Hotel> doInBackground(String... strings) {


        ArrayList<Hotel> hotels_list = new ArrayList<>();
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream stream = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder builder = new StringBuilder();
            String inputString;
            while ((inputString = bufferedReader.readLine()) != null) {
                builder.append(inputString);
            }
            JSONObject topLevel = new JSONObject(builder.toString());
            JSONArray array = topLevel.getJSONArray("results");
            for (int i = 0; i < array.length(); i++) {
                JSONObject temp = array.getJSONObject(i);

                String name,rating,address,Longitude,Latitude,opened="N/A";

                if(temp.has("name")) {
                    name = temp.getString("name");
                }
                else {
                    name  ="Name is not availble";
                }

                if(temp.has("rating")) {
                    rating = temp.getString("rating");
                }
                else
                {
                    rating = "0";
                }

                if(temp.has("vicinity")) {
                    address = temp.getString("vicinity");
                }
                else
                {
                    address = "Address not Available";
                }

                JSONObject temp_obj = temp.getJSONObject("geometry").getJSONObject("location");
                if(temp_obj.has("lng")) {
                    Longitude = temp_obj.getString("lng");
                }
                else
                {
                    Longitude = "Longitude not Available";
                }

                temp_obj = temp.getJSONObject("geometry").getJSONObject("location");
                if(temp_obj.has("lat")) {
                    Latitude = temp_obj.getString("lat");
                }
                else
                {
                    Latitude = "Latitude not Available";
                }


                if(temp.has("opening_hours")) {
                    temp_obj = temp.getJSONObject("opening_hours");
                    if (temp_obj.has("open_now")) {
                        opened = temp_obj.getString("open_now");
                    }
                }
                else
                {
                    opened = "N/A";
                }

                hotels_list.add(new Hotel(rating, name, address, Longitude, Latitude,opened));
            }
            urlConnection.disconnect();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return hotels_list;
    }

    @Override
    protected void onPostExecute(ArrayList<Hotel> hotels) {
        delegate.processFinish(hotels);

    }
}
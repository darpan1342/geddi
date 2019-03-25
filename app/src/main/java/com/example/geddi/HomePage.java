package com.example.geddi;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class HomePage extends Fragment {
    private final Context mContext;
    double longitude;
    double latitude;
    public static Activity avc;
    public static ListView listView;
    @SuppressLint("ValidFragment")
    public HomePage(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_home_fragment, container, false);
        GpsLocation gpsLocation= new GpsLocation(mContext);
        avc= getActivity();
        listView= (ListView)rootView.findViewById(R.id.home_fragment);
        //t = (TextView)rootView.findViewById(R.id.asd);
        latitude = gpsLocation.getLatitude();
        longitude = gpsLocation.getLongitude();
        PlacesName placesName= new PlacesName(longitude,latitude);
        placesName.execute();
        return rootView;
    }

}

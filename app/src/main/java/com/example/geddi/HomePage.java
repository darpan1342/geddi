package com.example.geddi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class HomePage extends Fragment {
    private final Context mContext;
    double longitude;
    double latitude;

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
        TextView t = (TextView)rootView.findViewById(R.id.asd);
        latitude = gpsLocation.getLatitude();
        longitude = gpsLocation.getLongitude();
        PlacesName placesName= new PlacesName(longitude,latitude);
        String l=placesName.names();
        t.setText("\n"+latitude+"   "+longitude+" "+l);
        return rootView;
    }

}

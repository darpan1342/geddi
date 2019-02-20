package com.example.geddi;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    double latitude;
    double longitude;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            requestPermissions(new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.INTERNET
                    ,Manifest.permission.ACCESS_NETWORK_STATE,Manifest.permission.READ_PHONE_STATE
            },10);
        }
        else
        {
            GpsLocation gpsLocation = new GpsLocation(this);
            latitude = gpsLocation.getLatitude();
            longitude = gpsLocation.getLongitude();
            TextView t = (TextView) findViewById(R.id.asd);
            t.setText("/n" + latitude + "  " + longitude);
        }
        final ViewPager fragment = (ViewPager) findViewById(R.id.viewpager);
        FragmentPager adapter = new FragmentPager(getSupportFragmentManager());
        fragment.setAdapter(adapter);
        Button search = (Button) findViewById(R.id.search_page);
        Button add = (Button) findViewById(R.id.add);
        Button account = (Button) findViewById(R.id.account);
        Button home = (Button) findViewById(R.id.home);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.setCurrentItem(1);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.setCurrentItem(0);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.setCurrentItem(2);
            }
        });
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.setCurrentItem(3);
            }
        });

        /*Geocoder gcd = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addressList = gcd.getFromLocation(latitude,longitude,1);
            if(addressList.size()>0)
            {
                t.setText(addressList.get(0).getSubAdminArea());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                              int[] grantResults){
        switch (requestCode)
        {
            case 10: {
                GpsLocation gpsLocation = new GpsLocation(this);
                latitude = gpsLocation.getLatitude();
                longitude = gpsLocation.getLongitude();
                TextView t = (TextView) findViewById(R.id.asd);
                t.setText("/n" + latitude + "  " + longitude);
            }
                break;
                default:
                    break;
        }
    }


}

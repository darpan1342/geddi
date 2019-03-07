package com.example.geddi;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity {

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
            Log.i("pa","passed earlier");
        }
        final ViewPager fragment = (ViewPager) findViewById(R.id.viewpager);
        FragmentPager adapter = new FragmentPager(getSupportFragmentManager(),this);
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

    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                              int[] grantResults){
        switch (requestCode)
        {
            case 10: {
                Log.i("pass","sucessfully granted");
            }
                break;
                default:
                    break;
        }
    }


}

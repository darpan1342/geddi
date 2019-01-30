package com.example.geddi;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {
    EditText searh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final ViewPager fragment= (ViewPager)findViewById(R.id.viewpager);
        FragmentPager adapter= new FragmentPager(getSupportFragmentManager());
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
}

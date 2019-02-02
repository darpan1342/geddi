package com.example.geddi;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final ViewPager fragment = findViewById(R.id.viewpager);
        FragmentPager adapter = new FragmentPager(getSupportFragmentManager());
        fragment.setAdapter(adapter);
        ImageButton search = findViewById(R.id.search_page);
        ImageButton add = findViewById(R.id.add);
        ImageButton account = findViewById(R.id.account);
        ImageButton home = findViewById(R.id.home);
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

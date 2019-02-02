package com.example.geddi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity {

    MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final ViewPager fragment = findViewById(R.id.viewpager);
        final BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.home:
                                fragment.setCurrentItem(0);
                                break;
                            case R.id.search_page:
                                fragment.setCurrentItem(1);
                                break;
                            case R.id.add:
                                fragment.setCurrentItem(2);
                                break;
                            case R.id.alert:
                                fragment.setCurrentItem(3);
                                break;
                            case R.id.account:
                                fragment.setCurrentItem(4);
                                break;
                        }
                        return false;
                    }
                });
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        fragment.setAdapter(adapter);

        fragment.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: " + position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setupViewPager(fragment);
    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomePage());
        adapter.addFragment(new SearchPage());
        adapter.addFragment(new AddPage());
        adapter.addFragment(new AlertPage());
        adapter.addFragment(new AccountPage());
        viewPager.setAdapter(adapter);

    }
}

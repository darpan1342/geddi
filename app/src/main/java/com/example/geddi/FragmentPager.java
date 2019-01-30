package com.example.geddi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentPager extends FragmentPagerAdapter {
    FragmentPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0) {
            return new HomePage();
        } else if (i == 1)
            return new SearchPage();
        else if (i == 2)
            return new AddPage();
        else
            return new AccountPage();
    }

    @Override
    public int getCount() {
        return 4;
    }
}

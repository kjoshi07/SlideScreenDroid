package com.kc.slidescreendroid.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.kc.slidescreendroid.GetStartedFragment;


/**
 * Created by Khemchandj on 11/3/2016.
 */

public class GetStartedPagerAdapter extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 3;
    public GetStartedPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return GetStartedFragment.newInstance(0);
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return GetStartedFragment.newInstance(1);
            case 2: // Fragment # 1 - This will show SecondFragment
                return GetStartedFragment.newInstance(2);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}

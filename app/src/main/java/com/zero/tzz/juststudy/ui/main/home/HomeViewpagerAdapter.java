package com.zero.tzz.juststudy.ui.main.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class HomeViewpagerAdapter extends FragmentStatePagerAdapter {
    private String[] mTitles;
    private Fragment[] mFragments;

    public HomeViewpagerAdapter(String[] titles, Fragment[] fragments, FragmentManager fm) {
        super(fm);
        mTitles = titles;
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments[position];
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = mTitles[position];
        if (title.equals("all")) {
            title = "全部";
        }
        return title;
    }
}

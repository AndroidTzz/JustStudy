package com.zero.tzz.juststudy.ui.main.home;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;

import com.zero.tzz.juststudy.R;
import com.zero.tzz.juststudy.base.BaseFragment;

import butterknife.BindView;

/**
 * @author lucy
 * @date 2018-09-26 17:49
 * @description //TODO
 */

public class HomeFragment extends BaseFragment {
    @BindView(R.id.tablayout)
    TabLayout mTabLayout;
    @BindView(R.id.viewpager)
    ViewPager mViewPager;
    private String[] mTitles = {
            "all",
            "Android",
            "iOS",
            "休息视频",
            "拓展资源",
            "前端",
    };
    private Fragment[] mFragments = new Fragment[mTitles.length];
    private HomeViewpagerAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initDataAndEvent() {
        initFragment();
        mAdapter = new HomeViewpagerAdapter(mTitles, mFragments, getActivity().getSupportFragmentManager());
        mViewPager.setOffscreenPageLimit(mTitles.length);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setTabTextColors(ContextCompat.getColor(mContext, R.color.colorGray),
                ContextCompat.getColor(mContext, R.color.colorPrimary));
        mTabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(mContext, R.color.colorPrimary));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initFragment() {
        for (int i = 0; i < mTitles.length; i++) {
            mFragments[i] = HomeItemFragment.getInstance(mTitles[i]);
        }
    }
}

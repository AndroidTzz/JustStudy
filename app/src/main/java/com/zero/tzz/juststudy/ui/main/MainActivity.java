package com.zero.tzz.juststudy.ui.main;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.zero.tzz.juststudy.R;
import com.zero.tzz.juststudy.base.BaseActivity;
import com.zero.tzz.juststudy.base.BaseFragment;
import com.zero.tzz.juststudy.ui.main.home.HomeFragment;
import com.zero.tzz.juststudy.ui.main.meizi.MeiziFragment;
import com.zero.tzz.juststudy.ui.main.more.MoreFragment;
import com.zero.tzz.juststudy.ui.main.xiandu.XianduFragment;
import com.zero.tzz.juststudy.utils.BottomNavigationViewHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity{

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.container)
    FrameLayout mContainer;
    @BindView(R.id.home_bottom_navi_view)
    BottomNavigationView mBottomNavigationView;

    private List<BaseFragment> mFragments;
    private HomeFragment mHomeFragment;
    private XianduFragment mXianduFragment;
    private MeiziFragment mMeiziFragment;
    private MoreFragment mMoreFragment;

    private int mLastFragmentPosition;
    private long mLastTime;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
        initView();
    }

    private void initView() {
        initActionBar();
        initFragment();
        initNaviagtionView();
    }

    private void initActionBar() {
        mToolbar.setElevation(16);
        mToolbar.setTitle(R.string.home);
        setSupportActionBar(mToolbar);
    }

    private void initFragment() {
        mFragments = new ArrayList<>();
        mHomeFragment = new HomeFragment();
        mXianduFragment = new XianduFragment();
        mMeiziFragment = new MeiziFragment();
        mMoreFragment = new MoreFragment();

        mFragments.add(mHomeFragment);
        mFragments.add(mXianduFragment);
        mFragments.add(mMeiziFragment);
        mFragments.add(mMoreFragment);
    }

    private void initNaviagtionView() {
        BottomNavigationViewHelper.disableShiftMode(mBottomNavigationView);
        switchFragment(mLastFragmentPosition);
        mBottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.i_home:
                    switchFragment(0);
                    mToolbar.setTitle(R.string.home);
                    break;
                case R.id.i_xiandu:
                    switchFragment(1);
                    mToolbar.setTitle(R.string.xiandu);
                    break;
                case R.id.i_meizi:
                    switchFragment(2);
                    mToolbar.setTitle(R.string.meizi);
                    break;
                case R.id.i_more:
                    switchFragment(3);
                    mToolbar.setTitle(R.string.more);
                    break;
                default:
                    break;
            }
            return true;
        });
    }

    private void switchFragment(int position) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        BaseFragment currentFragment = mFragments.get(position);
        BaseFragment lastFragment = mFragments.get(mLastFragmentPosition);
        mLastFragmentPosition = position;
        transaction.hide(lastFragment);
        if (!currentFragment.isAdded()) {
            transaction.add(R.id.container, currentFragment);
        }
        transaction.show(currentFragment);
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - mLastTime < 2000) {
            super.onBackPressed();
        } else {
            mLastTime = System.currentTimeMillis();
            Toast.makeText(this, "再按一次退出~", Toast.LENGTH_SHORT).show();
        }
    }
}

package com.zero.tzz.juststudy.ui.main.xiandu;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.zero.tzz.juststudy.R;
import com.zero.tzz.juststudy.base.BaseRxFragment;
import com.zero.tzz.juststudy.model.bean.gank.BaseBean;
import com.zero.tzz.juststudy.model.bean.gank.XianduMain;
import com.zero.tzz.juststudy.ui.main.xiandu.page.XianduPageFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class XianduFragment extends BaseRxFragment<XianduPresenter> implements XianduContract.View {
    @BindView(R.id.xiandu_tablayout)
    TabLayout mTabLayout;
    @BindView(R.id.xiandu_viewpager)
    ViewPager mViewPager;
    private XianduViewpagerAdapter mAdapter;
    private List<String> mTitles;
    private List<Fragment> mFragments;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_xiandu;
    }

    @Override
    protected void initDataAndEvent() {
        mPresenter.getXianduMain();
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void showXianduMain(BaseBean<XianduMain> bean) {
        initFragment(bean);
        mAdapter = new XianduViewpagerAdapter(mTitles, mFragments, getActivity().getSupportFragmentManager());
        mViewPager.setOffscreenPageLimit(mTitles.size());
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setTabTextColors(ContextCompat.getColor(mContext, R.color.colorGray),
                ContextCompat.getColor(mContext, R.color.colorPrimary));
        mTabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(mContext, R.color.colorPrimary));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initFragment(BaseBean<XianduMain> bean) {
        List<XianduMain> data = bean.getData();
        mTitles = new ArrayList<>();
        mFragments = new ArrayList<>();
        for (XianduMain xianduMain : data) {
            mTitles.add(xianduMain.getName());
            mFragments.add(XianduPageFragment.getInstance(xianduMain.getEn_name()));
        }
    }

    @Override
    public void onError(String errorMsg) {
        Toast.makeText(mContext, "数据加载失败:" + errorMsg, Toast.LENGTH_SHORT).show();
    }
}

package com.zero.tzz.juststudy.ui.main.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.zero.tzz.juststudy.R;
import com.zero.tzz.juststudy.base.BaseRxFragment;
import com.zero.tzz.juststudy.model.bean.gank.BaseBean;
import com.zero.tzz.juststudy.model.bean.gank.Ganhuo;
import com.zero.tzz.juststudy.ui.listener.EndlessRecyclerViewScrollListener;
import com.zero.tzz.juststudy.ui.web.WebViewActivity;
import com.zero.tzz.juststudy.utils.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class HomePageFragment extends BaseRxFragment<HomePresenter> implements HomeContract.View {

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    private List<Ganhuo> mGanhuoLists;
    private String mTitle;
    private int mCurrentPage = 1;
    private LinearLayoutManager mLinearLayoutManager;
    private HomePageAdapter mAdapter;
    private EndlessRecyclerViewScrollListener mScrollListener;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_item;
    }

    private void refresh(boolean loadMore) {
        if (loadMore) {
            mCurrentPage++;
        } else {
            mCurrentPage = 1;
        }
        mSwipeRefreshLayout.setRefreshing(true);
        mPresenter.getGanhuo(mTitle, 20, mCurrentPage);
    }

    @Override
    protected void initDataAndEvent() {
        mTitle = getArguments().getString("title");
        mLinearLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mSwipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(mContext, R.color.colorPrimary));
        mSwipeRefreshLayout.setOnRefreshListener(() -> {
            refresh(false);
            mScrollListener.resetState();
        });
        mScrollListener = new EndlessRecyclerViewScrollListener(mLinearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                refresh(true);
            }
        };
        mRecyclerView.addOnScrollListener(mScrollListener);
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(0, 8, 8, 0));
        mGanhuoLists = new ArrayList<>();
        mAdapter = new HomePageAdapter(R.layout.item_ganhuo, mGanhuoLists);
        mAdapter.setOnItemClickListener((adapter, view, position) -> {
            // 跳转详情页面
            Intent intent = new Intent(mContext, WebViewActivity.class);
            intent.putExtra("url", mGanhuoLists.get(position).getUrl());
            intent.putExtra("title", mGanhuoLists.get(position).getDesc());
            startActivity(intent);
        });
        mRecyclerView.setAdapter(mAdapter);
        refresh(false);
    }

    @Override
    public void showGanhuo(BaseBean<Ganhuo> bean) {
        // 添加FooterView
        if (mAdapter.getFooterLayoutCount() == 0) {
            View footerView = LayoutInflater.from(mContext).inflate(R.layout.footer_view, null);
            mAdapter.addFooterView(footerView);
        }
        mSwipeRefreshLayout.setRefreshing(false);
        List<Ganhuo> data = bean.getData();
        if (mCurrentPage == 1) {
            mGanhuoLists.clear();
            mGanhuoLists.addAll(data);
            mAdapter.setNewData(data);
        } else {
            mGanhuoLists.addAll(data);
            mAdapter.addData(data);
        }
    }

    @Override
    public void onError(String errorMsg) {
        super.onError(errorMsg);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    public static HomePageFragment getInstance(String title) {
        HomePageFragment fragment = new HomePageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragment.setArguments(bundle);
        return fragment;
    }
}

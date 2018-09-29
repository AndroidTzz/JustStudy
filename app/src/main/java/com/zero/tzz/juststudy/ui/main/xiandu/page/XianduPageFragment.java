package com.zero.tzz.juststudy.ui.main.xiandu.page;

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
import com.zero.tzz.juststudy.model.bean.gank.XianduChild;
import com.zero.tzz.juststudy.ui.listener.EndlessRecyclerViewScrollListener;
import com.zero.tzz.juststudy.ui.main.xiandu.page.detail.XianduDetailActivity;
import com.zero.tzz.juststudy.utils.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author lucy
 * @date 2018-09-29 10:31
 * @description //TODO
 */

public class XianduPageFragment extends BaseRxFragment<XianduPagePresenter> implements XianduPageContract.View {

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private String mName;
    private LinearLayoutManager mLinearLayoutManager;
    private EndlessRecyclerViewScrollListener mScrollListener;

    private List<XianduChild> mListDatas;
    private XianduPageAdapter mAdapter;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_xiandu_page;
    }

    @Override
    protected void initDataAndEvent() {
        mName = getArguments().getString("name");

        mLinearLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mSwipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(mContext, R.color.colorPrimary));
        mSwipeRefreshLayout.setOnRefreshListener(() -> {
            mPresenter.getXianduChild(mName);
            mScrollListener.resetState();
        });
        mScrollListener = new EndlessRecyclerViewScrollListener(mLinearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                mPresenter.getXianduChild(mName);
            }
        };
        mRecyclerView.addOnScrollListener(mScrollListener);
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(0,8,8,0));
        mListDatas = new ArrayList<>();
        mAdapter = new XianduPageAdapter(R.layout.item_xiandu_page, mListDatas);
        mAdapter.setOnItemClickListener((adapter, view, position) -> {
            // 跳转详情页面
            Intent intent = new Intent(mContext, XianduDetailActivity.class);
            intent.putExtra("id", mListDatas.get(position).getId());
            intent.putExtra("title", mListDatas.get(position).getTitle());
            intent.putExtra("icon", mListDatas.get(position).getIcon());
            startActivity(intent);
        });
        mRecyclerView.setAdapter(mAdapter);
        mPresenter.getXianduChild(mName);
    }

    @Override
    public void showXianduPage(BaseBean<XianduChild> bean) {
        // 添加FooterView
        if (mAdapter.getFooterLayoutCount() == 0) {
            View footerView = LayoutInflater.from(mContext).inflate(R.layout.footer_view, null);
            mAdapter.addFooterView(footerView);
        }
        List<XianduChild> data = bean.getData();
        mSwipeRefreshLayout.setRefreshing(false);
        mListDatas.clear();
        mListDatas.addAll(data);
        mAdapter.setNewData(data);
    }

    @Override
    public void onError(String errorMsg) {
        super.onError(errorMsg);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    public static XianduPageFragment getInstance(String name) {
        XianduPageFragment fragment = new XianduPageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        fragment.setArguments(bundle);
        return fragment;
    }
}

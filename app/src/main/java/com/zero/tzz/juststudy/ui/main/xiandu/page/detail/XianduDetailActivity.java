package com.zero.tzz.juststudy.ui.main.xiandu.page.detail;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.zero.tzz.juststudy.R;
import com.zero.tzz.juststudy.base.BaseRxActivity;
import com.zero.tzz.juststudy.model.bean.gank.BaseBean;
import com.zero.tzz.juststudy.model.bean.gank.XianduData;
import com.zero.tzz.juststudy.ui.listener.EndlessRecyclerViewScrollListener;
import com.zero.tzz.juststudy.ui.web.WebViewActivity;
import com.zero.tzz.juststudy.utils.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author lucy
 * @date 2018-09-29 13:30
 * @description //TODO
 */

public class XianduDetailActivity extends BaseRxActivity<XianduDetailPresenter> implements XianduDetailContract.View {

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.iv_detail_icon)
    CircleImageView mIvDetailIcon;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private List<XianduData> mListDatas;
    private XianduDetailAdapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private EndlessRecyclerViewScrollListener mScrollListener;
    private String mId;
    private String mTitle;
    private String mIcon;
    private int mCurrentPage = 1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_xiandu_detail;
    }

    @Override
    protected void initEventAndData() {
        mId = getIntent().getStringExtra("id");
        mTitle = getIntent().getStringExtra("title");
        mIcon = getIntent().getStringExtra("icon");

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(v -> finish());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Glide.with(this).load(mIcon).apply(RequestOptions.centerCropTransform()).into(mIvDetailIcon);
        mTvTitle.setText(mTitle);

        mListDatas = new ArrayList<>();
        mAdapter = new XianduDetailAdapter(R.layout.item_xiandu_detail, mListDatas);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerview.setLayoutManager(mLinearLayoutManager);
        mRecyclerview.addItemDecoration(new SpacesItemDecoration(0, 8, 8, 0));
        mScrollListener = new EndlessRecyclerViewScrollListener(mLinearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                refresh(true);
            }
        };
        mSwipeRefreshLayout.setOnRefreshListener(() -> {
            refresh(false);
            mScrollListener.resetState();
        });
        mRecyclerview.addOnScrollListener(mScrollListener);
        mRecyclerview.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener((adapter, view, position) -> {
            Intent intent = new Intent(this, WebViewActivity.class);
            intent.putExtra("url", mListDatas.get(position).getUrl());
            intent.putExtra("title", mListDatas.get(position).getTitle());
            startActivity(intent);
        });
        refresh(false);
    }

    private void refresh(boolean loadMore) {
        if (loadMore) {
            mCurrentPage++;
        } else {
            mCurrentPage = 1;
        }
        mSwipeRefreshLayout.setRefreshing(true);
        mPresenter.getXianduData(mId, 20, mCurrentPage);
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void showXianduDetail(BaseBean<XianduData> bean) {
        // 添加FooterView
        if (mAdapter.getFooterLayoutCount() == 0) {
            View footerView = LayoutInflater.from(this).inflate(R.layout.footer_view, null);
            mAdapter.addFooterView(footerView);
        }
        mSwipeRefreshLayout.setRefreshing(false);
        List<XianduData> data = bean.getData();
        if (mCurrentPage == 1) {
            mListDatas.clear();
            mListDatas.addAll(data);
            mAdapter.setNewData(data);
        } else {
            mListDatas.addAll(data);
            mAdapter.addData(data);
        }
    }

    @Override
    public void onError(String errorMsg) {
        mSwipeRefreshLayout.setRefreshing(false);
        Toast.makeText(this, "加载数据出错:" + errorMsg, Toast.LENGTH_SHORT).show();
    }
}

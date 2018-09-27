package com.zero.tzz.juststudy.ui.main.meizi;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.zero.tzz.juststudy.R;
import com.zero.tzz.juststudy.base.BaseRxFragment;
import com.zero.tzz.juststudy.model.bean.gank.BaseBean;
import com.zero.tzz.juststudy.model.bean.gank.Ganhuo;
import com.zero.tzz.juststudy.ui.listener.EndlessRecyclerViewScrollListener;
import com.zero.tzz.juststudy.utils.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class MeiziFragment extends BaseRxFragment<MeiziPresenter> implements MeiziContract.View {
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    private List<Ganhuo> mMeiziLists;
    private MeiziAdapter mAdapter;
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private int mCurrentPage = 1;
    private EndlessRecyclerViewScrollListener mScrollListener;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_meizi;
    }

    @Override
    protected void initDataAndEvent() {
        initView();
        refresh(false);
    }

    private void refresh(boolean loadMore) {
        if (loadMore) {
            mCurrentPage++;
        } else {
            mCurrentPage = 1;
        }
        mSwipeRefreshLayout.setRefreshing(true);
        mPresenter.getMeizi(20, mCurrentPage);
    }

    private void initView() {
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
        mStaggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(6));
        mScrollListener = new EndlessRecyclerViewScrollListener(mStaggeredGridLayoutManager) {

            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                refresh(true);
            }
        };
        mRecyclerView.addOnScrollListener(mScrollListener);
        mMeiziLists = new ArrayList<>();
        mAdapter = new MeiziAdapter(mContext,R.layout.item_meizi, mMeiziLists);
        View footerView = LayoutInflater.from(mContext).inflate(R.layout.footer_view, null);
        mAdapter.addFooterView(footerView);
        mAdapter.setOnItemClickListener((adapter, view, position) ->
                startShowMeiziActivity(view, position)
        );

        mRecyclerView.setAdapter(mAdapter);

        mSwipeRefreshLayout.setOnRefreshListener(() ->
                refresh(false)
        );
    }

    private void startShowMeiziActivity(View view, int position) {
        Intent intent = new Intent(getActivity(), ShowMeiziActivity.class);
        String url = mMeiziLists.get(position).getUrl();
        String id = mMeiziLists.get(position).get_id();
        intent.putExtra("url", url);
        intent.putExtra("id", id);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity(), view.findViewById(R.id.iv_meizi), "share").toBundle());
        } else {
            startActivity(intent);
        }
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void onSuccess(BaseBean<Ganhuo> bean) {
        mSwipeRefreshLayout.setRefreshing(false);
        List<Ganhuo> data = bean.getData();
        if (mCurrentPage == 1) {
            mMeiziLists.clear();
            mMeiziLists.addAll(data);
            mAdapter.setNewData(data);
        } else {
            mMeiziLists.addAll(data);
            mAdapter.addData(data);
        }
    }

    @Override
    public void onError(String errorMsg) {
        mSwipeRefreshLayout.setRefreshing(false);
        Toast.makeText(mContext, "errorMsg", Toast.LENGTH_SHORT).show();
    }
}

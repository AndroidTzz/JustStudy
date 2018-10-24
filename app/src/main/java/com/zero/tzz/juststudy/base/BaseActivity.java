package com.zero.tzz.juststudy.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zero.tzz.swipeback.BaseSwipeBackActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity extends BaseSwipeBackActivity {

    private Unbinder mBind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mBind = ButterKnife.bind(this);
        init();
        initEventAndData();
    }

    protected void init() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBind != null) {
            mBind.unbind();
        }
    }

    protected abstract int getLayoutId();

    protected abstract void initEventAndData();
}

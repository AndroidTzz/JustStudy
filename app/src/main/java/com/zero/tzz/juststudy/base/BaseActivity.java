package com.zero.tzz.juststudy.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zero.tzz.juststudy.di.component.ActivityComponent;
import com.zero.tzz.juststudy.di.component.DaggerActivityComponent;
import com.zero.tzz.juststudy.di.module.ActivityMoudle;
import com.zero.tzz.juststudy.global.JustApp;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder mBind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mBind = ButterKnife.bind(this);
        initInject();
        onCreated();
        initEventAndData();
    }

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent
                .builder()
                .applicationComponent(JustApp.getInstance().getApplicationComponent())
                .activityMoudle(new ActivityMoudle(this))
                .build();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBind != null) mBind.unbind();
    }

    protected abstract int getLayoutId();

    protected void onCreated() {
    }

    protected abstract void initInject();

    protected abstract void initEventAndData();
}

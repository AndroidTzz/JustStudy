package com.zero.tzz.juststudy.base;

import com.zero.tzz.juststudy.di.component.ActivityComponent;
import com.zero.tzz.juststudy.di.component.DaggerActivityComponent;
import com.zero.tzz.juststudy.di.module.ActivityMoudle;
import com.zero.tzz.juststudy.global.JustApp;

import javax.inject.Inject;


public abstract class BaseRxActivity<T extends BasePresenter> extends BaseActivity implements BaseView {

    @Inject
    protected T mPresenter;

    @Override
    protected void init() {
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        onCreated();
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
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    private void onCreated() {

    }

    protected abstract void initInject();
}

package com.zero.tzz.juststudy.base;

import android.widget.Toast;

import com.zero.tzz.juststudy.di.component.DaggerFragmentComponent;
import com.zero.tzz.juststudy.di.component.FragmentComponent;
import com.zero.tzz.juststudy.di.module.FragmentModule;
import com.zero.tzz.juststudy.global.JustApp;

import javax.inject.Inject;

/**
 * @author lucy
 * @date 2018-09-27 10:04
 * @description //TODO
 */

public abstract class BaseRxFragment<T extends BasePresenter> extends BaseFragment implements BaseView {

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

    protected void onCreated() {

    }

    protected FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent
                .builder()
                .applicationComponent(JustApp.getInstance().getApplicationComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void onError(String errorMsg) {
        Toast.makeText(mContext, "数据加载失败:" + errorMsg, Toast.LENGTH_SHORT).show();
    }

    protected abstract void initInject();
}

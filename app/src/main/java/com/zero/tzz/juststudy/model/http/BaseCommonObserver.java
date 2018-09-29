package com.zero.tzz.juststudy.model.http;

import com.zero.tzz.juststudy.base.BaseView;

import io.reactivex.observers.ResourceObserver;

/**
 * @author lucy
 * @date 2018-09-29 10:48
 * @description //TODO
 */

public abstract class BaseCommonObserver<T> extends ResourceObserver<T> {
    private BaseView mView;

    public BaseCommonObserver(BaseView view) {
        mView = view;
    }

    @Override
    public void onError(Throwable e) {
        mView.onError(e.getMessage());
    }

    @Override
    public void onComplete() {

    }
}

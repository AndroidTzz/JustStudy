package com.zero.tzz.juststudy.base;

/**
 * @author lucy
 * @date 2018-09-26 18:13
 * @description //TODO
 */

public class BaseRxPresenter<T extends BaseView> implements BasePresenter<T> {
    protected T mView;

    @Override
    public void attach(T view) {
        this.mView = view;
    }

    @Override
    public void detach() {
        mView = null;
    }
}

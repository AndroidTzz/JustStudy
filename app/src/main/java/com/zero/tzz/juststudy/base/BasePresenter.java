package com.zero.tzz.juststudy.base;

/**
 * @author lucy
 * @date 2018-09-26 17:51
 * @description //TODO
 */

public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void detachView();
}

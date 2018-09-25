package com.zero.tzz.juststudy.model.http;

import com.zero.tzz.juststudy.model.bean.gank.TodayBean;
import com.zero.tzz.juststudy.model.http.api.GankApi;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * 网络请求统一管理类
 */
public class RetrofitHelper implements HttpHelper {

    private GankApi mGankApi;

    @Inject
    public RetrofitHelper(GankApi gankApi) {
        mGankApi = gankApi;
    }

    @Override
    public Observable<TodayBean> today() {
        return mGankApi.today();
    }
}

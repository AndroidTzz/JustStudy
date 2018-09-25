package com.zero.tzz.juststudy.model;

import com.zero.tzz.juststudy.model.bean.gank.TodayBean;
import com.zero.tzz.juststudy.model.http.HttpHelper;

import io.reactivex.Observable;

/**
 * 数据统一管理类 包括 db - http - sp
 */
public class DataManager implements HttpHelper {

    private HttpHelper mHttpHelper;

    public DataManager(HttpHelper httpHelper) {
        mHttpHelper = httpHelper;
    }

    @Override
    public Observable<TodayBean> today() {
        return mHttpHelper.today();
    }
}

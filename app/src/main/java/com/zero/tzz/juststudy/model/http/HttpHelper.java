package com.zero.tzz.juststudy.model.http;


import com.zero.tzz.juststudy.model.bean.gank.TodayBean;

import io.reactivex.Observable;

/** 所有网络请求都在该接口 */
public interface HttpHelper {

    Observable<TodayBean> today();

}

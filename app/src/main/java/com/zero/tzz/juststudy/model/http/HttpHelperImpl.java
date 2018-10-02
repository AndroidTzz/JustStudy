package com.zero.tzz.juststudy.model.http;

import com.zero.tzz.juststudy.model.bean.gank.BaseBean;
import com.zero.tzz.juststudy.model.bean.gank.Ganhuo;
import com.zero.tzz.juststudy.model.bean.gank.XianduChild;
import com.zero.tzz.juststudy.model.bean.gank.XianduData;
import com.zero.tzz.juststudy.model.bean.gank.XianduMain;
import com.zero.tzz.juststudy.model.http.api.GankApi;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * 网络请求统一实现类
 */
public class HttpHelperImpl implements HttpHelper {

    private GankApi mGankApi;

    @Inject
    public HttpHelperImpl(GankApi gankApi) {
        mGankApi = gankApi;
    }


    @Override
    public Observable<BaseBean<Ganhuo>> ganhuo(String type, int count, int page) {
        return mGankApi.ganhuo(type,count,page);
    }

    @Override
    public Observable<BaseBean<XianduMain>> xianduMain() {
        return mGankApi.xianduMain();
    }

    @Override
    public Observable<BaseBean<XianduChild>> xianduChild(String category) {
        return mGankApi.xianduChild(category);
    }

    @Override
    public Observable<BaseBean<XianduData>> xianduData(String id, int count, int page) {
        return mGankApi.xianduData(id,count,page);
    }
}

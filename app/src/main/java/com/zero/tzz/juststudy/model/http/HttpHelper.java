package com.zero.tzz.juststudy.model.http;


import com.zero.tzz.juststudy.model.bean.gank.BaseBean;
import com.zero.tzz.juststudy.model.bean.gank.Ganhuo;
import com.zero.tzz.juststudy.model.bean.gank.XianduChild;
import com.zero.tzz.juststudy.model.bean.gank.XianduData;
import com.zero.tzz.juststudy.model.bean.gank.XianduMain;

import io.reactivex.Observable;

/**
 * 所有网络请求都在该接口
 */
public interface HttpHelper {

    Observable<BaseBean<Ganhuo>> ganhuo(String type, int count, int page);

    Observable<BaseBean<XianduMain>> xianduMain();

    Observable<BaseBean<XianduChild>> xianduChild(String category);

    Observable<BaseBean<XianduData>> xianduData(String id, int count, int page);
}

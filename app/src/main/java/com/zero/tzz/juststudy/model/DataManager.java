package com.zero.tzz.juststudy.model;

import com.zero.tzz.juststudy.model.bean.gank.BaseBean;
import com.zero.tzz.juststudy.model.bean.gank.Ganhuo;
import com.zero.tzz.juststudy.model.bean.gank.XianduChild;
import com.zero.tzz.juststudy.model.bean.gank.XianduData;
import com.zero.tzz.juststudy.model.bean.gank.XianduMain;
import com.zero.tzz.juststudy.model.db.DbHelper;
import com.zero.tzz.juststudy.model.http.HttpHelper;
import com.zero.tzz.juststudy.model.prefs.PrefrencesHelper;

import io.reactivex.Observable;

/**
 * 数据统一管理类 包括 db - http - sp
 */
public class DataManager implements HttpHelper, DbHelper, PrefrencesHelper {

    private HttpHelper mHttpHelper;
    private DbHelper mDbHelper;
    private PrefrencesHelper mPrefrencesHelper;

    public DataManager(HttpHelper httpHelper, DbHelper dbHelper, PrefrencesHelper prefrencesHelper) {
        mHttpHelper = httpHelper;
        mDbHelper = dbHelper;
        mPrefrencesHelper = prefrencesHelper;
    }


    @Override
    public Observable<BaseBean<Ganhuo>> ganhuo(String type, int count, int page) {
        return mHttpHelper.ganhuo(type, count, page);
    }

    @Override
    public Observable<BaseBean<XianduMain>> xianduMain() {
        return mHttpHelper.xianduMain();
    }

    @Override
    public Observable<BaseBean<XianduChild>> xianduChild(String category) {
        return mHttpHelper.xianduChild(category);
    }

    @Override
    public Observable<BaseBean<XianduData>> xianduData(String id, int count, int page) {
        return mHttpHelper.xianduData(id, count, page);
    }

    @Override
    public int getThemeMode() {
        return mPrefrencesHelper.getThemeMode();
    }

    @Override
    public void setThemeMode(int mode) {
        mPrefrencesHelper.setThemeMode(mode);
    }
}

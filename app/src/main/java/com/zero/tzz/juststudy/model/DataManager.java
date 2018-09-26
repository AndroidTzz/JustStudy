package com.zero.tzz.juststudy.model;

import com.zero.tzz.juststudy.model.bean.gank.BaseBean;
import com.zero.tzz.juststudy.model.bean.gank.Ganhuo;
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
}

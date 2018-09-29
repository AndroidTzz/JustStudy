package com.zero.tzz.juststudy.ui.main.home;

import com.zero.tzz.juststudy.base.BaseRxPresenter;
import com.zero.tzz.juststudy.model.DataManager;
import com.zero.tzz.juststudy.model.bean.gank.BaseBean;
import com.zero.tzz.juststudy.model.bean.gank.Ganhuo;
import com.zero.tzz.juststudy.model.http.BaseCommonObserver;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author lucy
 * @date 2018-09-27 10:00
 * @description //TODO
 */

public class HomePresenter extends BaseRxPresenter<HomeContract.View> implements HomeContract.Presenter {

    private DataManager mDataManager;

    @Inject
    public HomePresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }


    @Override
    public void getGanhuo(String type, int count, int page) {
        addSubscribe(mDataManager
                .ganhuo(type, count, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new BaseCommonObserver<BaseBean<Ganhuo>>(mView) {
                    @Override
                    public void onNext(BaseBean<Ganhuo> bean) {
                        mView.showGanhuo(bean);
                    }
                }));
    }
}

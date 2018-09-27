package com.zero.tzz.juststudy.ui.main.home;

import com.zero.tzz.juststudy.base.BaseRxPresenter;
import com.zero.tzz.juststudy.model.DataManager;
import com.zero.tzz.juststudy.model.bean.gank.BaseBean;
import com.zero.tzz.juststudy.model.bean.gank.Ganhuo;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
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
        mDataManager
                .ganhuo(type, count, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean<Ganhuo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean<Ganhuo> bean) {
                        mView.onSuccess(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

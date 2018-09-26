package com.zero.tzz.juststudy.ui.main;

import com.zero.tzz.juststudy.base.BaseRxPresenter;
import com.zero.tzz.juststudy.model.DataManager;
import com.zero.tzz.juststudy.model.bean.gank.BaseBean;
import com.zero.tzz.juststudy.model.bean.gank.Ganhuo;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author lucy
 * @date 2018-09-26 18:19
 * @description //TODO
 */

public class MainPresenter extends BaseRxPresenter<MainContract.View> implements MainContract.Presenter {

    private DataManager mDataManager;
    @Inject
    public MainPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void ganhuo() {
        Observable<BaseBean<Ganhuo>> ganhuo = mDataManager.ganhuo("Android", 20, 1);
        ganhuo.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean<Ganhuo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean<Ganhuo> bean) {
                        mView.success(bean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

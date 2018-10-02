package com.zero.tzz.juststudy.ui.main.xiandu;

import com.zero.tzz.juststudy.base.BaseRxPresenter;
import com.zero.tzz.juststudy.model.DataManager;
import com.zero.tzz.juststudy.model.bean.gank.BaseBean;
import com.zero.tzz.juststudy.model.bean.gank.XianduMain;
import com.zero.tzz.juststudy.model.http.BaseCommonObserver;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author lucy
 * @date 2018-09-27 10:00
 * @description //TODO
 */

public class XianduPresenter extends BaseRxPresenter<XianduContract.View> implements XianduContract.Presenter {

    private DataManager mDataManager;

    @Inject
    public XianduPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }


    @Override
    public void getXianduMain() {
        addSubscribe(mDataManager
                .xianduMain()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new BaseCommonObserver<BaseBean<XianduMain>>(mView) {
                    @Override
                    public void onNext(BaseBean<XianduMain> bean) {
                        mView.showXianduMain(bean);
                    }
                }));
    }
}

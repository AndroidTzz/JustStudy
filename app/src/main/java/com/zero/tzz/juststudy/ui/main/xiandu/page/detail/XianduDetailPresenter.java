package com.zero.tzz.juststudy.ui.main.xiandu.page.detail;

import com.zero.tzz.juststudy.base.BaseRxPresenter;
import com.zero.tzz.juststudy.model.DataManager;
import com.zero.tzz.juststudy.model.bean.gank.BaseBean;
import com.zero.tzz.juststudy.model.bean.gank.XianduData;
import com.zero.tzz.juststudy.model.http.BaseCommonObserver;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author lucy
 * @date 2018-09-29 13:30
 * @description //TODO
 */

public class XianduDetailPresenter extends BaseRxPresenter<XianduDetailContract.View> implements XianduDetailContract.Presenter {
    private DataManager mDataManager;

    @Inject
    public XianduDetailPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void getXianduData(String id, int count, int page) {
        addSubscribe(mDataManager
                .xianduData(id, count, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new BaseCommonObserver<BaseBean<XianduData>>(mView) {
                    @Override
                    public void onNext(BaseBean<XianduData> bean) {
                        mView.showXianduDetail(bean);
                    }
                })
        );
    }
}

package com.zero.tzz.juststudy.ui.main.xiandu.page;

import com.zero.tzz.juststudy.base.BaseRxPresenter;
import com.zero.tzz.juststudy.model.DataManager;
import com.zero.tzz.juststudy.model.bean.gank.BaseBean;
import com.zero.tzz.juststudy.model.bean.gank.XianduChild;
import com.zero.tzz.juststudy.model.http.BaseCommonObserver;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author lucy
 * @date 2018-09-29 10:56
 * @description //TODO
 */

public class XianduPagePresenter extends BaseRxPresenter<XianduPageContract.View> implements XianduPageContract.Presenter {

    private DataManager mDataManager;

    @Inject
    public XianduPagePresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void getXianduChild(String category) {
        addSubscribe(mDataManager
                .xianduChild(category)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new BaseCommonObserver<BaseBean<XianduChild>>(mView) {
                    @Override
                    public void onNext(BaseBean<XianduChild> bean) {
                        mView.showXianduPage(bean);
                    }
                }));
    }
}

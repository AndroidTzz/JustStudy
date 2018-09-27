package com.zero.tzz.juststudy.ui.main.home;

import com.zero.tzz.juststudy.base.BasePresenter;
import com.zero.tzz.juststudy.base.BaseView;
import com.zero.tzz.juststudy.model.bean.gank.BaseBean;
import com.zero.tzz.juststudy.model.bean.gank.Ganhuo;

/**
 * @author lucy
 * @date 2018-09-27 09:59
 * @description //TODO
 */

public interface HomeContract {
    interface View extends BaseView {
        void onSuccess(BaseBean<Ganhuo> bean);

        void onError(String errorMsg);
    }

    interface Presenter extends BasePresenter<View> {
        void getGanhuo(String type, int count, int page);
    }
}

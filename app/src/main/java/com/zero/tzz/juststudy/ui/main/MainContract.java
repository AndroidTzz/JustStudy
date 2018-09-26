package com.zero.tzz.juststudy.ui.main;

import com.zero.tzz.juststudy.base.BasePresenter;
import com.zero.tzz.juststudy.base.BaseView;
import com.zero.tzz.juststudy.model.bean.gank.BaseBean;
import com.zero.tzz.juststudy.model.bean.gank.Ganhuo;

/**
 * @author lucy
 * @date 2018-09-26 18:15
 * @description //TODO
 */

public interface MainContract {
    interface View extends BaseView {
        void success(BaseBean<Ganhuo> ganhuoBean);
    }

    interface Presenter extends BasePresenter<View> {
        void ganhuo();
    }
}

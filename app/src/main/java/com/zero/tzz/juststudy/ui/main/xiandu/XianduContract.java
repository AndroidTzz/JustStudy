package com.zero.tzz.juststudy.ui.main.xiandu;

import com.zero.tzz.juststudy.base.BasePresenter;
import com.zero.tzz.juststudy.base.BaseView;
import com.zero.tzz.juststudy.model.bean.gank.BaseBean;
import com.zero.tzz.juststudy.model.bean.gank.XianduMain;

/**
 * @author lucy
 * @date 2018-09-27 09:59
 * @description //TODO
 */

public interface XianduContract {
    interface View extends BaseView {
        void showXianduMain(BaseBean<XianduMain> bean);
    }

    interface Presenter extends BasePresenter<View> {
        void getXianduMain();
    }
}

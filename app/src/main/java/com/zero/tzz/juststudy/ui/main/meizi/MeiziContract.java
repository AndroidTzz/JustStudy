package com.zero.tzz.juststudy.ui.main.meizi;

import com.zero.tzz.juststudy.base.BasePresenter;
import com.zero.tzz.juststudy.base.BaseView;
import com.zero.tzz.juststudy.model.bean.gank.BaseBean;
import com.zero.tzz.juststudy.model.bean.gank.Ganhuo;

/**
 * @author lucy
 * @date 2018-09-27 09:59
 * @description //TODO
 */

public interface MeiziContract {
    interface View extends BaseView {
        void showMeizi(BaseBean<Ganhuo> bean);
    }

    interface Presenter extends BasePresenter<View> {
        void getMeizi(int count, int page);
    }

}

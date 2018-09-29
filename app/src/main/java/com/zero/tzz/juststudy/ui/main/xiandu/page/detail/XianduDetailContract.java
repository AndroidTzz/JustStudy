package com.zero.tzz.juststudy.ui.main.xiandu.page.detail;

import com.zero.tzz.juststudy.base.BasePresenter;
import com.zero.tzz.juststudy.base.BaseView;
import com.zero.tzz.juststudy.model.bean.gank.BaseBean;
import com.zero.tzz.juststudy.model.bean.gank.XianduData;

/**
 * @author lucy
 * @date 2018-09-29 13:26
 * @description //TODO
 */

public interface XianduDetailContract {
    interface View extends BaseView {
        void showXianduDetail(BaseBean<XianduData> bean);
    }

    interface Presenter extends BasePresenter<View> {
        void getXianduData(String id, int count, int page);
    }

}

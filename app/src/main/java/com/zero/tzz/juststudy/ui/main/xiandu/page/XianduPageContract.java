package com.zero.tzz.juststudy.ui.main.xiandu.page;

import com.zero.tzz.juststudy.base.BasePresenter;
import com.zero.tzz.juststudy.base.BaseView;
import com.zero.tzz.juststudy.model.bean.gank.BaseBean;
import com.zero.tzz.juststudy.model.bean.gank.XianduChild;

/**
 * @author lucy
 * @date 2018-09-29 10:32
 * @description //TODO
 */

public interface XianduPageContract {
    interface View extends BaseView {
        void showXianduPage(BaseBean<XianduChild> bean);
    }

    interface Presenter extends BasePresenter<View> {
        void getXianduChild(String category);
    }
}

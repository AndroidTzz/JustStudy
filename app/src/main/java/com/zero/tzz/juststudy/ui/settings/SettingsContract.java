package com.zero.tzz.juststudy.ui.settings;

import com.zero.tzz.juststudy.base.BasePresenter;
import com.zero.tzz.juststudy.base.BaseView;

/**
 * @author lucy
 * @date 2018-09-27 09:59
 * @description //TODO
 */

public interface SettingsContract {
    interface View extends BaseView {
        void setTheme(int mode);
    }

    interface Presenter extends BasePresenter<View> {
        void changeThemeMode();
    }
}

package com.zero.tzz.juststudy.ui.settings;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatDelegate;

import com.zero.tzz.juststudy.base.BaseRxPresenter;
import com.zero.tzz.juststudy.model.DataManager;

import javax.inject.Inject;

/**
 * @author lucy
 * @date 2018-09-27 10:00
 * @description //TODO
 */

public class SettingsPresenter extends BaseRxPresenter<SettingsContract.View> implements SettingsContract.Presenter {
    private DataManager mDataManager;

    @Inject
    public SettingsPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void changeThemeMode() {
        // 当前模式
        int mode = mDataManager.getThemeMode();
        if (mode == Configuration.UI_MODE_NIGHT_YES) {
            mDataManager.setThemeMode(Configuration.UI_MODE_NIGHT_NO);
            mView.setTheme(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            mDataManager.setThemeMode(Configuration.UI_MODE_NIGHT_YES);
            mView.setTheme(AppCompatDelegate.MODE_NIGHT_YES);
        }
    }
}

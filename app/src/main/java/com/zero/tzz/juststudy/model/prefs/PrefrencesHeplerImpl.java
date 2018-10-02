package com.zero.tzz.juststudy.model.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.zero.tzz.juststudy.global.JustApp;
import com.zero.tzz.juststudy.global.JustConstants;

import javax.inject.Inject;

/**
 * @author lucy
 * @date 2018-09-26 15:42
 * @description //TODO
 */

public class PrefrencesHeplerImpl implements PrefrencesHelper {

    private final SharedPreferences mPreferences;

    @Inject
    public PrefrencesHeplerImpl() {
        mPreferences = JustApp.getInstance().getSharedPreferences(JustConstants.SP_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public int getThemeMode() {
        return mPreferences.getInt(JustConstants.NIGHT_MODE_KEY, JustConstants.UI_MODE_NIGHT_NO);
    }

    @Override
    public void setThemeMode(int mode) {
        mPreferences.edit().putInt(JustConstants.NIGHT_MODE_KEY, mode).apply();
    }
}

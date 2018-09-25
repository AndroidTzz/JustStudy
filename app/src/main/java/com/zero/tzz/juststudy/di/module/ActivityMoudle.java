package com.zero.tzz.juststudy.di.module;

import android.app.Activity;

import com.zero.tzz.juststudy.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityMoudle {

    /**
     * 提供 Activity 实例
     */
    private Activity mActivity;

    public ActivityMoudle(Activity activity) {
        mActivity = activity;
    }

    @ActivityScope
    @Provides
    public Activity provideActivity() {
        return mActivity;
    }
}

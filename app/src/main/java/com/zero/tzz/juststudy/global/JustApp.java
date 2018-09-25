package com.zero.tzz.juststudy.global;

import android.app.Activity;
import android.app.Application;

import com.zero.tzz.juststudy.di.component.ApplicationComponent;
import com.zero.tzz.juststudy.di.component.DaggerApplicationComponent;
import com.zero.tzz.juststudy.di.module.ApplicationModule;
import com.zero.tzz.juststudy.di.module.HttpModule;

import java.util.HashSet;
import java.util.Set;

public class JustApp extends Application {

    private static JustApp instance;

    private Set<Activity> mActivities;

    private ApplicationComponent mApplicationComponent;

    public static JustApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public void addActivity(Activity activity) {
        if (mActivities == null) {
            mActivities = new HashSet<>();
        }
        mActivities.add(activity);
    }

    public void removeActivity(Activity activity) {
        if (mActivities != null) {
            mActivities.remove(activity);
        }
    }

    public void exit() {
        if (mActivities != null && mActivities.size() > 0) {
            for (Activity activity : mActivities) {
                activity.finish();
            }
        }
        System.exit(0);
    }

    public ApplicationComponent getApplicationComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent =
                    DaggerApplicationComponent
                            .builder()
                            .applicationModule(new ApplicationModule(this))
                            .httpModule(new HttpModule())
                            .build();
        }
        return mApplicationComponent;
    }
}

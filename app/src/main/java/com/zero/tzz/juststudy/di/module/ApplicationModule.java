package com.zero.tzz.juststudy.di.module;

import com.zero.tzz.juststudy.global.JustApp;
import com.zero.tzz.juststudy.model.DataManager;
import com.zero.tzz.juststudy.model.db.DbHelper;
import com.zero.tzz.juststudy.model.db.DbHelperImpl;
import com.zero.tzz.juststudy.model.http.HttpHelper;
import com.zero.tzz.juststudy.model.http.HttpHelperImpl;
import com.zero.tzz.juststudy.model.prefs.PrefrencesHelper;
import com.zero.tzz.juststudy.model.prefs.PrefrencesHeplerImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private JustApp mApplication;

    public ApplicationModule(JustApp application) {
        mApplication = application;
    }

    @Singleton
    @Provides
    public JustApp provideApplication() {
        return mApplication;
    }

    // 获取HttpHelper实例
    // 由于HttpHelperImpl实现了HttpHelper接口，最终HttpHelper的调用会在HttpHelperImpl中执行
    @Singleton
    @Provides
    public HttpHelper provideHttpHelper(HttpHelperImpl helper) {
        return helper;
    }

    @Singleton
    @Provides
    public DbHelper provideDbHelper(DbHelperImpl dbHelper) {
        return dbHelper;
    }

    @Singleton
    @Provides
    public PrefrencesHelper providePrefrencesHelper(PrefrencesHeplerImpl prefrencesHepler) {
        return prefrencesHepler;
    }

    @Singleton
    @Provides
    public DataManager provideDataManager(HttpHelper httpHelper, DbHelper dbHelper, PrefrencesHelper prefrencesHepler) {
        return new DataManager(httpHelper, dbHelper, prefrencesHepler);
    }
}

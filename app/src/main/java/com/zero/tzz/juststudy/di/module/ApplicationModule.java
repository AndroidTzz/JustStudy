package com.zero.tzz.juststudy.di.module;

import com.zero.tzz.juststudy.global.JustApp;
import com.zero.tzz.juststudy.model.DataManager;
import com.zero.tzz.juststudy.model.http.HttpHelper;
import com.zero.tzz.juststudy.model.http.RetrofitHelper;

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
    // 由于RetrofitHelper实现了HttpHelper接口，最终HttpHelper的调用会在RetrofitHelper中执行
    @Singleton
    @Provides
    public HttpHelper provideRetrofitHelper(RetrofitHelper helper) {
        return helper;
    }

    @Singleton
    @Provides
    public DataManager provideDataManager(HttpHelper httpHelper) {
        return new DataManager(httpHelper);
    }
}

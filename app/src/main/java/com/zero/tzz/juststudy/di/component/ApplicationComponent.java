package com.zero.tzz.juststudy.di.component;

import com.zero.tzz.juststudy.di.module.ApplicationModule;
import com.zero.tzz.juststudy.di.module.HttpModule;
import com.zero.tzz.juststudy.model.DataManager;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {HttpModule.class, ApplicationModule.class})
public interface ApplicationComponent {
    /**
     * 全局变量的获取
     */

    DataManager getDataManager();
}

package com.zero.tzz.juststudy.di.component;

import com.zero.tzz.juststudy.di.module.ActivityMoudle;
import com.zero.tzz.juststudy.di.scope.ActivityScope;
import com.zero.tzz.juststudy.ui.main.MainActivity;
import com.zero.tzz.juststudy.ui.main.xiandu.page.detail.XianduDetailActivity;
import com.zero.tzz.juststudy.ui.settings.SettingsActivity;

import dagger.Component;

@ActivityScope
@Component(modules = ActivityMoudle.class, dependencies = ApplicationComponent.class)
public interface ActivityComponent {

    /**
     * Activity注入
     */
    void inject(MainActivity activity);

    void inject(XianduDetailActivity activity);

    void inject(SettingsActivity activity);

}

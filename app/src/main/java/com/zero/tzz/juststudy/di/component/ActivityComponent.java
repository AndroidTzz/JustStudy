package com.zero.tzz.juststudy.di.component;

import com.zero.tzz.juststudy.MainActivity;
import com.zero.tzz.juststudy.di.module.ActivityMoudle;
import com.zero.tzz.juststudy.di.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(modules = ActivityMoudle.class, dependencies = ApplicationComponent.class)
public interface ActivityComponent {

    /** Activity注入 */
    void inject(MainActivity activity);
}

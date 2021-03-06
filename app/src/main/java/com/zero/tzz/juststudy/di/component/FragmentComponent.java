package com.zero.tzz.juststudy.di.component;

import com.zero.tzz.juststudy.di.module.FragmentModule;
import com.zero.tzz.juststudy.di.scope.FragmentScope;
import com.zero.tzz.juststudy.ui.main.home.HomePageFragment;
import com.zero.tzz.juststudy.ui.main.meizi.MeiziFragment;
import com.zero.tzz.juststudy.ui.main.more.MoreFragment;
import com.zero.tzz.juststudy.ui.main.xiandu.XianduFragment;
import com.zero.tzz.juststudy.ui.main.xiandu.page.XianduPageFragment;

import dagger.Component;

@FragmentScope
@Component(modules = FragmentModule.class, dependencies = ApplicationComponent.class)
public interface FragmentComponent {

    void inject(HomePageFragment fragment);

    void inject(XianduFragment fragment);

    void inject(XianduPageFragment fragment);

    void inject(MeiziFragment fragment);

    void inject(MoreFragment fragment);
}

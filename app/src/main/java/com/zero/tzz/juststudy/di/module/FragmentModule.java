package com.zero.tzz.juststudy.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.zero.tzz.juststudy.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {

    private Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        mFragment = fragment;
    }

    @FragmentScope
    @Provides
    public Activity provideActivity() {
        return mFragment.getActivity();
    }
}

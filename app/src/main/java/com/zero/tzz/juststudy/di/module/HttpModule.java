package com.zero.tzz.juststudy.di.module;

import com.zero.tzz.juststudy.di.qualifier.GankUrl;
import com.zero.tzz.juststudy.model.http.api.GankApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class HttpModule {

    @Singleton
    @Provides
    public GankApi provideGankApi(@GankUrl Retrofit retrofit) {
        return retrofit.create(GankApi.class);
    }

    @GankUrl
    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return createRetrofit(GankApi.BASE_URL);
    }

    private Retrofit createRetrofit(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}

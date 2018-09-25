package com.zero.tzz.juststudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zero.tzz.juststudy.model.bean.gank.XianduDataBean;
import com.zero.tzz.juststudy.model.http.api.GankApi;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit.Builder builder = new Retrofit.Builder();
        GankApi gankApi =
                builder.baseUrl(GankApi.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build().create(GankApi.class);
        Observable<XianduDataBean> today = gankApi.xianduData("appinn", 10, 1);
        today.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<XianduDataBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(XianduDataBean bean) {
                System.out.println(bean.toString());
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {

            }
        });
    }
}

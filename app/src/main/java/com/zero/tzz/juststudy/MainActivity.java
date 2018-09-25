package com.zero.tzz.juststudy;

import android.widget.TextView;

import com.zero.tzz.juststudy.base.BaseActivity;
import com.zero.tzz.juststudy.model.DataManager;
import com.zero.tzz.juststudy.model.bean.gank.TodayBean;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity {
    @Inject
    DataManager mDataManager;

    @BindView(R.id.tv)
    TextView mTextView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void initEventAndData() {
        Observable<TodayBean> today = mDataManager.today();
        today.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TodayBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TodayBean bean) {
//                        mTextView.setText(bean.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        mTextView.setText(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}

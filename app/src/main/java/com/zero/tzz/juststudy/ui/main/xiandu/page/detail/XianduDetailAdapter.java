package com.zero.tzz.juststudy.ui.main.xiandu.page.detail;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zero.tzz.juststudy.R;
import com.zero.tzz.juststudy.model.bean.gank.XianduData;
import com.zero.tzz.juststudy.utils.JsoupUtil;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author lucy
 * @date 2018-09-29 13:35
 * @description //TODO
 */

public class XianduDetailAdapter extends BaseQuickAdapter<XianduData, BaseViewHolder> {
    public XianduDetailAdapter(int layoutResId, @Nullable List<XianduData> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, XianduData item) {
        Observable
                .create((ObservableOnSubscribe<String>) emitter -> {
                    String content = item.getContent();
                    emitter.onNext(content);
                })
                .map(JsoupUtil::stripHtml)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s ->
                        helper.setText(R.id.tv_xiandu_des, s)
                );
        String time = item.getPublished_at().split("T")[0];
        String title = item.getTitle();
        helper.setText(R.id.tv_xiandu_title, title)
                .setText(R.id.tv_xiandu_publish, time);
    }
}

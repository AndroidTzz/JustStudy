package com.zero.tzz.juststudy.ui.settings;

import android.support.v7.app.AppCompatDelegate;
import android.widget.TextView;

import com.zero.tzz.juststudy.R;
import com.zero.tzz.juststudy.base.BaseRxActivity;

import butterknife.BindView;

/**
 * @author lucy
 * @date 2018-09-30 15:51
 * @description //TODO
 */

public class SettingsActivity extends BaseRxActivity<SettingsPresenter> implements SettingsContract.View {
    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_settings;
    }

    @Override
    protected void initEventAndData() {
        tv.setText("setting");
        tv.setOnClickListener((view) ->
                mPresenter.changeThemeMode()
        );
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void onError(String errorMsg) {

    }

    @Override
    public void setCurrentTheme(int mode) {
        //获取当前的模式，设置相反的模式，这里只使用了，夜间和非夜间模式
        AppCompatDelegate.setDefaultNightMode(mode);
        recreate();
    }
}

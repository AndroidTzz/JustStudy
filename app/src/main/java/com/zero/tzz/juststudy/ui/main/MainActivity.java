package com.zero.tzz.juststudy.ui.main;

import android.widget.TextView;

import com.zero.tzz.juststudy.R;
import com.zero.tzz.juststudy.base.BaseActivity;
import com.zero.tzz.juststudy.model.bean.gank.BaseBean;
import com.zero.tzz.juststudy.model.bean.gank.Ganhuo;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

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
        mPresenter.ganhuo();
    }

    @Override
    public void success(BaseBean<Ganhuo> ganhuoBean) {
        mTextView.setText(ganhuoBean.toString());
    }
}

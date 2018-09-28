package com.zero.tzz.juststudy.ui.main.xiandu;

import com.zero.tzz.juststudy.R;
import com.zero.tzz.juststudy.base.BaseRxFragment;


public class XianduFragment extends BaseRxFragment<XianduPresenter> implements XianduContract.View {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_xiandu;
    }

    @Override
    protected void initDataAndEvent() {

    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }
}

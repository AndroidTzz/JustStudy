package com.zero.tzz.juststudy.ui.main.more;

import android.content.Intent;
import android.widget.TextView;

import com.zero.tzz.juststudy.R;
import com.zero.tzz.juststudy.base.BaseFragment;
import com.zero.tzz.juststudy.ui.settings.SettingsActivity;

import butterknife.BindView;

public class MoreFragment extends BaseFragment {

    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_more;
    }

    @Override
    protected void initDataAndEvent() {
        tv.setOnClickListener((view) ->
                startActivity(new Intent(mContext, SettingsActivity.class))
        );
    }
}

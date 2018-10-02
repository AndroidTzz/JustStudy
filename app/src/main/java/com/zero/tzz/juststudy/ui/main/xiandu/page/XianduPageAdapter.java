package com.zero.tzz.juststudy.ui.main.xiandu.page;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zero.tzz.juststudy.R;
import com.zero.tzz.juststudy.model.bean.gank.XianduChild;

import java.util.List;

/**
 * @author lucy
 * @date 2018-09-29 11:57
 * @description //TODO
 */

public class XianduPageAdapter extends BaseQuickAdapter<XianduChild,XianduPageAdapter.XianduPageViewHolder> {

    public XianduPageAdapter(int layoutResId, @Nullable List<XianduChild> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(XianduPageViewHolder helper, XianduChild item) {
        helper.tvTitle.setText(item.getTitle());
        Glide.with(mContext).load(item.getIcon()).into(helper.ivIcon);
    }

    class XianduPageViewHolder extends BaseViewHolder {
        ImageView ivIcon;
        TextView tvTitle;
        public XianduPageViewHolder(View view) {
            super(view);
            ivIcon = view.findViewById(R.id.iv_xiandu_icon);
            tvTitle = view.findViewById(R.id.tv_xiandu_title);
        }
    }
}

package com.zero.tzz.juststudy.ui.main.home;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zero.tzz.juststudy.R;
import com.zero.tzz.juststudy.model.bean.gank.Ganhuo;

import java.util.List;


public class HomePageAdapter extends BaseQuickAdapter<Ganhuo, HomePageAdapter.HomeItemViewholder> {

    public HomePageAdapter(int layoutResId, @Nullable List<Ganhuo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(HomeItemViewholder helper, Ganhuo item) {
        helper.tvTitle.setText(item.getDesc());
        helper.tvAuthore.setText(item.getWho());
        helper.tvDate.setText(item.getPublishedAt().split("T")[0]);
        List<String> images = item.getImages();
        if (images != null && images.size() > 0) {
            helper.ivPicture.setVisibility(View.VISIBLE);
            Glide.with(mContext).load(images.get(0)).into(helper.ivPicture);
        } else {
            helper.ivPicture.setVisibility(View.GONE);
        }
    }

    class HomeItemViewholder extends BaseViewHolder {
        TextView tvTitle;
        TextView tvAuthore;
        TextView tvDate;
        ImageView ivPicture;

        public HomeItemViewholder(View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tv_title);
            tvAuthore = view.findViewById(R.id.tv_author);
            tvDate = view.findViewById(R.id.tv_date);
            ivPicture = view.findViewById(R.id.iv_picture);
        }
    }
}


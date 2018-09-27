package com.zero.tzz.juststudy.ui.main.meizi;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zero.tzz.juststudy.R;
import com.zero.tzz.juststudy.model.bean.gank.Ganhuo;
import com.zero.tzz.juststudy.utils.Utils;

import java.util.HashMap;
import java.util.List;

/**
 * @author lucy
 * @date 2018-09-27 11:51
 * @description //TODO
 */

public class MeiziAdapter extends BaseQuickAdapter<Ganhuo, MeiziAdapter.MeiziViewHolder> {

    HashMap<Integer, Float> indexMap = new HashMap<>();
    private int screenWidth;
    private final static float SIZE_SCALE_01 = 0.6f;
    private final static float SIZE_SCALE_02 = 1f;

    public MeiziAdapter(Context context, int layoutResId, @Nullable List<Ganhuo> data) {
        super(layoutResId, data);

        screenWidth = Utils.getScreenSize(context)[0];
    }

    @Override
    protected void convert(MeiziAdapter.MeiziViewHolder helper, Ganhuo item) {
        resizeItemView(helper.ivMeizi, getScaleType(helper.getAdapterPosition()));
        Glide.with(mContext).load(item.getUrl()).into(helper.ivMeizi);
    }

    private float getScaleType(int position) {
        if (!indexMap.containsKey(position)) {
            float scaleType;
            if (getHeaderLayoutCount() != 0) {
                if (position == 1) {
                    scaleType = SIZE_SCALE_01;
                } else if (position == 2) {
                    scaleType = SIZE_SCALE_02;
                } else {
                    scaleType = Utils.getRandomInt() % 2 == 0 ? SIZE_SCALE_01 : SIZE_SCALE_02;
                }
            } else {
                if (position == 0) {
                    scaleType = SIZE_SCALE_01;
                } else if (position == 1) {
                    scaleType = SIZE_SCALE_02;
                } else {
                    scaleType = Utils.getRandomInt() % 2 == 0 ? SIZE_SCALE_01 : SIZE_SCALE_02;
                }
            }
            indexMap.put(position, scaleType);
        }

        return indexMap.get(position);
    }

    private void resizeItemView(ImageView frontCoverImage, float scaleType) {
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) frontCoverImage.getLayoutParams();
        params.width = screenWidth / 2;
        params.height = (int) (params.width / scaleType);
        frontCoverImage.setLayoutParams(params);
    }


    class MeiziViewHolder extends BaseViewHolder {
        ImageView ivMeizi;

        public MeiziViewHolder(View view) {
            super(view);
            ivMeizi = view.findViewById(R.id.iv_meizi);
        }
    }
}
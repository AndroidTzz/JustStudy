package com.zero.tzz.juststudy.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int space;
    private int l;
    private int b;
    private int t;
    private int r;

    public SpacesItemDecoration(int l,int b,int t,int r) {
        this.l = l;
        this.b = b;
        this.t = t;
        this.r = r;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        int position = parent.getChildAdapterPosition(view);
//        int count = parent.getAdapter().getItemCount() - 1;
//        // head
//        if (position == 0 || position == 1) {
//            outRect.top = space;
//        } else {
//            outRect.top = space / 2;
//        }
//        // foot
//        if (position == count || position == count - 1) {
//            outRect.bottom = space;
//        } else {
//            outRect.bottom = space / 2;
//        }
//        // left and right
//        if (position % 2 == 0) {
//            outRect.right = space / 2;
//            outRect.left = space;
//        } else {
//            outRect.right = space;
//            outRect.left = space / 2;
//        }
        outRect.top = t;
        outRect.bottom = b;
        outRect.right = r;
        outRect.left = l;
    }
}

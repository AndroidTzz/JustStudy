package com.zero.tzz.juststudy.widgets.behavior;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

public class BottomNavigationBehavior extends CoordinatorLayout.Behavior<View> {

    private ObjectAnimator mHideAnimator, mShowAnimator;

    public BottomNavigationBehavior() {
    }

    public BottomNavigationBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        // 上滑 隐藏
        if (dy > 0) {
            if (mHideAnimator == null) {
                mHideAnimator = ObjectAnimator.ofFloat(child, "translationY", 0, child.getHeight());
                mHideAnimator.setDuration(200);
            }
            if (!mHideAnimator.isRunning() && child.getTranslationY() <= 0) {
                mHideAnimator.start();
            }
        }
        // 下滑 显示
        else if (dy < 0) {
            if (mShowAnimator == null) {
                mShowAnimator = ObjectAnimator.ofFloat(child, "translationY", child.getHeight(), 0);
                mShowAnimator.setDuration(200);
            }
            if (!mShowAnimator.isRunning() && child.getTranslationY() >= child.getHeight()) {
                mShowAnimator.start();
            }
        }
    }
}

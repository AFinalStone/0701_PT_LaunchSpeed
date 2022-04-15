package com.afs.customerview.flowlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class FlowLayout extends ViewGroup {
    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //度量
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            LayoutParams childLp = childView.getLayoutParams();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec, paddingLeft + paddingRight, childLp.width);
            int childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec, paddingLeft + paddingRight, childLp.height);
        }
    }

    //布局
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }


}

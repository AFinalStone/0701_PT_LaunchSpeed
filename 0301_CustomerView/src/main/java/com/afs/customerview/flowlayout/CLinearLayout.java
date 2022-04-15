package com.afs.customerview.flowlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class CLinearLayout extends ViewGroup {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private int mOrientation;
    private int mTotalLength;

    public CLinearLayout(Context context) {
        super(context);
    }

    public CLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (mOrientation == VERTICAL) {
            measureVertical(widthMeasureSpec, heightMeasureSpec);
        } else {
            measureHorizontal(widthMeasureSpec, heightMeasureSpec);
        }
    }

    private void measureHorizontal(int widthMeasureSpec, int heightMeasureSpec) {
    }

    private void measureVertical(int widthMeasureSpec, int heightMeasureSpec) {
        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int measureWidth = MeasureSpec.getSize(widthMeasureSpec);
        int measureHeight = MeasureSpec.getSize(heightMeasureSpec);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}

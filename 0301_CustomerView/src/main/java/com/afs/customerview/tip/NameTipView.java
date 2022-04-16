package com.afs.customerview.tip;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class NameTipView extends View {
    public NameTipView(Context context) {
        super(context);
    }

    public NameTipView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NameTipView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}

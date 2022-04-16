package com.example.customersurfaceview.demo01;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SurfaceView01 extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    public SurfaceView01(Context context) {
        this(context, null);
    }

    public SurfaceView01(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SurfaceView01(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        //创建
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        //改变
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        //销毁
    }

    @Override
    public void run() {
        //子线程
    }
}
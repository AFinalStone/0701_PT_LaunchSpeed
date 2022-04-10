package com.example.performancetuning;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;

import androidx.appcompat.app.AppCompatActivity;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        delayTest();
        String[] strings = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(strings, 200);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        //埋点结束，期间start 到 stop 之间的代码，就是你要测试的代码范围
//        Debug.stopMethodTracing();
        super.onWindowFocusChanged(hasFocus);
    }

    private void delayTest() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
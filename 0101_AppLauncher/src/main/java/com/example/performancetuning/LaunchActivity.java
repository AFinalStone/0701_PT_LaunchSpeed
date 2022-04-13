package com.example.performancetuning;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.performancetuning.home.HomeActivity;

import java.util.List;

public class LaunchActivity extends AppCompatActivity {

    private boolean mIsInit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] strings = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(strings, 200);
        }

//        delayTest();
//        File file = new File("/sdcard/leo.txt");
//        FileOutputStream fileOutputStream = null;
//        try {
//            fileOutputStream = new FileOutputStream(file);
//            fileOutputStream.write(1);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (fileOutputStream != null) {
//                try {
//                    fileOutputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (!mIsInit) {
            mIsInit = true;
            System.out.println("===========app初始化");
            delayTest();
        }
        System.out.println("===========焦点发生了改变");
        super.onWindowFocusChanged(hasFocus);
    }

    private void delayTest() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void toHomeOnClick(View view) {
        startActivity(new Intent(this, HomeActivity.class));
    }
}
package com.example.performancetuning.home;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.performancetuning.R;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        new Thread() {
            @Override
            public void run() {
                PackageManager packageManager = getPackageManager();
                //使用当前Activity的Intent获取当前应用的包名信息
                List<ResolveInfo> list = packageManager.queryIntentActivities(getIntent(), 0);
                System.out.println("正在查询当前应用包名信息===================");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println("===================" + list.get(i).toString());
                }

                //使用桌面程序的Intent获取当前手机上的所有应用包名信息列表
                System.out.println();
                System.out.println("--------------------------------------------------");
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                list = packageManager.queryIntentActivities(intent, 0);
                System.out.println("正在查询手机上所有应用包名信息===================");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println("===================" + list.get(i).toString());
                }
            }
        }.start();
    }
}
package com.afs.bugly;

import android.app.Application;

public class HApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //bugly初始化
        CrashReport.initCrashReport(this, BuildConfig.BUGLY_APPID, BuildConfig.DEBUG);
    }
}

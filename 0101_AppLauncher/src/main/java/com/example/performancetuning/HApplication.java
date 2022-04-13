package com.example.performancetuning;

import android.app.Application;
import android.os.Debug;
import android.os.StrictMode;

public class HApplication extends Application {
    public HApplication() {
        //可以用以下代码测试你的代码。
        //开始埋点，“app”是最后生成的性能分析文件
//        Debug.startMethodTracing("testapp");
    }

    @Override
    public void onCreate() {
//        if (BuildConfig.DEBUG) {
//            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
//                    .detectDiskReads()//检测磁盘读操作
//                    .detectDiskWrites()//检测磁盘写操作
////                    .detectNetwork()
//                    .penaltyDialog()//违规则打印日志
//                    .penaltyDeath()//违规则崩溃
//                    .build());
//            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
//                    .detectLeakedSqlLiteObjects()//sqlite 对象泄漏
//                    .detectLeakedClosableObjects()//未关闭的Closeable对象泄漏
//                    .penaltyLog()//违规则打印日志
//                    .penaltyDeath()//违规则崩溃
//                    .build());
//        }
        super.onCreate();
    }
}

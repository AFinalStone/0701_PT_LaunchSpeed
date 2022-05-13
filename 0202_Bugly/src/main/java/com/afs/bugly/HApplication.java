package com.afs.bugly;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

public class HApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //bugly初始化
        CrashReport.initCrashReport(this, BuildConfig.BUGLY_APPID, BuildConfig.DEBUG);
    }

    private void test() {
        try {
//            Object c = ReflectUtil.getStaticField("com.tencent.bugly.crashreport.crash.c", "q");
//            e e = ReflectUtil.getField(c, "r");
//            b b = ReflectUtil.getField(e, "b");
//            CrashDetailBean crashDetailBean = (CrashDetailBean) ReflectUtil.invokeMethod(e, "b",
//                    new Class[]{Thread.class, Throwable.class, boolean.class, String.class, byte[].class},
//                    new Object[]{Thread.currentThread(), new Throwable("卡顿监测"), true, null, null});
//            b.a(crashDetailBean, 3000L, true);
//            Class clazz = Class.forName("com.tencent.bugly.crashreport.crash.c");
//            Field field_c = clazz.getDeclaredField("q");
//            field_c.setAccessible(true);
//            Object c = field_c.get(null);
//            Class<c> = c.get

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

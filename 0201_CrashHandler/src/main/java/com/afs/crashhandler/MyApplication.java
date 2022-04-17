package com.afs.crashhandler;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MyApplication extends Application {

    //用于存储设备信息
    private Map<String, String> mInfo = new HashMap<>();
    //格式化时间，作为Log文件名
    private java.text.DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");

    @Override
    public void onCreate() {
        super.onCreate();

        CrashHandler.getInstance().register(getApplicationContext());
    }


    private void errorInfo2SD(Throwable e) {
        PackageManager pm = getPackageManager();
        try {
            PackageInfo info = pm.getPackageInfo(getPackageName(), PackageManager.GET_ACTIVITIES);
            // 获取版本信息
            if (info != null) {
                String versionName = TextUtils.isEmpty(info.versionName) ? "未设置版本名称" : info.versionName;
                String versionCode = info.versionCode + "";
                mInfo.put("versionName", versionName);
                mInfo.put("versionCode", versionCode);
            }
            // 获取设备信息
            Field[] fields = Build.class.getFields();
            if (fields != null && fields.length > 0) {
                for (Field field : fields) {
                    field.setAccessible(true);
                    mInfo.put(field.getName(), field.get(null).toString());
                }
            }
            // 存储信息到 sd 卡指定目录
            saveErrorInfo(e);
        } catch (PackageManager.NameNotFoundException es) {
            es.printStackTrace();
        } catch (IllegalAccessException es) {
            es.printStackTrace();
        }
    }

    private void saveErrorInfo(Throwable e) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : mInfo.entrySet()) {
            String keyName = entry.getKey();
            String value = entry.getValue();
            stringBuffer.append(keyName + "=" + value + "\n");
        }
        stringBuffer.append("\n-----Crash Log Begin-----\n");
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        e.printStackTrace(writer);
        Throwable cause = e.getCause();
        while (cause != null) {
            cause.printStackTrace(writer);
            cause = e.getCause();
        }
        writer.close();
        String string = stringWriter.toString();
        stringBuffer.append(string);
        stringBuffer.append("\n-----Crash Log End-----");
        String format = dateFormat.format(new Date());
        String fileName = "crash-" + format + ".log";

        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            String path = getFilesDir() + File.separator + "crash";
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            FileOutputStream fou = null;
            try {
                fou = new FileOutputStream(new File(path, fileName));
                fou.write(stringBuffer.toString().getBytes());
                fou.flush();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                try {
                    if (fou != null) {
                        fou.close();
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}

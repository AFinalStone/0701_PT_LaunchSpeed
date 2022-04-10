package com.example.performancetuning;

import android.app.Application;
import android.os.Debug;

public class HApplication extends Application {
    public HApplication() {
        //可以用以下代码测试你的代码。
        //开始埋点，“app”是最后生成的性能分析文件
//        Debug.startMethodTracing("testapp");
    }


}

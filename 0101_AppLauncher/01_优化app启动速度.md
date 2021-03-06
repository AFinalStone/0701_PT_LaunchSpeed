## 一、基本概念

### 1.2 冷启动

冷启动是指应用程序从头开始启动：系统进程在冷启动之后创建应用程序进程，发生冷启动的情况包括应用自设备启动后或者系统终止应用后首次启动。

### 1.1 热启动

在热启动中，系统的所有工作就是将Activity带到前台。只要应用的所有activity仍驻留在内存中，应用就不必重复执行对象初始化、布局加载和绘制。

### 1.3 温启动

温启东包含了再启动期间发生的部分操作；同时，他的开销要比热启动高。有许多潜在的状态可视为热启动。 例如：

- 用户在退出应用后又重新启动应用、进程可能未被销毁，继续运行，但应用需要执行onCreate从头开始重新创建Activity
- 系统将应用从内存中释放，然后用户又重新启动他。进程和Activity需要重启。但传递到onCreate的已经保存的实例savedInstanceState对于完成此任务有一定助益。

### 1.4 应用程序启动的258原则

- 2秒内启动，用户觉得很快；5秒以内，用户觉得还凑合；8秒以内，用户觉得比较慢；8秒以上，用户直接卸载app走人

## 二、优化应用程序启动

### 2.1 如何统计app的启动时间

- 使用displayed关键字过滤系统日志信息
- 使用adb命令：adb shell

```cmd
generic_x86_arm:/ $ am start -S -W com.example.performancetuning/.LaunchActivity
Stopping: com.example.performancetuning
Starting: Intent { act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] cmp=com.example.performancetuning/.LaunchActivity }
Status: ok
LaunchState: COLD
Activity: com.example.performancetuning/.LaunchActivity
TotalTime: 3619
WaitTime: 3621
Complete
```

TotalTime就是应用的启动时间

### 2.2 处理黑白屏问题（启动优化治标）

主要是修改LaunchActivity的背景颜色

```xml

<style name="LaunchActivityStyle" parent="Theme.PerformanceTuning">
    <!-- Customize your theme here. -->
    <item name="android:windowBackground">@color/teal_200</item>
</style>

```

```xml

<activity android:name=".LaunchActivity" android:exported="true"
    android:theme="@style/LaunchActivityStyle">
    <intent-filter>
        <action android:name="android.intent.action.MAIN" />

        <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>
</activity>
```

### 2.3 处理黑白屏问题（启动优化治本）

- ActivityThread->handleLaunchActivity
- ActivityThread->performLaunchActivity
- Activity->attach
- **Window->setCall(this)**
- ActivityThread->handleResumeActivity
- ActivityThread->performResumeActivity
- Activity->onResume
- ActivityThread->handleResumeActivity
- WindowManager->addView
- WindowManagerImpl->addView
- WindowManagerGlobal->addView
- WindowManagerImpl->setView
- Session->addToDisplay(iWindow)
- WindowManagerService->addWindow(iWindow)
- WindowManagerService->updateFocusedWindowLocked()
- WindowManagerService->sendMessage(REPORT_FOCUS_CHANGE)
- iWindow(WindowManagerImpl).windowFocusChanged
- iWindow(WindowManagerImpl).sendMessage(MSG_WINDOW_FOCUS_CHANGED)
- iWindow(WindowManagerImpl).handleWindowFocusChanged
- mView(DecorView).dispatchWindowFocusChanged
- mView(DecorView).onWindowFocusChanged
- mWindow.getCallback();
- **Activity.onWindowFocusChanged()**;

根据Activity的启动流程我们知道，我们可以把耗时操作移动到onWindowFocusChanged方法中就可以了

## 三、性能分析工具

### 3.1 Android Profiling性能检测工具

### 3.2 使用Debug生成性能检测文件

- Debug.startMethodTracing("testapp");
- Debug.stopMethodTracing()

### 3.2 StrictMode的使用

```java
public class HApplication extends Application {

    @Override
    public void onCreate() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()//检测磁盘读操作
                    .detectDiskWrites()//检测磁盘写操作
//                    .detectNetwork()
                    .penaltyDialog()//违规则打印日志
                    .penaltyDeath()//违规则崩溃
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()//sqlite 对象泄漏
                    .detectLeakedClosableObjects()//未关闭的Closeable对象泄漏
                    .penaltyLog()//违规则打印日志
                    .penaltyDeath()//违规则崩溃
                    .build());
        }
        super.onCreate();
    }
}
```









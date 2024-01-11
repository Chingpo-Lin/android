package com.example.mydemo.service;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

// 注意事项
//服务被杀死:Android 系统可能会在内存不足时终止后台服务，导致服务被杀死。为了解决这个问题， 可以使用前台服务(Foreground Service)并显示一个通知，以提高服务的优先级。
//内存泄漏:如果服务未正确停止，可能会导致内存泄漏。确保在服务完成任务后调用 stopSelf() 或 stopService()，并释放所有持有的资源。
//主线程阻塞:在服务中执行长时间运行的操作，可能会导致主线程阻塞，影响应用的响应性。使用后台 线程或异步任务来执行耗时操作，以避免主线程阻塞。
//无法与服务通信:如果应用的组件无法与服务通信，可能是由于绑定服务时返回的 IBinder 对象为 null 。确保在服务的 onBind 方法中返回一个有效的 IBinder 对象。
//ServiceConnection问题:在绑定服务时，确保正确实现 ServiceConnection 接口，特别是在 onServiceDisconnected 方法中处理服务意外断开的情况。
public class FirstService extends IntentService {

    private static final String TAG = "FirstService";

    public FirstService() {
        super("FirstService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                Log.d(TAG, "First Service" + i);
            }
        } catch (Exception e) {
            Log.e(TAG, "error", e);
        }
    }
}
package com.example.mydemo.service;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

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
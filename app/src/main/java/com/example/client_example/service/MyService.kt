package com.example.client_example.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {
    private val TAG = "MyService"

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // doing some tasks

        Thread.sleep(1000)
        Log.d(TAG, "onStartCommand: Service started")
        return START_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
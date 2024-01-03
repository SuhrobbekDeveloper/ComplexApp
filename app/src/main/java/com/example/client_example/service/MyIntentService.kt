package com.example.client_example.service

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService:IntentService("IntentTaskService") {
    private val TAG = "MyIntentService"
    @Deprecated("Deprecated in Java")
    override fun onHandleIntent(p0: Intent?) {
        Log.d(TAG, "onHandleIntent: Handle ")
    }

    @Deprecated("Deprecated in Java", ReplaceWith("super.onDestroy()", "android.app.IntentService"))
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Farewell")
    }
}
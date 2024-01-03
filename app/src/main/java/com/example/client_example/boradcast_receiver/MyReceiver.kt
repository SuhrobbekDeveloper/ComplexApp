package com.example.client_example.boradcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == "custom.action") {
            showToast(context, "Custom broadcast Received")
        }
    }

    private fun showToast(context: Context?, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}
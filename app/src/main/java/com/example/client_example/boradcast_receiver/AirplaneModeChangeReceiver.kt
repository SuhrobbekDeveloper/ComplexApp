package com.example.client_example.boradcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeChangeReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplaneModeEnabled = intent?.getBooleanExtra("state", false) ?: return
        if (isAirplaneModeEnabled){
            Toast.makeText(context, "Enabled", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "Disabled", Toast.LENGTH_SHORT).show()
        }

    }
}
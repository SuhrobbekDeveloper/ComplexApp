package com.example.client_example

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class MyService : Service() {

    private lateinit var player: MediaPlayer

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)

        // providing the boolean
        // value as true to play
        // the audio on loop
        player.isLooping = true

        // starting the process
        player.start()

        // returns the status
        // of the program
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        player.stop()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}
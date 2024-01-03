package com.example.client_example

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import android.preference.PreferenceManager
import com.ramt57.easylocale.EasyLocaleApplicationDelegates


class App:Application() {
    private val localeAppDelegate = EasyLocaleApplicationDelegates()
    override fun onCreate() {
        super.onCreate()

    }
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(localeAppDelegate.attachBaseContext(base))
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        localeAppDelegate.onConfigurationChanged(this)
    }
}
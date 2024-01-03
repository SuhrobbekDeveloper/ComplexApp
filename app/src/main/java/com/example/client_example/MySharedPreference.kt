package com.example.client_example

import android.content.Context
import android.text.TextUtils


class MySharedPreference(context: Context) {
    private val appSharedPrefs = context.getSharedPreferences("have", Context.MODE_PRIVATE)

    fun setDarkMode(key: String?, value: String?) {
        val prefsEditor = appSharedPrefs?.edit()
        prefsEditor?.putString(key, value)
        prefsEditor?.apply()
    }

    fun getDarkMode(key: String?): String? {
        val json = appSharedPrefs?.getString(key, "")
        return if (TextUtils.isEmpty(json)) {
            null
        } else json
    }

    fun setLanguage(key: String?, value: String?) {
        val edit = appSharedPrefs?.edit()
        edit?.putString(key, value)
        edit?.apply()
    }

    fun getPreference(): String? {
        val string = appSharedPrefs.getString("Locale.Helper.Selected.Language", "")
        return if (TextUtils.isEmpty(string)) {
            null
        } else string
    }

    fun setPreferences(selectedLanguage: String, language: String) {
        val prefsEditor = appSharedPrefs?.edit()
        prefsEditor?.putString(selectedLanguage, language)
        prefsEditor?.apply()
    }

    fun setMessage(text: String) {
        val prefsEditor = appSharedPrefs?.edit()
        prefsEditor?.putString("message", text)
        prefsEditor?.apply()
    }

    fun getMessage(): String? {
        val string = appSharedPrefs.getString("message", "")
        return if (TextUtils.isEmpty(string)) {
            null
        } else string
    }

}
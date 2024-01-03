package com.example.client_example.ui2

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.client_example.MySharedPreference
import com.example.client_example.R
import com.example.client_example.databinding.ActivityCBinding

class ActivityC : AppCompatActivity() {
    private lateinit var binding: ActivityCBinding
    private lateinit var mySharedPreference: MySharedPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mySharedPreference = MySharedPreference(this)
        val nightModeFlags =
            resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)
        when (nightModeFlags) {
            Configuration.UI_MODE_NIGHT_YES -> {
                mySharedPreference.setDarkMode("mode", "night")
            }

            Configuration.UI_MODE_NIGHT_NO -> {
                mySharedPreference.setDarkMode("mode", "day")
            }

            Configuration.UI_MODE_NIGHT_UNDEFINED -> {

            }
        }
        /*  val darkMode = mySharedPreference.getDarkMode("mode")
          if (darkMode != null) {
              if (darkMode.isNotEmpty()) {
                  val i = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
                  when (darkMode) {
                      "night" -> {
                          delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
                          mySharedPreference.setDarkMode("mode", "day")
                      }

                      "day" -> {
                          delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
                          mySharedPreference.setDarkMode("mode", "night")
                      }

                      else -> {
                          delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
                      }
                  }
              } else {
                  delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
                  mySharedPreference.setDarkMode("mode", "day")
              }
          } else {
              delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
              mySharedPreference.setDarkMode("mode", "day")
          }*/
        binding.apply {
            btn.setOnClickListener {
                val intent = Intent(this@ActivityC, ActivityA::class.java)
                startActivity(intent)
            }
        }
    }
}
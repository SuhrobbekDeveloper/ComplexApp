package com.example.client_example.ui2

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.client_example.App
import com.example.client_example.MySharedPreference
import com.example.client_example.R
import com.example.client_example.databinding.ActivityBBinding

class ActivityB : AppCompatActivity() {
    private lateinit var binding: ActivityBBinding
    private lateinit var mySharedPreference: MySharedPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mySharedPreference = MySharedPreference(this)
        binding.apply {
            btn.setOnClickListener {
                val intent = Intent(this@ActivityB, ActivityC::class.java)
                startActivity(intent)
            }

            val nightModeFlags =
                resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)
            when (nightModeFlags) {
                Configuration.UI_MODE_NIGHT_YES -> {
                    binding.dayNight.setImageResource(R.drawable.sleep_mode)
                    mySharedPreference.setDarkMode("mode", "night")
                }

                Configuration.UI_MODE_NIGHT_NO -> {
                    binding.dayNight.setImageResource(R.drawable.day_mode)
                    mySharedPreference.setDarkMode("mode", "day")
                }

                Configuration.UI_MODE_NIGHT_UNDEFINED -> {

                }
            }
            val isDarkMode = mySharedPreference.getDarkMode("mode")
            binding.dayNight.setOnClickListener {
                if (isDarkMode == "night") {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    mySharedPreference.setDarkMode("mode", "day")
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    mySharedPreference.setDarkMode("mode", "night")
                }
            }
            /*
                        dayNight.setOnClickListener {
                            if (darkMode != null) {
                                if (darkMode.isNotEmpty()) {
                                    val i = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
                                    when (i) {
                                        Configuration.UI_MODE_NIGHT_YES -> {
                                            delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
                                            mySharedPreference.setDarkMode("mode", "day")
                                        }

                                        Configuration.UI_MODE_NIGHT_NO -> {
                                            delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
                                            mySharedPreference.setDarkMode("mode", "night")
                                        }

                                        Configuration.UI_MODE_NIGHT_UNDEFINED -> {
                                            delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_UNSPECIFIED
                                        }
                                    }
                                } else {
                                    delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
                                    mySharedPreference.setDarkMode("mode", "day")
                                }
                            } else {
                                delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
                                mySharedPreference.setDarkMode("mode", "day")
                            }
                        }
            */
        }
    }
}
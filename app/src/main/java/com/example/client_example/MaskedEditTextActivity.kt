package com.example.client_example

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.client_example.databinding.ActivityMaskedEditTextBinding
import com.hbb20.CountryCodePicker
import com.ramt57.easylocale.EasyLocaleActivityDelegate
import com.ramt57.easylocale.EasyLocaleChangeListner
import java.util.Locale

class MaskedEditTextActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMaskedEditTextBinding
    private val localeDelegate = EasyLocaleActivityDelegate()

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(localeDelegate.attachBaseContext(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMaskedEditTextBinding.inflate(layoutInflater)
        setContentView(binding.root)
        localeDelegate.initialise(this, this)
        binding.apply {
            ccp.registerCarrierNumberEditText(number)
            ccp.setPhoneNumberValidityChangeListener {
                if (it) {
                    // It checks input number is valid or not
                }
            }
            btnToEnglish.setOnClickListener {
                localeDelegate.setLocale(this@MaskedEditTextActivity, Locale("en"))
            }
            btnToRussian.setOnClickListener {
                localeDelegate.setLocale(this@MaskedEditTextActivity, Locale("ru"))
            }
        }
    }
}
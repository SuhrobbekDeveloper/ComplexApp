package com.example.client_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.client_example.databinding.ActivityCoroutine2Binding
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import java.lang.Exception

class Coroutine2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityCoroutine2Binding
    private val TAG = "Coroutine2Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutine2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val handler = CoroutineExceptionHandler { _, throwable ->
            Log.d(TAG, "onCreate: Caught exception $throwable")
        }

        CoroutineScope(Dispatchers.Main+handler).launch {
            supervisorScope {
                launch {
                    delay(300)
                    throw Exception("Coroutine 1 failed")
                }
                launch {
                    delay(400)
                    Log.d(TAG, "onCreate: Coroutine 2 finished")
                }
            }
        }
    }
}
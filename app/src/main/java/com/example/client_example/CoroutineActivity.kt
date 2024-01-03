package com.example.client_example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.client_example.databinding.ActivityCoroutineBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class CoroutineActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoroutineBinding
    private val TAG = "CoroutineActivity"

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutineBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            startBtn.setOnClickListener {
                val job: Job = lifecycleScope.launch {
                    while (true) {
                        delay(1000)
                        Log.d(TAG, "onCreate: Still running...")
                    }
                }
                GlobalScope.launch {
                    delay(5000)
                    Intent(this@CoroutineActivity, Coroutine2Activity::class.java).also {
                        startActivity(it)
                        finish()
                    }
                }
            }
        }

        val async = GlobalScope.launch(Dispatchers.IO) {
            var timeMillis = measureTimeMillis {
                val async1 = async { networkCall1() }
                val async2 = async { networkCall2() }
                Log.d(TAG, "onCreate: ${async1.await()}")
                Log.d(TAG, "onCreate: ${async2.await()}")
            }
            Log.d(TAG, "onCreate: Requests took ${timeMillis}  ms")
        }
    }

    suspend fun networkCall1(): String {
        delay(3000)
        return "Answer1"
    }

    suspend fun networkCall2(): String {
        delay(3000)
        return "Answer2"
    }
}
package com.example.client_example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.client_example.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.io.OutputStream
import java.net.Socket
import java.util.Scanner

class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            startButton.setOnClickListener {
                startService(Intent(this@MainActivity2, MyService()::class.java))
            }
            stopButton.setOnClickListener {
                stopService(Intent(this@MainActivity2, MyService()::class.java))
            }
        }
    }

    override fun onClick(p0: View?) {

    }
}
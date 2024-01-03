package com.example.client_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CoroutinesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)
        main()
    }

    fun main() = runBlocking {
        launch { doWorld() }
        Toast.makeText(this@CoroutinesActivity, "Hello", Toast.LENGTH_SHORT).show()
    }

    suspend fun doWorld() {
        delay(1000)
        Toast.makeText(this, "World", Toast.LENGTH_SHORT).show()
    }
}
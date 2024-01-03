package com.example.client_example.ui2

import android.Manifest
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.graphics.Color
import android.content.res.Configuration.*
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.*
import com.example.client_example.MySharedPreference
import com.example.client_example.boradcast_receiver.AirplaneModeChangeReceiver
import com.example.client_example.databinding.ActivityActivityBinding
import com.example.client_example.mvp.GreetingModel
import com.example.client_example.mvp.GreetingPresenter
import com.example.client_example.mvp.GreetingView
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull
import okhttp3.OkHttpClient

class ActivityA : AppCompatActivity(),GreetingView {
    private lateinit var binding: ActivityActivityBinding
    private lateinit var mySharedPreference: MySharedPreference
    private val TAG = "ActivityA"
    private val CAMERA_PERMISSION_CODE = 1001
    private val STORAGE_PERMISSION_CODE = 1002
    private lateinit var receiver: AirplaneModeChangeReceiver
    private lateinit var greetingPresenter: GreetingPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mySharedPreference = MySharedPreference(this)
        receiver = AirplaneModeChangeReceiver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver, it)
        }
        val greetingModel = GreetingModel()
        greetingPresenter=GreetingPresenter(greetingModel,this)
        greetingPresenter.loadGreeting()

        /*
                binding.apply {
                    circProgress.setProgress1(50f)
                    circProgress.setProgressColor1(Color.RED)
                }
        */
        /* val intent1 = Intent(this, com.example.client_example.service.MyService::class.java)
         startService(intent1)

         val intent2 = Intent(this, MyIntentService::class.java)
         startService(intent2)*/
        /*
                binding.apply {
                    camera.setOnClickListener {
                        if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(this@ActivityA, "Yes", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this@ActivityA, "No", Toast.LENGTH_SHORT).show()
                        }
                    }
                    gallery.setOnClickListener {
                        if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(this@ActivityA, "Yes", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this@ActivityA, "No", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
        */

        /*
                GlobalScope.launch(Dispatchers.IO) {
                    val timeMillis = measureTimeMillis {
                        var answer1: String? = null
                        var answer2: String? = null

                        var job1 = launch {
                            answer1 = networkCall1()
                        }
                        var job2 = launch {
                            answer2 = networkCall2()
                        }
                        job1.join()
                        job2.join()
                        Log.d(TAG, "onCreate: Answer1 is $answer1")
                        Log.d(TAG, "onCreate: Answer2 is $answer2")
                    }
                    Log.d(TAG, "onCreate: Requests took $timeMillis  ms")
                }
        */

        val nightModeFlags = resources?.configuration?.uiMode?.and(UI_MODE_NIGHT_MASK)
        when (nightModeFlags) {
            UI_MODE_NIGHT_YES -> {
                mySharedPreference.setDarkMode("mode", "night")
            }

            UI_MODE_NIGHT_NO -> {
                mySharedPreference.setDarkMode("mode", "day")
            }

            UI_MODE_NIGHT_UNDEFINED -> {

            }
        }

        /* val darkMode = mySharedPreference.getDarkMode("mode")
         if (darkMode != null) {
             if (darkMode.isNotEmpty()) {
                 val i = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
                 when (darkMode) {
                     "night" -> {
                         delegate.localNightMode = MODE_NIGHT_NO
                         mySharedPreference.setDarkMode("mode", "day")
                     }

                     "day" -> {
                         delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
                         mySharedPreference.setDarkMode("mode", "night")
                     }

                     else -> {
                         delegate.localNightMode = MODE_NIGHT_NO
                     }
                 }
             } else {
                 delegate.localNightMode = MODE_NIGHT_NO
                 mySharedPreference.setDarkMode("mode", "day")
             }
         } else {
             delegate.localNightMode = MODE_NIGHT_NO
             mySharedPreference.setDarkMode("mode", "day")
         }
 */
        val client = OkHttpClient()
//        binding.apply {
//            optionBtn.setOnClickListener {
//
//            }
//            socketBtn.setOnClickListener {
//                val apiKey = "c7aedc163a40af1050deb576d0cea21a"
//                var channelId = 1
//                var request: Request =
//                    Request.Builder().url("wss://socketsbay.com/wss/v2/1/$apiKey/").build()
//                val webSocketListener = WebSocketListener(this@ActivityA)
//                client.newWebSocket(request, webSocketListener)
//
//            }
//            socketGetBtn.setOnClickListener {
//                val message = mySharedPreference.getMessage()
//                Toast.makeText(this@ActivityA, message, Toast.LENGTH_SHORT).show()
//            }
//            btn.setOnClickListener {
//                val intent = Intent(this@ActivityA, ActivityB::class.java)
//                startActivity(intent)
//            }
//        }
    }

    override fun onStart() {
        super.onStart()
        if (checkSelfPermission(
                this, Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            if (checkSelfPermission(
                    this, Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
//                Toast.makeText(this, "Gallery is granted", Toast.LENGTH_SHORT).show()
            } else if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this, Manifest.permission.READ_EXTERNAL_STORAGE
                )
            ) {
                makePermissionRequest("gallery")
            } else {
                makePermissionRequest("gallery")
            }
//            Toast.makeText(this, "Camera is granted", Toast.LENGTH_SHORT).show()
        } else if (ActivityCompat.shouldShowRequestPermissionRationale(
                this, Manifest.permission.CAMERA
            )
        ) {
            makePermissionRequest("camera")
        } else {
            makePermissionRequest("camera")
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }

    fun makePermissionRequest(type: String) {
        when (type) {
            "camera" -> {
                requestPermissionLauncher.launch(Manifest.permission.CAMERA)
            }

            "gallery" -> {
                requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        }
    }

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        var type = "camera"
        if (isGranted) {

            if (checkSelfPermission(
                    this, Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
//                Toast.makeText(this, "Gallery is granted", Toast.LENGTH_SHORT).show()
            } else if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this, Manifest.permission.READ_EXTERNAL_STORAGE
                )
            ) {
                type = "gallery"
                makePermissionRequest("gallery")
            } else {
                type = "gallery"
                makePermissionRequest("gallery")
            }
        } else {
            showAlertDialog(type)
        }
    }

    fun showAlertDialog(type: String) {
        val alertDialog = android.app.AlertDialog.Builder(this)
        alertDialog.setTitle("Location permission")
        alertDialog.setMessage("You do not have permission for using location. Do you want to go to settings menu?")
        alertDialog.setPositiveButton(
            "Yes"
        ) { p0, p1 ->
            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
            val uri = Uri.fromParts("package", packageName, null)
            intent.data = uri
            startActivity(intent)
        }

        alertDialog.setNegativeButton(
            "No"
        ) { dialog, p1 ->
            makePermissionRequest(type)
        }
        alertDialog.show()
    }


    suspend fun doNetworkCall1(): String {
        delay(4000L)
        return "This is the answer1"
    }

    suspend fun doNetworkCall2(): String {
        delay(3000L)
        return "This is the answer2"
    }

    fun main() = runBlocking {
        try {
            withTimeout(3500) {
                delay(3000)
//                Toast.makeText(this@ActivityA, "Block completed successfully", Toast.LENGTH_SHORT)
//                    .show()
            }
        } catch (e: TimeoutCancellationException) {
            Toast.makeText(this@ActivityA, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    fun main2() = runBlocking {
        val result = withTimeoutOrNull(1000) {
            delay(1500)
            "Operation result"
        }
        Toast.makeText(this@ActivityA, result ?: "Time out exceeded", Toast.LENGTH_SHORT).show()
    }

    suspend fun networkCall1(): String {
        delay(3000)
        return "Answer1"
    }

    suspend fun networkCall2(): String {
        delay(3000)
        return "Answer2"
    }

    override fun displayGreeting(greeting: String) {
        Toast.makeText(this, greeting, Toast.LENGTH_SHORT).show()
    }
}
//code for
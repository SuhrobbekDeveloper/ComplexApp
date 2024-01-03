package com.example.client_example.package1

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.client_example.MySharedPreference
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener

class WebSocketListener(var context: Context) : WebSocketListener() {
    private val TAG = "WebSocketListener"

    override fun onOpen(webSocket: WebSocket, response: Response) {
        super.onOpen(webSocket, response)
        webSocket.send("Hello")
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        super.onMessage(webSocket, text)
        val mySharedPreference = MySharedPreference(context)
        mySharedPreference.setMessage(text)
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
        Log.d(TAG, "onMessage: $text")
    }

    override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
        Log.d(TAG, "onFailure: $t")
    }

    override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
        webSocket.close(1000, null)
        Log.d(TAG, "onClosing: $code / $reason")

    }
}
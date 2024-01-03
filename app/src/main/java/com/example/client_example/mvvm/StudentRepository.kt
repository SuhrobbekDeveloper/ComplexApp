package com.example.client_example.mvvm

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Retrofit

class StudentRepository {
    val responseData = MutableLiveData<ResponseBody>()
//    fun getStudentDetail(context: Context, rootObject: JSONObject): MutableLiveData<ResponseBody> {
//        val gson = Gson()
//        val retrofit = Retrofit.Builder().build()
//        val requestBody = RequestBody.create(
//            "application/json; charset=utf-8".toMediaTypeOrNull(),
//            rootObject.toString()
//        )
////        retrofit.create()
//
//    }
}
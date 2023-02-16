package com.example.teamfresh.network

import com.example.teamfresh.data.LoginRequest
import com.example.teamfresh.data.LoginResponse
import com.example.teamfresh.data.req
import com.example.teamfresh.data.res
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.squareup.moshi.Json
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface retrofit_network {
    @POST("signIn")
    @Headers(
        "Content-Type: application/json",
        "Transrer-Encoding: chunked",
        "Connection: keep-alive"
    )
    fun loginCheck(@Body req:req): Call<res>
}

object  loginService{


    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }


    private const val URL = " https://yhapidev.teamfresh.co.kr/v1/"


    private val retrofitLogin = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    val service = retrofitLogin.create(retrofit_network::class.java)

}
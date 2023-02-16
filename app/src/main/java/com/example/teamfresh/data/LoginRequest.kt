package com.example.teamfresh.data

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json


data class LoginRequest(

//    @Json(name="userLoginId")var userLoginId: String,
//
//    @Json(name="userLoginPassword")var userLoginPassword: String
    @SerializedName("userLoginId")var userLoginId: String,

    @SerializedName("userLoginPassword")var userLoginPassword: String
)

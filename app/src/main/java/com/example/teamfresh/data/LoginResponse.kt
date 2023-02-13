package com.example.teamfresh.data

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("code")
    var code: Int,
    @SerializedName("data")
    var data: String,
    @SerializedName("msg")
    var msg: String,
    @SerializedName("success")
    var success: Boolean
)

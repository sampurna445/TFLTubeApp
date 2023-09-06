package com.example.tfltubeapp.data.model


import com.google.gson.annotations.SerializedName

data class ValidityPeriod(
    @SerializedName("fromDate")
    val fromDate: String = "",
    @SerializedName("isNow")
    val isNow: Boolean = false,
    @SerializedName("toDate")
    val toDate: String = "",
    @SerializedName("type")
    val type: String = ""
)
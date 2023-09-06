package com.example.tfltubeapp.data.model


import com.google.gson.annotations.SerializedName

data class LineStatuse(
    @SerializedName("created")
    val created: String = "",
    @SerializedName("disruption")
    val disruption: Disruption? = null,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("lineId")
    val lineId: String? = null,
    @SerializedName("reason")
    val reason: String? = null,
    @SerializedName("statusSeverity")
    val statusSeverity: Int = 0,
    @SerializedName("statusSeverityDescription")
    val statusSeverityDescription: String = "",
    @SerializedName("type")
    val type: String = "",
    @SerializedName("validityPeriods")
    val validityPeriods: List<ValidityPeriod> = listOf()
)
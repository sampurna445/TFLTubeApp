package com.example.tfltubeapp.data.model


import com.google.gson.annotations.SerializedName

data class TFLTubeModelItem(
    @SerializedName("created")
    val created: String = "",
    @SerializedName("crowding")
    val crowding: Crowding = Crowding(),
    @SerializedName("disruptions")
    val disruptions: List<Any> = listOf(),
    @SerializedName("id")
    val id: String = "",
    @SerializedName("lineStatuses")
    val lineStatuses: List<LineStatuse> = listOf(),
    @SerializedName("modeName")
    val modeName: String = "",
    @SerializedName("modified")
    val modified: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("routeSections")
    val routeSections: List<Any> = listOf(),
    @SerializedName("serviceTypes")
    val serviceTypes: List<ServiceType> = listOf(),
    @SerializedName("type")
    val type: String = ""
)
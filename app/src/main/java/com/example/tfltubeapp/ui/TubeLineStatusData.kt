package com.example.tfltubeapp.ui

import com.example.tfltubeapp.data.model.LineStatuse

data class TubeLineStatusData(
    val name: String,
    val lineStatuses: List<LineStatuse> = listOf()
)
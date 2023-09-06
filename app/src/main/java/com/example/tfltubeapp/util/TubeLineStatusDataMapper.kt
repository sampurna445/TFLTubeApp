package com.example.tfltubeapp.util

import com.example.tfltubeapp.data.model.TFLTubeModelItem
import com.example.tfltubeapp.ui.TubeLineStatusData

interface TubeLineStatusDataMapper {
    fun mapTubeLineStatusData(tubeLineStatusResponse: TFLTubeModelItem): List<TubeLineStatusData>
}

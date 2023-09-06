package com.example.tfltubeapp.data.repository

import com.example.tfltubeapp.ui.TubeLineStatusData

interface TubeStatusRepository {

    suspend fun getTubeStatusesData(): List<TubeLineStatusData>


}
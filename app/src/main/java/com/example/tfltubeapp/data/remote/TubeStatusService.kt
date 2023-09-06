package com.example.tfltubeapp.data.remote

import com.example.tfltubeapp.ui.TubeLineStatusData

import retrofit2.http.GET

interface TubeStatusService {
    @GET(ApiDetails.TUBE_STATUS_ENDPOINT)
    suspend fun getTubeStatusesData():  List<TubeLineStatusData>
}
package com.example.tfltubeapp.data.repository

import com.example.tfltubeapp.data.remote.TubeStatusService
import com.example.tfltubeapp.ui.TubeLineStatusData
import com.example.tfltubeapp.util.TubeLineStatusDataMapper
import javax.inject.Inject

class TubeStatusRepositoryImpl@Inject constructor(
    private val tubeStatusService: TubeStatusService,
    private val  tubeStatusDataMapper: TubeLineStatusDataMapper
) : TubeStatusRepository{

    override suspend fun getTubeStatusesData(): List<TubeLineStatusData>  =
        tubeStatusService.getTubeStatusesData()


}


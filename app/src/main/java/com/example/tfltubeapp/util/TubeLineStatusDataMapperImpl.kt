package com.example.tfltubeapp.util

import com.example.tfltubeapp.data.model.TFLTubeModelItem
import com.example.tfltubeapp.ui.TubeLineStatusData

class TubeLineStatusDataMapperImpl:TubeLineStatusDataMapper {
    override fun mapTubeLineStatusData(tubeLineStatusResponse: TFLTubeModelItem): List<TubeLineStatusData> {
        val tubeLineStatusData = ArrayList<TubeLineStatusData>()

       /* for ((data, _) in tubeLineStatusResponse.lineStatuses) {
            if (data != null) {
                tubeLineStatusData.add(
                    TubeLineStatusData(
                        name = data.
                        title = data.title,
                        thumbnail = data.thumbnail,
                        preview = data.preview,
                        author = data.author,
                        ups = data.ups,
                        downs = data.downs,
                        link_flair_text = data.linkFlairText,
                        numComments = data.numComments,
                        created_utc = data.createdUtc,
                        name = data.name
                    )
                )
            }

        }*/
        return tubeLineStatusData
    }
}
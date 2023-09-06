package com.example.tfltubeapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun TubeLineStatusScreen(
    viewModel: TubeStatusViewModel
) {

    val tubeLineStatusList by viewModel.tubeLineStatusList.collectAsState(emptyList())

    LaunchedEffect(viewModel) {
        viewModel.loadTubeLineStatus()
    }

    LazyColumn {
        items(tubeLineStatusList) { tubeLineStatus ->
            TubeLineStatusItem(tubeLineStatus = tubeLineStatus)
        }
    }
}



@Composable
fun TubeLineStatusItem(tubeLineStatus: TubeLineStatusData) {
    val cardColor = Color(0xFFF4366C)
    var lineName = "Central"
    val lineColor = getTflLineColor(lineName)

    var serviceStatusColor:Color = if(tubeLineStatus.lineStatuses[0].statusSeverityDescription == "Good Service"){
        Color.Green
    }
    else
    {
        if(tubeLineStatus.lineStatuses[0].statusSeverityDescription == "Minor Delays"){
            Color.Black
        }
        else
            Color.Blue

    }
    Row (
        modifier = Modifier
            .fillMaxWidth() // Make the row occupy the full width
            .background(color = getTflLineColor(tubeLineStatus.name.lowercase()))
            .padding(16.dp)// Se
            ){
        Text(
            text = tubeLineStatus.name,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.weight(1f) // This makes the name take up the available space
        )
        Text(text = tubeLineStatus.lineStatuses[0].statusSeverityDescription,
            color = serviceStatusColor,
            fontWeight = FontWeight.Bold,)
    }
    Divider()
}
fun getTflLineColor(lineName: String): Color {
    return when (lineName.lowercase()) {
        "bakerloo" -> Color(137, 78, 36) // Brown
        "central" -> Color(220, 36, 31) // Red
        "circle" -> Color(255, 206, 0) // Yellow
        "district" -> Color(0, 125, 50) // Green
        "hammersmith & city" -> Color(215, 153, 175) // Pink
        "jubilee" -> Color(83, 86, 90) // Grey
        "metropolitan" -> Color(155, 0, 88) // Magenta
        "northern" -> Color(0, 0, 0) // Black
        "piccadilly" -> Color(0, 24, 168) // Dark Blue
        "victoria" -> Color(0, 160, 226) // Light Blue
        "waterloo & city" -> Color(106, 185, 218) // Light Blue
        else -> Color.Gray // Default to Gray for unknown lines
    }
}


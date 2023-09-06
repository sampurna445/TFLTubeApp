package com.example.tfltubeapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tfltubeapp.data.repository.TubeStatusRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TubeStatusViewModel @Inject constructor(
    private val tubeStatusRepository: TubeStatusRepository
) : ViewModel(){

    private val _tubeLineStatusList = MutableStateFlow(emptyList<TubeLineStatusData>())
    val tubeLineStatusList: StateFlow<List<TubeLineStatusData>> = _tubeLineStatusList

    fun loadTubeLineStatus() {
        viewModelScope.launch {
            val statusList = tubeStatusRepository.getTubeStatusesData()
            _tubeLineStatusList.value = statusList
        }
    }
}


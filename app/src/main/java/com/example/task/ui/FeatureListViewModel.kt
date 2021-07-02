package com.example.task.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task.api.Repository.FeatureListRepository
import com.example.task.api.entities.Features
import kotlinx.coroutines.launch

class FeatureListViewModel(
    private val featureListRepository: FeatureListRepository
): ViewModel() {

    private val featuresMutableLiveData = MutableLiveData<Features>()
    val features: LiveData<Features> = featuresMutableLiveData
    init {
        getAllFeatures()
    }
    private fun getAllFeatures() = viewModelScope.launch {
        featuresMutableLiveData.value = featureListRepository.getFeatureList()
    }
}
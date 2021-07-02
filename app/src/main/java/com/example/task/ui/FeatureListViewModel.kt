package com.example.task.ui

import androidx.lifecycle.ViewModel
import com.example.task.api.Repository.FeatureListRepository
import com.example.task.lazyDeferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.await
import retrofit2.awaitResponse

class FeatureListViewModel(
    private val featureListRepository: FeatureListRepository
): ViewModel() {

    val getFeatureList by lazyDeferred {
        featureListRepository.getFeatureList()
    }
}
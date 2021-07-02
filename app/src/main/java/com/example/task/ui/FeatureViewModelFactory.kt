package com.example.task.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.task.api.Repository.FeatureListRepository

class FeatureViewModelFactory(
    private val repository: FeatureListRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FeatureListViewModel(repository) as T
    }

}
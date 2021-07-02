package com.example.task.api.Repository

import com.example.task.api.ApiService
import com.example.task.api.entities.Features

class FeatureListRepository(private val apiService: ApiService){

    suspend fun getFeatureList(): Features {
        return apiService.getApiRequests().getAllFeatures()
    }
}
package com.example.task.api.Repository

import androidx.lifecycle.LiveData
import com.example.task.api.ApiService
import com.example.task.api.entities.Features
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call

private var TAG = "Repository"

class FeatureListRepository(
    private val apiService: ApiService
){
    suspend fun getFeatureList(): Call<Features> {
        return withContext(Dispatchers.IO){
            return@withContext apiService.getApiRequests().getAllFeatures()
        }
    }
}
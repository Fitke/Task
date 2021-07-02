package com.example.task.api

import com.example.task.api.entities.Features
import retrofit2.http.GET

interface ApiRequests {

    @GET(".json")
    suspend fun getAllFeatures(): Features
}
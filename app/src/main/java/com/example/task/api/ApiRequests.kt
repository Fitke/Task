package com.example.task.api

import androidx.lifecycle.LiveData
import com.example.task.api.entities.Features
import retrofit2.Call
import retrofit2.http.GET

interface ApiRequests {

    @GET(".json")
    fun getAllFeatures(): Call<Features>
}
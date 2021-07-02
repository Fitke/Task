package com.example.task.api

import com.example.task.ui.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getApiRequests(): ApiRequests {
        return retrofit
            .create(ApiRequests::class.java)
    }
}
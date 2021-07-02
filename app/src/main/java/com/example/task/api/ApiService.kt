package com.example.task.api

import com.example.task.api.Constants.BASE_URL
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiService {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
        .build()

    fun getApiRequests(): ApiRequests {
        return retrofit
            .create(ApiRequests::class.java)
    }
}
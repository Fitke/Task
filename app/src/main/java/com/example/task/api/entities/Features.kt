package com.example.task.api.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Features(
    @Json(name = "features")
    val features: List<Feature>
)
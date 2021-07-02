package com.example.task.api.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Feature(
    @Json(name = "id")
    val id: Int,
    @Json(name = "points")
    val points: List<Point>
)
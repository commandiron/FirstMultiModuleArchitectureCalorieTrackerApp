package com.commandiron.tracker_data.remote.dto

import com.squareup.moshi.Json

data class Nutriments(
    @field:Json(name = "carbohydrates100g")
    val carbohydrates100g: Double,
    @field:Json(name = "energy-kcal100g")
    val energyKcal100g:Double,
    @field:Json(name = "fat_100g")
    val fat100g: Double,
    @field:Json(name = "proteins_100g")
    val proteins100g: Double

)
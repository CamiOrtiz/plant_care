package com.example.plant_care.data.repository.remote.dto

import retrofit2.http.GET
import retrofit2.http.Query

interface PlantApiService {

    @GET("v2/species-list")
    suspend fun getPlants(
        @Query("key") apiKey: String
    ): List<PlantDto>

}
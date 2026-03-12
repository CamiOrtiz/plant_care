package com.example.plant_care.data.repository

import com.example.plant_care.data.repository.remote.dto.PlantApiService
import com.example.plant_care.domain.model.Plant
import com.example.plant_care.domain.model.repository.PlantRepository

class PlantRepositoryImpl(
    private val api: PlantApiService
) : PlantRepository {

    override suspend fun getPlants(): List<Plant> {
        val plantsDto = api.getPlants("TU_API_KEY")

        return plantsDto.map {
            Plant(
                id = it.id,
                name = it.common_name,
                scientificName = it.scientific_name,
                imageUrl = ""
            )
        }
    }
}





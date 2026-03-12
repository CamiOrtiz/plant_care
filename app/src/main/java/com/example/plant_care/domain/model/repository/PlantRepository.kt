package com.example.plant_care.domain.model.repository

import com.example.plant_care.domain.model.Plant

interface PlantRepository {
    suspend fun getPlants(): List<Plant>
}
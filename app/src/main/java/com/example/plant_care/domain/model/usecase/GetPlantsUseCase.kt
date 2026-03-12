package com.example.plant_care.domain.model.usecase

import com.example.plant_care.domain.model.Plant
import com.example.plant_care.domain.model.repository.PlantRepository

class GetPlantsUseCase(
    private val repository: PlantRepository
) {

    suspend operator fun invoke(): List<Plant> {
        return repository.getPlants()
    }

}
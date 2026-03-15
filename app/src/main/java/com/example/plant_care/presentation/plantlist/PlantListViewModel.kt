package com.example.plant_care.presentation.plantlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.plant_care.domain.model.Plant
import com.example.plant_care.domain.model.usecase.GetPlantsUseCase
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PlantListViewModel(
    private val getPlantsUseCase: GetPlantsUseCase
) : ViewModel() {

    private val _plants = MutableStateFlow<List<Plant>>(emptyList())
    val plants: StateFlow<List<Plant>> = _plants

    init {
        loadPlants()
    }

    private fun loadPlants() {
        viewModelScope.launch {
            _plants.value = getPlantsUseCase()
        }
    }
}

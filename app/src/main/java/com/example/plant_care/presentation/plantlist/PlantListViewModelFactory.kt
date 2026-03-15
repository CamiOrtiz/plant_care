package com.example.plant_care.presentation.plantlist

import com.example.plant_care.domain.model.usecase.GetPlantsUseCase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class PlantListViewModelFactory(
    private val getPlantsUseCase: GetPlantsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PlantListViewModel(getPlantsUseCase) as T
    }
}

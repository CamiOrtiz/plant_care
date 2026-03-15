package com.example.plant_care.presentation.plantlist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.plant_care.data.repository.PlantRepositoryImpl
import com.example.plant_care.data.repository.remote.dto.RetrofitInstance.api
import com.example.plant_care.domain.model.usecase.GetPlantsUseCase

@Composable
fun PlantListScreen() {

    val repository = PlantRepositoryImpl(api)
    val useCase = GetPlantsUseCase(repository)

    val viewModel: PlantListViewModel = viewModel(
        factory = PlantListViewModelFactory(useCase)
    )
    val plants by viewModel.plants.collectAsState()
    LazyColumn {
        items(plants) { plant ->
            Text("🌿 ${plant.name}")
        }
    }


}


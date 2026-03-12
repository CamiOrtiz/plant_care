package com.example.plant_care.domain.model

data class Plant(
    val id: Int,
    val name: String,
    val scientificName: String,
    val imageUrl: String
)
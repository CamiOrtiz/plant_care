package com.example.plant_care.domain.model

data class Pokemon(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<String>,
    val spriteUrl: String
)
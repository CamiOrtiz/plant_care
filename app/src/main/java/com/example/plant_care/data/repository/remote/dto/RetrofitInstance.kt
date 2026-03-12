package com.example.plant_care.data.repository.remote.dto

object RetrofitInstance {

    val api: PlantApiService by lazy {
        retrofit.create(PlantApiService::class.java)
    }

    private val retrofit = retrofit2.Retrofit.Builder()
        .baseUrl("https://perenual.com/api/")
        .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
        .build()
}


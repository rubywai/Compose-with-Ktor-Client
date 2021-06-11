package com.example.countrylistapi.data

import com.example.countrylistapi.data.api.ApiService
import com.example.countrylistapi.data.model.Country
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val apiService: ApiService) {
    suspend fun  getCountry() : List<Country> = apiService.getCountry();
}
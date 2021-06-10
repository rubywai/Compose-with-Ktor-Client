package com.example.countrylistapi.data

import com.example.countrylistapi.data.api.ApiService
import com.example.countrylistapi.data.model.Country

class Repository {
    private val apiService = ApiService()
    suspend fun  getCountry() : List<Country> = apiService.getCountry();
}
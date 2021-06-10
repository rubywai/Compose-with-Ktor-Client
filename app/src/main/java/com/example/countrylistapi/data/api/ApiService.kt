package com.example.countrylistapi.data.api

import com.example.countrylistapi.Const
import com.example.countrylistapi.data.model.Country
import io.ktor.client.request.*

class ApiService {
    private val client = ApiClient.ktorClient
    suspend fun getCountry() : List<Country> = client.get("${Const.BASE_URL}/${Const.ALL}")
}
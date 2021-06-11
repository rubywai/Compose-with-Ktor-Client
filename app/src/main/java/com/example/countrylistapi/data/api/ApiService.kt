package com.example.countrylistapi.data.api

import com.example.countrylistapi.Const
import com.example.countrylistapi.data.model.Country
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.request.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiService @Inject constructor(private val client: ApiClient) {
    suspend fun getCountry() : List<Country> = client.ktorClient.get("${Const.BASE_URL}/${Const.ALL}")
}
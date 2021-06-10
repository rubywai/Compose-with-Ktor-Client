package com.example.countrylistapi.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countrylistapi.data.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CountryViewModel : ViewModel() {
    private val repository = Repository()
    val countryState : MutableStateFlow<CountryState> = MutableStateFlow(CountryState.CountryLoading)
    init {
        viewModelScope.launch {
            kotlin.runCatching {
                repository.getCountry()
            }.
            onSuccess{
                countryState.emit(CountryState.CountrySuccess(it))
            }.
            onFailure {
                countryState.emit(CountryState.CountryFail("error ${it.localizedMessage}"))
            }
        }
    }

}
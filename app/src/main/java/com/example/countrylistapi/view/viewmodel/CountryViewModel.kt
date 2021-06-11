package com.example.countrylistapi.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countrylistapi.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(repository: Repository) : ViewModel() {
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
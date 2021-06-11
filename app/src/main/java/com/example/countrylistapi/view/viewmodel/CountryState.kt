package com.example.countrylistapi.view.viewmodel

import com.example.countrylistapi.data.model.Country

sealed class CountryState{
    object CountryLoading : CountryState()
    data class CountrySuccess(val countryList : List<Country>) : CountryState()
    data class CountryFail(val error : String) : CountryState()
}

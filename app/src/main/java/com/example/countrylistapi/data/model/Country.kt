package com.example.countrylistapi.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Country(
    val name : String?,
    val region : String?,
    val population : Int?,
    val alpha2Code : String?
) : Parcelable

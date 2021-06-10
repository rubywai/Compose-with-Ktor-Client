package com.example.countrylistapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.countrylistapi.ui.theme.CountryListApiTheme
import com.example.countrylistapi.view.CountryNavigation
import com.example.countrylistapi.view.CountryState
import com.example.countrylistapi.view.CountryViewModel

class MainActivity : ComponentActivity() {
    val countryViewModel : CountryViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountryNavigation(context = applicationContext, countryViewModel)
            }
        }
    }





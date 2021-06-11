package com.example.countrylistapi.view.viewmodel

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.countrylistapi.view.pages.DetailScreen
import com.example.countrylistapi.view.pages.ListScreen

@Composable
fun CountryNavigation(context : Context, viewModel: CountryViewModel = androidx.lifecycle.viewmodel.compose.viewModel()){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "list_screen"
    ){
        composable("list_screen"){
            ListScreen(controller = navController,countryViewModel = viewModel, context)
        }
        composable("detail_screen"
        ){
            DetailScreen(controller = navController)
        }
    }

}
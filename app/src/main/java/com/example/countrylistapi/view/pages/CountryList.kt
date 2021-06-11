package com.example.countrylistapi.view.pages

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.countrylistapi.data.model.Country
import com.example.countrylistapi.view.viewmodel.CountryState
import com.example.countrylistapi.view.viewmodel.CountryViewModel
import com.example.countrylistapi.view.widget.FlagImage
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun ListScreen(controller : NavController, countryViewModel: CountryViewModel = viewModel(), applicationContext : Context){
    Log.d("testing","list screen")
    Scaffold(
        topBar = {
            TopAppBar(content = {
                Text("JetPack Compose Country",
                    modifier = Modifier.fillMaxWidth(),textAlign = TextAlign.Center)
            })
        },
        content = { CountryList(countryViewModel, controller) }
    )

}
@Composable
fun CountryList(countryViewModel: CountryViewModel = viewModel(), controller: NavController){
    Log.d("testing","observe")
    val state  = countryViewModel.countryState.collectAsState().value
    when(state){

        is CountryState.CountryLoading -> {
            Box(modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.Center){
                CircularProgressIndicator()
            }
        }
        is CountryState.CountrySuccess -> {
            LazyColumn() {
                itemsIndexed(state.countryList){
                        _, item ->
                    Item(item, controller)
                }
            }
        }
        is CountryState.CountryFail -> Text(state.error)
    }


}

@Composable()
fun Item(countryDto: Country, controller: NavController){
    Log.d("testing","itemizing")
    val painter = rememberCoilPainter("https://www.countryflags.io/${countryDto.alpha2Code}/shiny/64.png")
    Card(
        modifier = Modifier.padding(4.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(10.dp)


    ) {
        Box( modifier = Modifier.clickable {
            Log.d("testing","$countryDto",)
            controller.currentBackStackEntry?.arguments =
                Bundle().apply {
                    putParcelable("country", countryDto)
                }
            controller.navigate("detail_screen")


        }){
            Row(
                verticalAlignment = Alignment.CenterVertically,

                ){
                FlagImage(painter)
                Spacer(modifier = Modifier.width(10.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                ) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Name - ${countryDto.name}")
                    Text("Region - ${countryDto.region}")
                    Text("Population - ${countryDto.population}")
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }


}

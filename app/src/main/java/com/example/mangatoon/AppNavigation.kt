package com.example.mangatoon

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kotlinx.coroutines.launch

@Composable
fun AppNavigation(viewModel : WebtoonViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash_screen"){
        composable("splash_screen"){
            SplashScreen(navController = navController)
        }
        composable("home"){
        WebtoonListScreen(webtoons = getWebtoons(),
            onWebtoonClick = {  webtoon ->
                navController.navigate("detailScreen/${webtoon.id}")},
            onBackClick = {
                navController.navigate("favorites") // Navigate to favorites
            }
            )
        }

        composable("detailScreen/{webtoonId}",
            arguments = listOf(navArgument("webtoonId"){type = NavType.StringType})
            ){
             backStackEntry ->
            val webtoonId = backStackEntry.arguments?.getString("webtoonId")
            val webtoon = getWebtoons().find{it.id.toString() == webtoonId}
            if(webtoon != null){
                DetailScreen(webtoon = webtoon,
                    onAddFavorite = {webtoonEntity ->
                        viewModel.viewModelScope.launch{ viewModel.addFavorite(webtoonEntity)}

                    },
                    viewModel = viewModel,
                    onBackClick = {navController.popBackStack()})
            }
        }

        composable("favorites"){
            val favorites by viewModel.favorites.collectAsState()
          FavoriteScreen(viewModel = viewModel ,
             
              onBackClick = {navController.popBackStack() } )

        }

    }
}


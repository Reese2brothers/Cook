package com.hulikan.cook

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraphNavigate(context : Context, navController: NavHostController) {

    NavHost(navController = navController, startDestination = "SplashScreen") {
        composable("SplashScreen") {
            SplashScreen(navController = navController)
        }
        composable("MainScreen") {
            MainScreen(navController = navController)
        }
        composable("ResourceScreen") {
            ResourceScreen(navController = navController)
        }
    }
}
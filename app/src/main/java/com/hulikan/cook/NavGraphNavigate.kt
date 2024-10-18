package com.hulikan.cook

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.hulikan.cook.screens.FiveScreen
import com.hulikan.cook.screens.FourScreen
import com.hulikan.cook.screens.OneScreen
import com.hulikan.cook.screens.ThreeScreen
import com.hulikan.cook.screens.TwoScreen

@Composable
fun NavGraphNavigate(context : Context, navController: NavHostController) {

    NavHost(navController = navController, startDestination = "SplashScreen") {
        composable("SplashScreen") {
            SplashScreen(navController = navController)
        }
        composable("MainScreen") {
            MainScreen(context, navController = navController)
        }
        composable("ResourceScreen") {
            ResourceScreen(context, navController = navController)
        }
        composable("OneScreen") {
            OneScreen(context)
        }
        composable("TwoScreen") {
            TwoScreen()
        }
        composable("ThreeScreen") {
            ThreeScreen()
        }
        composable("FourScreen") {
            FourScreen()
        }
        composable("FiveScreen") {
            FiveScreen()
        }
//        composable("MainScreen/{wordKey}",
//            arguments = listOf(navArgument("wordKey") { type = NavType.StringType })
//        ) { backStackEntry ->
//            val wordKey = backStackEntry.arguments?.getString("wordKey") ?: ""
//            MainScreen(context, navController, wordKey)
//        }
//        composable("ResourceScreen/{wordKey}",
//            arguments = listOf(navArgument("wordKey") { type = NavType.StringType })
//        ) { backStackEntry ->
//            val wordKey = backStackEntry.arguments?.getString("wordKey") ?: ""
//            ResourceScreen(context, navController, wordKey)
//        }
    }
}
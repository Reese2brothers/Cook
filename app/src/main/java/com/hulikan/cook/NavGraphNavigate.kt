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
import com.hulikan.cook.screens.recepies.AddOneLinksScreen
import com.hulikan.cook.screens.recepies.NewOneRecepiesScreen
import com.hulikan.cook.screens.recepies.OneRecepiesScreen

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
        composable("NewOneRecepiesScreen") {
            NewOneRecepiesScreen(context, navController = navController)
        }
        composable("AddOneLinksScreen") {
            AddOneLinksScreen(context, navController = navController)
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
        composable("OneScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            OneScreen(context, navController, title, content, image)
        }
        composable("OneRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            OneRecepiesScreen(context, navController, title, content, image)
        }
    }
}
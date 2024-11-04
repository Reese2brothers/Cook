package com.hulikan.cook

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.hulikan.cook.screens.eight.AddEightLinksScreen
import com.hulikan.cook.screens.eight.EightEditRecepiesScreen
import com.hulikan.cook.screens.eight.EightRecepiesScreen
import com.hulikan.cook.screens.eight.EightScreen
import com.hulikan.cook.screens.eight.NewEightRecepiesScreen
import com.hulikan.cook.screens.eighteen.AddEighteenLinksScreen
import com.hulikan.cook.screens.eighteen.EighteenEditRecepiesScreen
import com.hulikan.cook.screens.eighteen.EighteenRecepiesScreen
import com.hulikan.cook.screens.eighteen.EighteenScreen
import com.hulikan.cook.screens.eighteen.NewEighteenRecepiesScreen
import com.hulikan.cook.screens.eleven.AddElevenLinksScreen
import com.hulikan.cook.screens.eleven.ElevenEditRecepiesScreen
import com.hulikan.cook.screens.eleven.ElevenRecepiesScreen
import com.hulikan.cook.screens.eleven.ElevenScreen
import com.hulikan.cook.screens.eleven.NewElevenRecepiesScreen
import com.hulikan.cook.screens.fifteen.AddFifteenLinksScreen
import com.hulikan.cook.screens.fifteen.FifteenEditRecepiesScreen
import com.hulikan.cook.screens.fifteen.FifteenRecepiesScreen
import com.hulikan.cook.screens.fifteen.FifteenScreen
import com.hulikan.cook.screens.fifteen.NewFifteenRecepiesScreen
import com.hulikan.cook.screens.five.AddFiveLinksScreen
import com.hulikan.cook.screens.five.FiveEditRecepiesScreen
import com.hulikan.cook.screens.five.FiveRecepiesScreen
import com.hulikan.cook.screens.five.FiveScreen
import com.hulikan.cook.screens.five.NewFiveRecepiesScreen
import com.hulikan.cook.screens.four.AddFourLinksScreen
import com.hulikan.cook.screens.four.FourEditRecepiesScreen
import com.hulikan.cook.screens.four.FourRecepiesScreen
import com.hulikan.cook.screens.four.FourScreen
import com.hulikan.cook.screens.four.NewFourRecepiesScreen
import com.hulikan.cook.screens.fourteen.AddFourteenLinksScreen
import com.hulikan.cook.screens.fourteen.FourteenEditRecepiesScreen
import com.hulikan.cook.screens.fourteen.FourteenRecepiesScreen
import com.hulikan.cook.screens.fourteen.FourteenScreen
import com.hulikan.cook.screens.fourteen.NewFourteenRecepiesScreen
import com.hulikan.cook.screens.nine.AddNineLinksScreen
import com.hulikan.cook.screens.nine.NewNineRecepiesScreen
import com.hulikan.cook.screens.nine.NineEditRecepiesScreen
import com.hulikan.cook.screens.nine.NineRecepiesScreen
import com.hulikan.cook.screens.nine.NineScreen
import com.hulikan.cook.screens.nineteen.AddNineteenLinksScreen
import com.hulikan.cook.screens.nineteen.NewNineteenRecepiesScreen
import com.hulikan.cook.screens.nineteen.NineteenEditRecepiesScreen
import com.hulikan.cook.screens.nineteen.NineteenRecepiesScreen
import com.hulikan.cook.screens.nineteen.NineteenScreen
import com.hulikan.cook.screens.one.OneScreen
import com.hulikan.cook.screens.three.ThreeScreen
import com.hulikan.cook.screens.two.TwoScreen
import com.hulikan.cook.screens.one.OneEditRecepiesScreen
import com.hulikan.cook.screens.one.AddOneLinksScreen
import com.hulikan.cook.screens.one.NewOneRecepiesScreen
import com.hulikan.cook.screens.one.OneRecepiesScreen
import com.hulikan.cook.screens.seven.AddSevenLinksScreen
import com.hulikan.cook.screens.seven.NewSevenRecepiesScreen
import com.hulikan.cook.screens.seven.SevenEditRecepiesScreen
import com.hulikan.cook.screens.seven.SevenRecepiesScreen
import com.hulikan.cook.screens.seven.SevenScreen
import com.hulikan.cook.screens.seventeen.AddSeventeenLinksScreen
import com.hulikan.cook.screens.seventeen.NewSeventeenRecepiesScreen
import com.hulikan.cook.screens.seventeen.SeventeenEditRecepiesScreen
import com.hulikan.cook.screens.seventeen.SeventeenRecepiesScreen
import com.hulikan.cook.screens.seventeen.SeventeenScreen
import com.hulikan.cook.screens.six.AddSixLinksScreen
import com.hulikan.cook.screens.six.NewSixRecepiesScreen
import com.hulikan.cook.screens.six.SixEditRecepiesScreen
import com.hulikan.cook.screens.six.SixRecepiesScreen
import com.hulikan.cook.screens.six.SixScreen
import com.hulikan.cook.screens.sixteen.AddSixteenLinksScreen
import com.hulikan.cook.screens.sixteen.NewSixteenRecepiesScreen
import com.hulikan.cook.screens.sixteen.SixteenEditRecepiesScreen
import com.hulikan.cook.screens.sixteen.SixteenRecepiesScreen
import com.hulikan.cook.screens.sixteen.SixteenScreen
import com.hulikan.cook.screens.ten.AddTenLinksScreen
import com.hulikan.cook.screens.ten.NewTenRecepiesScreen
import com.hulikan.cook.screens.ten.TenEditRecepiesScreen
import com.hulikan.cook.screens.ten.TenRecepiesScreen
import com.hulikan.cook.screens.ten.TenScreen
import com.hulikan.cook.screens.thirteen.AddThirteenLinksScreen
import com.hulikan.cook.screens.thirteen.NewThirteenRecepiesScreen
import com.hulikan.cook.screens.thirteen.ThirteenEditRecepiesScreen
import com.hulikan.cook.screens.thirteen.ThirteenRecepiesScreen
import com.hulikan.cook.screens.thirteen.ThirteenScreen
import com.hulikan.cook.screens.three.AddThreeLinksScreen
import com.hulikan.cook.screens.three.NewThreeRecepiesScreen
import com.hulikan.cook.screens.three.ThreeEditRecepiesScreen
import com.hulikan.cook.screens.three.ThreeRecepiesScreen
import com.hulikan.cook.screens.twelve.AddTwelveLinksScreen
import com.hulikan.cook.screens.twelve.NewTwelveRecepiesScreen
import com.hulikan.cook.screens.twelve.TwelveEditRecepiesScreen
import com.hulikan.cook.screens.twelve.TwelveRecepiesScreen
import com.hulikan.cook.screens.twelve.TwelveScreen
import com.hulikan.cook.screens.twenty.AddTwentyLinksScreen
import com.hulikan.cook.screens.twenty.NewTwentyRecepiesScreen
import com.hulikan.cook.screens.twenty.TwentyEditRecepiesScreen
import com.hulikan.cook.screens.twenty.TwentyRecepiesScreen
import com.hulikan.cook.screens.twenty.TwentyScreen
import com.hulikan.cook.screens.two.AddTwoLinksScreen
import com.hulikan.cook.screens.two.NewTwoRecepiesScreen
import com.hulikan.cook.screens.two.TwoEditRecepiesScreen
import com.hulikan.cook.screens.two.TwoRecepiesScreen
import com.hulikan.cook.viewmodels.SharedViewModel

@Composable
fun NavGraphNavigate(context : Context, navController: NavHostController, sharedViewModel: SharedViewModel) {

    NavHost(navController = navController, startDestination = "SplashScreen") {
        composable("SplashScreen") {
            SplashScreen(navController = navController)
        }
        composable("FavouriteScreen") {
            FavouriteScreen(context, navController = navController)
        }
        composable("ResourceScreen/{title}/{image}/{wordkey}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType },
                navArgument("wordkey") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            val wordkey = backStackEntry.arguments?.getString("wordkey") ?: ""
            ResourceScreen(context, navController, title, image, wordkey)
        }
        composable("MainScreen/{title}/{image}/{wordkey}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType },
                navArgument("wordkey") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            val wordkey = backStackEntry.arguments?.getString("wordkey") ?: ""
            MainScreen(context, navController, title, image, wordkey)
        }



        composable("NewOneRecepiesScreen") {
            NewOneRecepiesScreen(context, navController = navController)
        }
        composable("NewTwoRecepiesScreen") {
            NewTwoRecepiesScreen(context, navController = navController)
        }
        composable("NewThreeRecepiesScreen") {
            NewThreeRecepiesScreen(context, navController = navController)
        }
        composable("NewFourRecepiesScreen") {
            NewFourRecepiesScreen(context, navController = navController)
        }
        composable("NewFiveRecepiesScreen") {
            NewFiveRecepiesScreen(context, navController = navController)
        }
        composable("NewSixRecepiesScreen") {
            NewSixRecepiesScreen(context, navController = navController)
        }
        composable("NewSevenRecepiesScreen") {
            NewSevenRecepiesScreen(context, navController = navController)
        }
        composable("NewEightRecepiesScreen") {
            NewEightRecepiesScreen(context, navController = navController)
        }
        composable("NewNineRecepiesScreen") {
            NewNineRecepiesScreen(context, navController = navController)
        }
        composable("NewTenRecepiesScreen") {
            NewTenRecepiesScreen(context, navController = navController)
        }
        composable("NewElevenRecepiesScreen") {
            NewElevenRecepiesScreen(context, navController = navController)
        }
        composable("NewTwelveRecepiesScreen") {
            NewTwelveRecepiesScreen(context, navController = navController)
        }
        composable("NewThirteenRecepiesScreen") {
            NewThirteenRecepiesScreen(context, navController = navController)
        }
        composable("NewFourteenRecepiesScreen") {
            NewFourteenRecepiesScreen(context, navController = navController)
        }
        composable("NewFifteenRecepiesScreen") {
            NewFifteenRecepiesScreen(context, navController = navController)
        }
        composable("NewSixteenRecepiesScreen") {
            NewSixteenRecepiesScreen(context, navController = navController)
        }
        composable("NewSeventeenRecepiesScreen") {
            NewSeventeenRecepiesScreen(context, navController = navController)
        }
        composable("NewEighteenRecepiesScreen") {
            NewEighteenRecepiesScreen(context, navController = navController)
        }
        composable("NewNineteenRecepiesScreen") {
            NewNineteenRecepiesScreen(context, navController = navController)
        }
        composable("NewTwentyRecepiesScreen") {
            NewTwentyRecepiesScreen(context, navController = navController)
        }



        composable("AddOneLinksScreen") {
            AddOneLinksScreen(context, navController = navController)
        }
        composable("AddTwoLinksScreen") {
            AddTwoLinksScreen(context, navController = navController)
        }
        composable("AddThreeLinksScreen") {
            AddThreeLinksScreen(context, navController = navController)
        }
        composable("AddFourLinksScreen") {
            AddFourLinksScreen(context, navController = navController)
        }
        composable("AddFiveLinksScreen") {
            AddFiveLinksScreen(context, navController = navController)
        }
        composable("AddSixLinksScreen") {
            AddSixLinksScreen(context, navController = navController)
        }
        composable("AddSevenLinksScreen") {
            AddSevenLinksScreen(context, navController = navController)
        }
        composable("AddEightLinksScreen") {
            AddEightLinksScreen(context, navController = navController)
        }
        composable("AddNineLinksScreen") {
            AddNineLinksScreen(context, navController = navController)
        }
        composable("AddTenLinksScreen") {
            AddTenLinksScreen(context, navController = navController)
        }
        composable("AddElevenLinksScreen") {
            AddElevenLinksScreen(context, navController = navController)
        }
        composable("AddTwelveLinksScreen") {
            AddTwelveLinksScreen(context, navController = navController)
        }
        composable("AddThirteenLinksScreen") {
            AddThirteenLinksScreen(context, navController = navController)
        }
        composable("AddFourteenLinksScreen") {
            AddFourteenLinksScreen(context, navController = navController)
        }
        composable("AddFifteenLinksScreen") {
            AddFifteenLinksScreen(context, navController = navController)
        }
        composable("AddSixteenLinksScreen") {
            AddSixteenLinksScreen(context, navController = navController)
        }
        composable("AddSeventeenLinksScreen") {
            AddSeventeenLinksScreen(context, navController = navController)
        }
        composable("AddEighteenLinksScreen") {
            AddEighteenLinksScreen(context, navController = navController)
        }
        composable("AddNineteenLinksScreen") {
            AddNineteenLinksScreen(context, navController = navController)
        }
        composable("AddTwentyLinksScreen") {
            AddTwentyLinksScreen(context, navController = navController)
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
        composable("TwoScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwoScreen(context, navController, title, content, image)
        }
        composable("ThreeScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThreeScreen(context, navController, title, content, image)
        }
        composable("FourScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FourScreen(context, navController, title, content, image)
        }
        composable("FiveScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FiveScreen(context, navController, title, content, image)
        }
        composable("SixScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            SixScreen(context, navController, title, content, image)
        }
        composable("SevenScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            SevenScreen(context, navController, title, content, image)
        }
        composable("EightScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            EightScreen(context, navController, title, content, image)
        }
        composable("NineScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            NineScreen(context, navController, title, content, image)
        }
        composable("TenScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TenScreen(context, navController, title, content, image)
        }
        composable("ElevenScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ElevenScreen(context, navController, title, content, image)
        }
        composable("TwelveScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwelveScreen(context, navController, title, content, image)
        }
        composable("ThirteenScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirteenScreen(context, navController, title, content, image)
        }
        composable("FourteenScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FourteenScreen(context, navController, title, content, image)
        }
        composable("FifteenScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FifteenScreen(context, navController, title, content, image)
        }
        composable("SixteenScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            SixteenScreen(context, navController, title, content, image)
        }
        composable("SeventeenScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            SeventeenScreen(context, navController, title, content, image)
        }
        composable("EighteenScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            EighteenScreen(context, navController, title, content, image)
        }
        composable("NineteenScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            NineteenScreen(context, navController, title, content, image)
        }
        composable("TwentyScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentyScreen(context, navController, title, content, image)
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
            OneRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("TwoRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwoRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("ThreeRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThreeRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("FourRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FourRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("FiveRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FiveRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("SixRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            SixRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("SevenRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            SevenRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("EightRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            EightRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("NineRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            NineRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("TenRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TenRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("ElevenRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ElevenRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("TwelveRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwelveRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("ThirteenRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirteenRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("FourteenRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FourteenRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("FifteenRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FifteenRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("SixteenRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            SixteenRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("SeventeenRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            SeventeenRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("EighteenRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            EighteenRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("NineteenRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            NineteenRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("TwentyRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentyRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }








        composable("OneEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            OneEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("TwoEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwoEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("ThreeEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThreeEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("FourEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FourEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("FiveEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FiveEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("SixEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            SixEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("SevenEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            SevenEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("EightEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            EightEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("NineEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            NineEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("TenEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TenEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("ElevenEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ElevenEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("TwelveEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwelveEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("ThirteenEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirteenEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("FourteenEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FourteenEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("FifteenEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FifteenEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("SixteenEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            SixteenEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("SeventeenEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            SeventeenEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("EighteenEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            EighteenEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("NineteenEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            NineteenEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("TwentyEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentyEditRecepiesScreen(context, navController, title, content, image)
        }
    }
}
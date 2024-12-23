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
import com.hulikan.cook.screens.fifty.AddFiftyLinksScreen
import com.hulikan.cook.screens.fifty.FiftyEditRecepiesScreen
import com.hulikan.cook.screens.fifty.FiftyRecepiesScreen
import com.hulikan.cook.screens.fifty.FiftyScreen
import com.hulikan.cook.screens.fifty.NewFiftyRecepiesScreen
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
import com.hulikan.cook.screens.fourty.AddFortyLinksScreen
import com.hulikan.cook.screens.fourty.FortyEditRecepiesScreen
import com.hulikan.cook.screens.fourty.FortyRecepiesScreen
import com.hulikan.cook.screens.fourty.FourtyScreen
import com.hulikan.cook.screens.fourty.NewFortyRecepiesScreen
import com.hulikan.cook.screens.fourtyeight.AddFortyEightLinksScreen
import com.hulikan.cook.screens.fourtyeight.FortyEightEditRecepiesScreen
import com.hulikan.cook.screens.fourtyeight.FortyEightRecepiesScreen
import com.hulikan.cook.screens.fourtyeight.FortyEightScreen
import com.hulikan.cook.screens.fourtyeight.NewFortyEightRecepiesScreen
import com.hulikan.cook.screens.fourtyfive.AddFortyFiveLinksScreen
import com.hulikan.cook.screens.fourtyfive.FortyFiveEditRecepiesScreen
import com.hulikan.cook.screens.fourtyfive.FortyFiveRecepiesScreen
import com.hulikan.cook.screens.fourtyfive.FortyFiveScreen
import com.hulikan.cook.screens.fourtyfive.NewFortyFiveRecepiesScreen
import com.hulikan.cook.screens.fourtyfour.AddFortyFourLinksScreen
import com.hulikan.cook.screens.fourtyfour.FortyFourEditRecepiesScreen
import com.hulikan.cook.screens.fourtyfour.FortyFourRecepiesScreen
import com.hulikan.cook.screens.fourtyfour.FortyFourScreen
import com.hulikan.cook.screens.fourtyfour.NewFortyFourRecepiesScreen
import com.hulikan.cook.screens.fourtynine.AddFortyNineLinksScreen
import com.hulikan.cook.screens.fourtynine.FortyNineEditRecepiesScreen
import com.hulikan.cook.screens.fourtynine.FortyNineRecepiesScreen
import com.hulikan.cook.screens.fourtynine.FortyNineScreen
import com.hulikan.cook.screens.fourtynine.NewFortyNineRecepiesScreen
import com.hulikan.cook.screens.fourtyone.AddFortyOneLinksScreen
import com.hulikan.cook.screens.fourtyone.FortyOneEditRecepiesScreen
import com.hulikan.cook.screens.fourtyone.FortyOneRecepiesScreen
import com.hulikan.cook.screens.fourtyone.FortyOneScreen
import com.hulikan.cook.screens.fourtyone.NewFortyOneRecepiesScreen
import com.hulikan.cook.screens.fourtyseven.AddFortySevenLinksScreen
import com.hulikan.cook.screens.fourtyseven.FortySevenEditRecepiesScreen
import com.hulikan.cook.screens.fourtyseven.FortySevenRecepiesScreen
import com.hulikan.cook.screens.fourtyseven.FortySevenScreen
import com.hulikan.cook.screens.fourtyseven.NewFortySevenRecepiesScreen
import com.hulikan.cook.screens.fourtysix.AddFortySixLinksScreen
import com.hulikan.cook.screens.fourtysix.FortySixEditRecepiesScreen
import com.hulikan.cook.screens.fourtysix.FortySixRecepiesScreen
import com.hulikan.cook.screens.fourtysix.FortySixScreen
import com.hulikan.cook.screens.fourtysix.NewFortySixRecepiesScreen
import com.hulikan.cook.screens.fourtythree.AddFortyThreeLinksScreen
import com.hulikan.cook.screens.fourtythree.FortyThreeEditRecepiesScreen
import com.hulikan.cook.screens.fourtythree.FortyThreeRecepiesScreen
import com.hulikan.cook.screens.fourtythree.FortyThreeScreen
import com.hulikan.cook.screens.fourtythree.NewFortyThreeRecepiesScreen
import com.hulikan.cook.screens.fourtytwo.AddFortyTwoLinksScreen
import com.hulikan.cook.screens.fourtytwo.FortyTwoEditRecepiesScreen
import com.hulikan.cook.screens.fourtytwo.FortyTwoRecepiesScreen
import com.hulikan.cook.screens.fourtytwo.FortyTwoScreen
import com.hulikan.cook.screens.fourtytwo.NewFotyTwoRecepiesScreen
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
import com.hulikan.cook.screens.thirty.AddThirtyLinksScreen
import com.hulikan.cook.screens.thirty.NewThirtyRecepiesScreen
import com.hulikan.cook.screens.thirty.ThirtyEditRecepiesScreen
import com.hulikan.cook.screens.thirty.ThirtyRecepiesScreen
import com.hulikan.cook.screens.thirty.ThirtyScreen
import com.hulikan.cook.screens.thirtyeight.AddThirtyEightLinksScreen
import com.hulikan.cook.screens.thirtyeight.NewThirtyEightRecepiesScreen
import com.hulikan.cook.screens.thirtyeight.ThirtyEightEditRecepiesScreen
import com.hulikan.cook.screens.thirtyeight.ThirtyEightRecepiesScreen
import com.hulikan.cook.screens.thirtyeight.ThirtyEightScreen
import com.hulikan.cook.screens.thirtyfive.AddThirtyFiveLinksScreen
import com.hulikan.cook.screens.thirtyfive.NewThirtyFiveRecepiesScreen
import com.hulikan.cook.screens.thirtyfive.ThirtyFiveEditRecepiesScreen
import com.hulikan.cook.screens.thirtyfive.ThirtyFiveRecepiesScreen
import com.hulikan.cook.screens.thirtyfive.ThirtyFiveScreen
import com.hulikan.cook.screens.thirtyfour.AddThirtyFourLinksScreen
import com.hulikan.cook.screens.thirtyfour.NewThirtyFourRecepiesScreen
import com.hulikan.cook.screens.thirtyfour.ThirtyFourEditRecepiesScreen
import com.hulikan.cook.screens.thirtyfour.ThirtyFourRecepiesScreen
import com.hulikan.cook.screens.thirtyfour.ThirtyFourScreen
import com.hulikan.cook.screens.thirtynine.AddThirtyNineLinksScreen
import com.hulikan.cook.screens.thirtynine.NewThirtyNineRecepiesScreen
import com.hulikan.cook.screens.thirtynine.ThirtyNineEditRecepiesScreen
import com.hulikan.cook.screens.thirtynine.ThirtyNineRecepiesScreen
import com.hulikan.cook.screens.thirtynine.ThirtyNineScreen
import com.hulikan.cook.screens.thirtyone.AddThirtyOneLinksScreen
import com.hulikan.cook.screens.thirtyone.NewThirtyOneRecepiesScreen
import com.hulikan.cook.screens.thirtyone.ThirtyOneEditRecepiesScreen
import com.hulikan.cook.screens.thirtyone.ThirtyOneRecepiesScreen
import com.hulikan.cook.screens.thirtyone.ThirtyOneScreen
import com.hulikan.cook.screens.thirtyseven.AddThirtySevenLinksScreen
import com.hulikan.cook.screens.thirtyseven.NewThirtySevenRecepiesScreen
import com.hulikan.cook.screens.thirtyseven.ThirtySevenEditRecepiesScreen
import com.hulikan.cook.screens.thirtyseven.ThirtySevenRecepiesScreen
import com.hulikan.cook.screens.thirtyseven.ThirtySevenScreen
import com.hulikan.cook.screens.thirtysix.AddThirtySixLinksScreen
import com.hulikan.cook.screens.thirtysix.NewThirtySixRecepiesScreen
import com.hulikan.cook.screens.thirtysix.ThirtySixEditRecepiesScreen
import com.hulikan.cook.screens.thirtysix.ThirtySixRecepiesScreen
import com.hulikan.cook.screens.thirtysix.ThirtySixScreen
import com.hulikan.cook.screens.thirtythree.AddThirtyThreeLinksScreen
import com.hulikan.cook.screens.thirtythree.NewThirtyThreeRecepiesScreen
import com.hulikan.cook.screens.thirtythree.ThirtyThreeEditRecepiesScreen
import com.hulikan.cook.screens.thirtythree.ThirtyThreeRecepiesScreen
import com.hulikan.cook.screens.thirtythree.ThirtyThreeScreen
import com.hulikan.cook.screens.thirtytwo.AddThirtyTwoLinksScreen
import com.hulikan.cook.screens.thirtytwo.NewThirtyTwoRecepiesScreen
import com.hulikan.cook.screens.thirtytwo.ThirtyTwoEditRecepiesScreen
import com.hulikan.cook.screens.thirtytwo.ThirtyTwoRecepiesScreen
import com.hulikan.cook.screens.thirtytwo.ThirtyTwoScreen
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
import com.hulikan.cook.screens.twentyeight.AddTwentyEightLinksScreen
import com.hulikan.cook.screens.twentyeight.NewTwentyEightRecepiesScreen
import com.hulikan.cook.screens.twentyeight.TwentyEightEditRecepiesScreen
import com.hulikan.cook.screens.twentyeight.TwentyEightRecepiesScreen
import com.hulikan.cook.screens.twentyeight.TwentyEightScreen
import com.hulikan.cook.screens.twentyfive.AddTwentyFiveLinksScreen
import com.hulikan.cook.screens.twentyfive.NewTwentyFiveRecepiesScreen
import com.hulikan.cook.screens.twentyfive.TwentyFiveEditRecepiesScreen
import com.hulikan.cook.screens.twentyfive.TwentyFiveRecepiesScreen
import com.hulikan.cook.screens.twentyfive.TwentyFiveScreen
import com.hulikan.cook.screens.twentyfour.AddTwentyFourLinksScreen
import com.hulikan.cook.screens.twentyfour.NewTwentyFourRecepiesScreen
import com.hulikan.cook.screens.twentyfour.TwentyFourEditRecepiesScreen
import com.hulikan.cook.screens.twentyfour.TwentyFourRecepiesScreen
import com.hulikan.cook.screens.twentyfour.TwentyFourScreen
import com.hulikan.cook.screens.twentynine.AddTwentyNineLinksScreen
import com.hulikan.cook.screens.twentynine.NewTwentyNineRecepiesScreen
import com.hulikan.cook.screens.twentynine.TwentyNineEditRecepiesScreen
import com.hulikan.cook.screens.twentynine.TwentyNineRecepiesScreen
import com.hulikan.cook.screens.twentynine.TwentyNineScreen
import com.hulikan.cook.screens.twentyone.AddTwentyOneLinksScreen
import com.hulikan.cook.screens.twentyone.NewTwentyOneRecepiesScreen
import com.hulikan.cook.screens.twentyone.TwentyOneEditRecepiesScreen
import com.hulikan.cook.screens.twentyone.TwentyOneRecepiesScreen
import com.hulikan.cook.screens.twentyone.TwentyOneScreen
import com.hulikan.cook.screens.twentyseven.AddTwentySevenLinksScreen
import com.hulikan.cook.screens.twentyseven.NewTwentySevenRecepiesScreen
import com.hulikan.cook.screens.twentyseven.TwentySevenEditRecepiesScreen
import com.hulikan.cook.screens.twentyseven.TwentySevenRecepiesScreen
import com.hulikan.cook.screens.twentyseven.TwentySevenScreen
import com.hulikan.cook.screens.twentysix.AddTwentySixLinksScreen
import com.hulikan.cook.screens.twentysix.NewTwentySixRecepiesScreen
import com.hulikan.cook.screens.twentysix.TwentySixEditRecepiesScreen
import com.hulikan.cook.screens.twentysix.TwentySixRecepiesScreen
import com.hulikan.cook.screens.twentysix.TwentySixScreen
import com.hulikan.cook.screens.twentythree.AddTwentyThreeLinksScreen
import com.hulikan.cook.screens.twentythree.NewTwentyThreeRecepiesScreen
import com.hulikan.cook.screens.twentythree.TwentyThreeEditRecepiesScreen
import com.hulikan.cook.screens.twentythree.TwentyThreeRecepiesScreen
import com.hulikan.cook.screens.twentythree.TwentyThreeScreen
import com.hulikan.cook.screens.twentytwo.AddTwentyTwoLinksScreen
import com.hulikan.cook.screens.twentytwo.NewTwentyTwoRecepiesScreen
import com.hulikan.cook.screens.twentytwo.TwentyTwoEditRecepiesScreen
import com.hulikan.cook.screens.twentytwo.TwentyTwoRecepiesScreen
import com.hulikan.cook.screens.twentytwo.TwentyTwoScreen
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
        composable("NewTwentyOneRecepiesScreen") {
            NewTwentyOneRecepiesScreen(context, navController = navController)
        }
        composable("NewTwentyTwoRecepiesScreen") {
            NewTwentyTwoRecepiesScreen(context, navController = navController)
        }
        composable("NewTwentyThreeRecepiesScreen") {
            NewTwentyThreeRecepiesScreen(context, navController = navController)
        }
        composable("NewTwentyFourRecepiesScreen") {
            NewTwentyFourRecepiesScreen(context, navController = navController)
        }
        composable("NewTwentyFiveRecepiesScreen") {
            NewTwentyFiveRecepiesScreen(context, navController = navController)
        }
        composable("NewTwentySixRecepiesScreen") {
            NewTwentySixRecepiesScreen(context, navController = navController)
        }
        composable("NewTwentySevenRecepiesScreen") {
            NewTwentySevenRecepiesScreen(context, navController = navController)
        }
        composable("NewTwentyEightRecepiesScreen") {
            NewTwentyEightRecepiesScreen(context, navController = navController)
        }
        composable("NewTwentyNineRecepiesScreen") {
            NewTwentyNineRecepiesScreen(context, navController = navController)
        }
        composable("NewThirtyRecepiesScreen") {
            NewThirtyRecepiesScreen(context, navController = navController)
        }
        composable("NewThirtyOneRecepiesScreen") {
            NewThirtyOneRecepiesScreen(context, navController = navController)
        }
        composable("NewThirtyTwoRecepiesScreen") {
            NewThirtyTwoRecepiesScreen(context, navController = navController)
        }
        composable("NewThirtyThreeRecepiesScreen") {
            NewThirtyThreeRecepiesScreen(context, navController = navController)
        }
        composable("NewThirtyFourRecepiesScreen") {
            NewThirtyFourRecepiesScreen(context, navController = navController)
        }
        composable("NewThirtyFiveRecepiesScreen") {
            NewThirtyFiveRecepiesScreen(context, navController = navController)
        }
        composable("NewThirtySixRecepiesScreen") {
            NewThirtySixRecepiesScreen(context, navController = navController)
        }
        composable("NewThirtySevenRecepiesScreen") {
            NewThirtySevenRecepiesScreen(context, navController = navController)
        }
        composable("NewThirtyEightRecepiesScreen") {
            NewThirtyEightRecepiesScreen(context, navController = navController)
        }
        composable("NewThirtyNineRecepiesScreen") {
            NewThirtyNineRecepiesScreen(context, navController = navController)
        }
        composable("NewFortyRecepiesScreen") {
            NewFortyRecepiesScreen(context, navController = navController)
        }
        composable("NewFortyOneRecepiesScreen") {
            NewFortyOneRecepiesScreen(context, navController = navController)
        }
        composable("NewFotyTwoRecepiesScreen") {
            NewFotyTwoRecepiesScreen(context, navController = navController)
        }
        composable("NewFortyThreeRecepiesScreen") {
            NewFortyThreeRecepiesScreen(context, navController = navController)
        }
        composable("NewFortyFourRecepiesScreen") {
            NewFortyFourRecepiesScreen(context, navController = navController)
        }
        composable("NewFortyFiveRecepiesScreen") {
            NewFortyFiveRecepiesScreen(context, navController = navController)
        }
        composable("NewFortySixRecepiesScreen") {
            NewFortySixRecepiesScreen(context, navController = navController)
        }
        composable("NewFortySevenRecepiesScreen") {
            NewFortySevenRecepiesScreen(context, navController = navController)
        }
        composable("NewFortyEightRecepiesScreen") {
            NewFortyEightRecepiesScreen(context, navController = navController)
        }
        composable("NewFortyNineRecepiesScreen") {
            NewFortyNineRecepiesScreen(context, navController = navController)
        }
        composable("NewFiftyRecepiesScreen") {
            NewFiftyRecepiesScreen(context, navController = navController)
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
        composable("AddTwentyOneLinksScreen") {
            AddTwentyOneLinksScreen(context, navController = navController)
        }
        composable("AddTwentyTwoLinksScreen") {
            AddTwentyTwoLinksScreen(context, navController = navController)
        }
        composable("AddTwentyThreeLinksScreen") {
            AddTwentyThreeLinksScreen(context, navController = navController)
        }
        composable("AddTwentyFourLinksScreen") {
            AddTwentyFourLinksScreen(context, navController = navController)
        }
        composable("AddTwentyFiveLinksScreen") {
            AddTwentyFiveLinksScreen(context, navController = navController)
        }
        composable("AddTwentySixLinksScreen") {
            AddTwentySixLinksScreen(context, navController = navController)
        }
        composable("AddTwentySevenLinksScreen") {
            AddTwentySevenLinksScreen(context, navController = navController)
        }
        composable("AddTwentyEightLinksScreen") {
            AddTwentyEightLinksScreen(context, navController = navController)
        }
        composable("AddTwentyNineLinksScreen") {
            AddTwentyNineLinksScreen(context, navController = navController)
        }
        composable("AddThirtyLinksScreen") {
            AddThirtyLinksScreen(context, navController = navController)
        }
        composable("AddThirtyOneLinksScreen") {
            AddThirtyOneLinksScreen(context, navController = navController)
        }
        composable("AddThirtyTwoLinksScreen") {
            AddThirtyTwoLinksScreen(context, navController = navController)
        }
        composable("AddThirtyThreeLinksScreen") {
            AddThirtyThreeLinksScreen(context, navController = navController)
        }
        composable("AddThirtyFourLinksScreen") {
            AddThirtyFourLinksScreen(context, navController = navController)
        }
        composable("AddThirtyFiveLinksScreen") {
            AddThirtyFiveLinksScreen(context, navController = navController)
        }
        composable("AddThirtySixLinksScreen") {
            AddThirtySixLinksScreen(context, navController = navController)
        }
        composable("AddThirtySevenLinksScreen") {
            AddThirtySevenLinksScreen(context, navController = navController)
        }
        composable("AddThirtyEightLinksScreen") {
            AddThirtyEightLinksScreen(context, navController = navController)
        }
        composable("AddThirtyNineLinksScreen") {
            AddThirtyNineLinksScreen(context, navController = navController)
        }
        composable("AddFortyLinksScreen") {
            AddFortyLinksScreen(context, navController = navController)
        }
        composable("AddFortyOneLinksScreen") {
            AddFortyOneLinksScreen(context, navController = navController)
        }
        composable("AddFortyTwoLinksScreen") {
            AddFortyTwoLinksScreen(context, navController = navController)
        }
        composable("AddFortyThreeLinksScreen") {
            AddFortyThreeLinksScreen(context, navController = navController)
        }
        composable("AddFortyFourLinksScreen") {
            AddFortyFourLinksScreen(context, navController = navController)
        }
        composable("AddFortyFiveLinksScreen") {
            AddFortyFiveLinksScreen(context, navController = navController)
        }
        composable("AddFortySixLinksScreen") {
            AddFortySixLinksScreen(context, navController = navController)
        }
        composable("AddFortySevenLinksScreen") {
            AddFortySevenLinksScreen(context, navController = navController)
        }
        composable("AddFortyEightLinksScreen") {
            AddFortyEightLinksScreen(context, navController = navController)
        }
        composable("AddFortyNineLinksScreen") {
            AddFortyNineLinksScreen(context, navController = navController)
        }
        composable("AddFiftyLinksScreen") {
            AddFiftyLinksScreen(context, navController = navController)
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
        composable("TwentyOneScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentyOneScreen(context, navController, title, content, image)
        }
        composable("TwentyTwoScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentyTwoScreen(context, navController, title, content, image)
        }
        composable("TwentyThreeScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentyThreeScreen(context, navController, title, content, image)
        }
        composable("TwentyFourScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentyFourScreen(context, navController, title, content, image)
        }
        composable("TwentyFiveScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentyFiveScreen(context, navController, title, content, image)
        }
        composable("TwentySixScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentySixScreen(context, navController, title, content, image)
        }
        composable("TwentySevenScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentySevenScreen(context, navController, title, content, image)
        }
        composable("TwentyEightScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentyEightScreen(context, navController, title, content, image)
        }
        composable("TwentyNineScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentyNineScreen(context, navController, title, content, image)
        }
        composable("ThirtyScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtyScreen(context, navController, title, content, image)
        }
        composable("ThirtyOneScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtyOneScreen(context, navController, title, content, image)
        }
        composable("ThirtyTwoScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtyTwoScreen(context, navController, title, content, image)
        }
        composable("ThirtyThreeScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtyThreeScreen(context, navController, title, content, image)
        }
        composable("ThirtyFourScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtyFourScreen(context, navController, title, content, image)
        }
        composable("ThirtyFiveScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtyFiveScreen(context, navController, title, content, image)
        }
        composable("ThirtySixScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtySixScreen(context, navController, title, content, image)
        }
        composable("ThirtySevenScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtySevenScreen(context, navController, title, content, image)
        }
        composable("ThirtyEightScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtyEightScreen(context, navController, title, content, image)
        }
        composable("ThirtyNineScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtyNineScreen(context, navController, title, content, image)
        }
        composable("FourtyScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FourtyScreen(context, navController, title, content, image)
        }
        composable("FortyOneScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortyOneScreen(context, navController, title, content, image)
        }
        composable("FortyTwoScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortyTwoScreen(context, navController, title, content, image)
        }
        composable("FortyThreeScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortyThreeScreen(context, navController, title, content, image)
        }
        composable("FortyFourScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortyFourScreen(context, navController, title, content, image)
        }
        composable("FortyFiveScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortyFiveScreen(context, navController, title, content, image)
        }
        composable("FortySixScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortySixScreen(context, navController, title, content, image)
        }
        composable("FortySevenScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortySevenScreen(context, navController, title, content, image)
        }
        composable("FortyEightScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortyEightScreen(context, navController, title, content, image)
        }
        composable("FortyNineScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortyNineScreen(context, navController, title, content, image)
        }
        composable("FiftyScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FiftyScreen(context, navController, title, content, image)
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
        composable("TwentyOneRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentyOneRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("TwentyTwoRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentyTwoRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("TwentyThreeRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentyThreeRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("TwentyFourRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentyFourRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("TwentyFiveRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentyFiveRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("TwentySixRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentySixRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("TwentySevenRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentySevenRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("TwentyEightRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentyEightRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("TwentyNineRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentyNineRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("ThirtyRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtyRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("ThirtyOneRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtyOneRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("ThirtyTwoRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtyTwoRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("ThirtyThreeRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtyThreeRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("ThirtyFourRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtyFourRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("ThirtyFiveRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtyFiveRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("ThirtySixRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtySixRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("ThirtySevenRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtySevenRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("ThirtyEightRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtyEightRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("ThirtyNineRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtyNineRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("FortyRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortyRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("FortyOneRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortyOneRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("FortyTwoRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortyTwoRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("FortyThreeRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortyThreeRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("FortyFourRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortyFourRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("FortyFiveRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortyFiveRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("FortySixRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortySixRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("FortySevenRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortySevenRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("FortyEightRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortyEightRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("FortyNineRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortyNineRecepiesScreen(sharedViewModel, context, navController, title, content, image)
        }
        composable("FiftyRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FiftyRecepiesScreen(sharedViewModel, context, navController, title, content, image)
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
        composable("TwentyOneEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentyOneEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("TwentyTwoEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentyTwoEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("TwentyThreeEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentyThreeEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("TwentyFourEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentyFourEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("TwentyFiveEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentyFiveEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("TwentySixEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentySixEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("TwentySevenEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentySevenEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("TwentyEightEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentyEightEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("TwentyNineEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            TwentyNineEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("ThirtyEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtyEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("ThirtyOneEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtyOneEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("ThirtyTwoEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtyTwoEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("ThirtyThreeEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtyThreeEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("ThirtyFourEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtyFourEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("ThirtyFiveEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtyFiveEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("ThirtySixEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtySixEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("ThirtySevenEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtySevenEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("ThirtyEightEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtyEightEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("ThirtyNineEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            ThirtyNineEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("FortyEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortyEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("FortyOneEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortyOneEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("FortyTwoEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortyTwoEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("FortyThreeEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortyThreeEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("FortyFourEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortyFourEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("FortyFiveEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortyFiveEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("FortySixEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortySixEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("FortySevenEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortySevenEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("FortyEightEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortyEightEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("FortyNineEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FortyNineEditRecepiesScreen(context, navController, title, content, image)
        }
        composable("FiftyEditRecepiesScreen/{title}/{content}/{image}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("content") { type = NavType.StringType },
                navArgument("image") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title") ?: ""
            val content = backStackEntry.arguments?.getString("content") ?: ""
            val image = backStackEntry.arguments?.getString("image") ?: ""
            FiftyEditRecepiesScreen(context, navController, title, content, image)
        }
    }
}
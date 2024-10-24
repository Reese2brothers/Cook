package com.hulikan.cook

import android.app.Activity
import android.content.Context
import android.net.Uri
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.room.Room
import com.hulikan.cook.database.AppDatabase
import com.hulikan.cook.database.MainList
import com.hulikan.cook.database.One
import com.hulikan.cook.database.OneLinks
import com.hulikan.cook.viewmodels.MainViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

@Composable
fun MainScreen(context: Context, navController: NavController){
    //val viewModel: MainViewModel = viewModel()
    //val list by viewModel.mainlist.collectAsState(initial = emptyList())
    val scope = rememberCoroutineScope()
    val db = remember { Room.databaseBuilder(context, AppDatabase::class.java, "database").build() }
    val itemsFlow: Flow<List<MainList>> = db.mainListDao().getAll()
    val mainList by itemsFlow.collectAsState(initial = emptyList())
    val activity = (LocalContext.current as? Activity)
    val showDialog = remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf<MainList?>(null) }

    BackHandler {
        activity?.finishAffinity()
    }
    LaunchedEffect(mainList) {
        db.mainListDao().getAll()
    }

Box(modifier = Modifier.fillMaxSize().systemBarsPadding()) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth().height(40.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically){
            Icon(painter = painterResource(id = R.drawable.baseline_add_24),
                contentDescription = "Favorite",
                modifier = Modifier.padding(end = 12.dp).size(35.dp)
                    .clickable {
                        navController.navigate("ResourceScreen")
                    },
                tint = colorResource(R.color.broun)
            )
        }
        Row(modifier = Modifier.fillMaxWidth().height(1.dp)
            .padding(start = 4.dp, end = 4.dp)
            .background(color = colorResource(R.color.broun))){}
        LazyColumn(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
            itemsIndexed(mainList) {index, item ->
                Card(modifier = Modifier.padding(top = 4.dp, start = 8.dp, end = 8.dp, bottom = 4.dp).fillMaxWidth().height(150.dp)
                    .background(Color.Transparent),
                    shape = CutCornerShape(bottomStart = 8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                    border = BorderStroke(1.dp, color = colorResource(id = R.color.broun)),
                    onClick = {
                        when(item.wordkey){
                            "one" -> {
                                navController.navigate("OneScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "two" -> {
                                navController.navigate("TwoScreen")
                            }
                            "three" -> {
                                navController.navigate("ThreeScreen")
                            }
                            "four" -> {
                                navController.navigate("FourScreen")
                            }
                            "five" -> {
                                navController.navigate("FiveScreen")
                            }
//                            "six" -> {
//                                navController.navigate("SixScreen")
//                            }
//                            "seven" -> {
//                                navController.navigate("SevenScreen")
//                            }
//                            "eight" -> {
//                                navController.navigate("EightScreen")
//                            }
//                            "nine" -> {
//                                navController.navigate("NineScreen")
//                            }
//                            "ten" -> {
//                                navController.navigate("TenScreen")
//                            }
//                            "eleven" -> {
//                                navController.navigate("ElevenScreen")
//                            }
//                            "twelve" -> {
//                                navController.navigate("TwelveScreen")
//                            }
//                            "thirteen" -> {
//                                navController.navigate("ThirteenScreen")
//                            }
//                            "fourteen" -> {
//                                navController.navigate("FourteenScreen")
//                            }
//                            "fifteen" -> {
//                                navController.navigate("FifteenScreen")
//                            }
//                            "sixteen" -> {
//                                navController.navigate("SixteenScreen")
//                            }
//                            "seventeen" -> {
//                                navController.navigate("SeventeenScreen")
//                            }
//                            "eighteen" -> {
//                                navController.navigate("EighteenScreen")
//                            }
//                            "nineteen" -> {
//                                navController.navigate("NineteenScreen")
//                            }
//                            "twenty" -> {
//                                navController.navigate("TwentyScreen")
//                            }
//                            "twentyone" -> {
//                                navController.navigate("TwentyOneScreen")
//                            }
//                            "twentytwo" -> {
//                                navController.navigate("TwentyTwoScreen")
//                            }
//                            "twentythree" -> {
//                                navController.navigate("TwentyThreeScreen")
//                            }
//                            "twentyfour" -> {
//                                navController.navigate("TwentyFourScreen")
//                            }
//                            "twentyfive" -> {
//                                navController.navigate("TwentyFiveScreen")
//                            }
//                            "twentysix" -> {
//                                navController.navigate("TwentySixScreen")
//                            }
//                            "twentyseven" -> {
//                                navController.navigate("TwentySevenScreen")
//                            }
//                            "twentyeight" -> {
//                                navController.navigate("TwentyEightScreen")
//                            }
//                            "twentynine" -> {
//                                navController.navigate("TwentyNineScreen")
//                            }
//                            "thirty" -> {
//                                navController.navigate("ThirtyScreen")
//                            }
                        }
                    }
                ) {
                    Row(modifier = Modifier.fillMaxSize().background(colorResource(R.color.white)),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center){
                        Box(
                            modifier = Modifier.fillMaxHeight().weight(1f),
                            contentAlignment = Alignment.TopEnd
                        ) {
                            Row(modifier = Modifier.fillMaxSize().background(colorResource(R.color.white)),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center) {
                                Image(
                                    painter = painterResource(id = item.image),
                                    contentDescription = "choise_image",
                                    modifier = Modifier.fillMaxHeight().width(150.dp)
                                        .padding(top = 4.dp, bottom = 4.dp, start = 8.dp)
                                )
                                Text(
                                    text = item.text,
                                    modifier = Modifier.fillMaxWidth()
                                        .wrapContentHeight(Alignment.CenterVertically)
                                        .padding(end = 8.dp),
                                    textAlign = TextAlign.Center,
                                    fontSize = 30.sp,
                                    color = colorResource(id = R.color.broun),
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily(Font(R.font.imprisha))
                                )
                            }
                        }
                        Column(modifier = Modifier.fillMaxHeight(),
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.CenterHorizontally){
                            Text(
                                text = "${index + 1}/30",
                                modifier = Modifier.padding(end = 8.dp, top = 4.dp),
                                textAlign = TextAlign.Center,
                                fontSize = 12.sp,
                                color = colorResource(id = R.color.broun),
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.venik),
                                contentDescription = "delete_item",
                                modifier = Modifier.size(30.dp).padding(end = 8.dp, bottom = 4.dp).clickable {
                                   showDialog.value = true
                                    selectedItem = item
                                },
                                tint = colorResource(R.color.broun)
                            )
                            if (showDialog.value) {
                                AlertDialog(
                                    onDismissRequest = {
                                        showDialog.value = false
                                    },
                                    containerColor = colorResource(id = R.color.white),
                                    title = { Text("Подтверждение", color = colorResource(id = R.color.broun),
                                        fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                                    text = {
                                        Text("Вы действительно хотите удалить данный раздел?",
                                            color = colorResource(id = R.color.broun)
                                        )
                                    },
                                    confirmButton = {
                                        Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                            containerColor = colorResource(id = R.color.broun)
                                        ),
                                            onClick = {
                                                scope.launch{
                                                    val allImageUris = db.oneDao().getAllImages().map { it.images }
                                                        .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                        .map { Uri.parse(it) }
                                                    db.oneDao().deleteAll()
                                                    db.oneLinksDao().deleteAll()
                                                    allImageUris.forEach { imageUri ->
                                                        context.contentResolver.delete(imageUri, null, null)
                                                    }
                                                    selectedItem?.let { db.mainListDao().deleteList(it) }
                                                }
                                                showDialog.value = false
                                            }) {
                                            Text("Да", color = colorResource(id = R.color.white), fontSize = 16.sp)
                                        }
                                    },
                                    dismissButton = {
                                        Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                            containerColor = colorResource(id = R.color.broun)
                                        ),
                                            onClick = {
                                                showDialog.value = false
                                            }) {
                                            Text("Отмена", color = colorResource(id = R.color.white), fontSize = 16.sp)
                                        }
                                    })
                            }
                        }
                    }
                }
            }
        }
    }
}
}

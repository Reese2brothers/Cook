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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.room.Room
import com.hulikan.cook.database.AppDatabase
import com.hulikan.cook.database.MainList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.net.URLEncoder

@Composable
fun MainScreen(context: Context, navController: NavController, title : String, image : String, wordkey : String){
    val scope = rememberCoroutineScope()
    val db = remember { Room.databaseBuilder(context, AppDatabase::class.java, "database").build() }
    val itemsFlow: Flow<List<MainList>> = db.mainListDao().getAll()
    val mainList by itemsFlow.collectAsState(initial = emptyList())
    val activity = (LocalContext.current as? Activity)
    val showDialog = remember { mutableStateOf(false) }
    val showDialogTwo = remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf<MainList?>(null) }
    var selectedItemTwo by remember { mutableStateOf<MainList?>(null) }
    val isFavouritesEmpty by produceState<Boolean>(initialValue = true) {
        value = db.favouritesDao().isEmpty() }
    var favouritesCount by remember { mutableStateOf(0) }

    BackHandler {
        activity?.finishAffinity()
    }
    LaunchedEffect(mainList) {
        db.mainListDao().getAll()
    }
    LaunchedEffect(Unit) {
        favouritesCount = db.favouritesDao().getCount()
    }

Box(modifier = Modifier
    .fillMaxSize()
    .systemBarsPadding()) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ){
            Icon(painter = painterResource(  id = if (!isFavouritesEmpty) R.drawable.baseline_favorite_border
                                      else R.drawable.baseline_favorite_red),
                contentDescription = "favourite",
                modifier = Modifier
                    .padding(start = 16.dp)
                    .size(30.dp)
                    .clickable {
                        navController.navigate("FavouriteScreen")
                    },
                tint = Color.Unspecified
            )
            Text(
                text = "$favouritesCount",
                modifier = Modifier.padding(end = 140.dp),
                textAlign = TextAlign.Start,
                fontSize = 14.sp,
                color = colorResource(id = R.color.broun),
                fontFamily = FontFamily(Font(R.font.imprisha))
            )
            Text(
                text = stringResource(R.string.main_category_of_recepies),
                textAlign = TextAlign.Start,
                fontSize = 12.sp,
                color = colorResource(id = R.color.broun),
                modifier = Modifier.padding(end = 8.dp),
                fontFamily = FontFamily(Font(R.font.imprisha))
            )
            Icon(painter = painterResource(id = R.drawable.baseline_add_24),
                contentDescription = "add_new_category",
                modifier = Modifier
                    .padding(end = 12.dp)
                    .size(35.dp)
                    .clickable {
                        navController.navigate(
                            "ResourceScreen/${
                                URLEncoder.encode(
                                    "empty",
                                    "UTF-8"
                                )
                            }/no_image/no_data"
                        )
                    },
                tint = colorResource(R.color.broun)
            )
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .padding(start = 4.dp, end = 4.dp)
            .background(color = colorResource(R.color.broun))){}
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {
            itemsIndexed(mainList) {index, item ->
                Card(modifier = Modifier
                    .padding(top = 4.dp, start = 8.dp, end = 8.dp, bottom = 4.dp)
                    .fillMaxWidth()
                    .height(150.dp)
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
                                navController.navigate("TwoScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "three" -> {
                                navController.navigate("ThreeScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "four" -> {
                                navController.navigate("FourScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "five" -> {
                                navController.navigate("FiveScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "six" -> {
                                navController.navigate("SixScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "seven" -> {
                                navController.navigate("SevenScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "eight" -> {
                                navController.navigate("EightScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "nine" -> {
                                navController.navigate("NineScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "ten" -> {
                                navController.navigate("TenScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "eleven" -> {
                                navController.navigate("ElevenScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "twelve" -> {
                                navController.navigate("TwelveScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "thirteen" -> {
                                navController.navigate("ThirteenScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "fourteen" -> {
                                navController.navigate("FourteenScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "fifteen" -> {
                                navController.navigate("FifteenScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "sixteen" -> {
                                navController.navigate("SixteenScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "seventeen" -> {
                                navController.navigate("SeventeenScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "eighteen" -> {
                                navController.navigate("EighteenScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "nineteen" -> {
                                navController.navigate("NineteenScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "twenty" -> {
                                navController.navigate("TwentyScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "twentyone" -> {
                                navController.navigate("TwentyOneScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "twentytwo" -> {
                                navController.navigate("TwentyTwoScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "twentythree" -> {
                                navController.navigate("TwentyThreeScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "twentyfour" -> {
                                navController.navigate("TwentyFourScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "twentyfive" -> {
                                navController.navigate("TwentyFiveScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "twentysix" -> {
                                navController.navigate("TwentySixScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "twentyseven" -> {
                                navController.navigate("TwentySevenScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "twentyeight" -> {
                                navController.navigate("TwentyEightScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "twentynine" -> {
                                navController.navigate("TwentyNineScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                            "thirty" -> {
                                navController.navigate("ThirtyScreen/${"пусто"}/${"пусто"}/${"пусто"}")
                            }
                        }
                    }
                ) {
                    Row(modifier = Modifier
                        .fillMaxSize()
                        .background(colorResource(R.color.white)),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center){
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(1f),
                            contentAlignment = Alignment.TopEnd
                        ) {
                            Row(modifier = Modifier
                                .fillMaxSize()
                                .background(colorResource(R.color.white)),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center) {
                                Image(
                                    painter = painterResource(id = item.image),
                                    contentDescription = "choise_image",
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .width(150.dp)
                                        .padding(top = 4.dp, bottom = 4.dp, start = 8.dp)
                                )
                                Text(
                                    text = item.text,
                                    modifier = Modifier
                                        .fillMaxWidth()
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
                            Column {
                                Icon(
                                    painter = painterResource(id = R.drawable.baseline_edit_24),
                                    contentDescription = "edit_item",
                                    modifier = Modifier
                                        .size(30.dp)
                                        .padding(end = 8.dp, bottom = 8.dp)
                                        .clickable {
                                            showDialogTwo.value = true
                                            selectedItemTwo = item
                                        },
                                    tint = colorResource(R.color.broun)
                                )
                                if (showDialogTwo.value) {
                                    AlertDialog(
                                        onDismissRequest = {
                                            showDialogTwo.value = false
                                        },
                                        containerColor = colorResource(id = R.color.white),
                                        title = { Text(stringResource(R.string.alert_confirm), color = colorResource(id = R.color.broun),
                                            fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                                        text = {
                                            Text(
                                                stringResource(R.string.alert_edit_category),
                                                color = colorResource(id = R.color.broun)
                                            )
                                        },
                                        confirmButton = {
                                            Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                                containerColor = colorResource(id = R.color.broun)
                                            ),
                                                onClick = {
                                                    val encodedTitle = URLEncoder.encode(selectedItemTwo?.text, "UTF-8")
                                                    val encodedImage = URLEncoder.encode(selectedItemTwo?.image.toString(), "UTF-8")
                                                    val encodedWordkey = URLEncoder.encode(selectedItemTwo?.wordkey, "UTF-8")
                                                    navController.navigate("ResourceScreen/$encodedTitle/$encodedImage/$encodedWordkey")
                                                    showDialogTwo.value = false
                                                }) {
                                                Text(stringResource(R.string.alert_yes), color = colorResource(id = R.color.white), fontSize = 16.sp)
                                            }
                                        },
                                        dismissButton = {
                                            Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                                containerColor = colorResource(id = R.color.broun)
                                            ),
                                                onClick = {
                                                    showDialogTwo.value = false
                                                }) {
                                                Text(stringResource(R.string.alert_cancel), color = colorResource(id = R.color.white), fontSize = 16.sp)
                                            }
                                        })
                                }
                                Icon(
                                    painter = painterResource(id = R.drawable.venik),
                                    contentDescription = "delete_item",
                                    modifier = Modifier
                                        .size(30.dp)
                                        .padding(end = 8.dp, bottom = 4.dp)
                                        .clickable {
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
                                        title = { Text(
                                            stringResource(R.string.alert_confirm), color = colorResource(id = R.color.broun),
                                            fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                                        text = {
                                            Text(
                                                stringResource(R.string.alert_delete_category),
                                                color = colorResource(id = R.color.broun)
                                            )
                                        },
                                        confirmButton = {
                                            Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                                containerColor = colorResource(id = R.color.broun)
                                            ),
                                                onClick = {
                                                    when(item.wordkey){
                                                        "one" -> {
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
                                                        }
                                                        "two" -> {
                                                            scope.launch{
                                                                val allImageUris = db.twoDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.twoDao().deleteAll()
                                                                db.twoLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                        "three" -> {
                                                            scope.launch{
                                                                val allImageUris = db.threeDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.threeDao().deleteAll()
                                                                db.threeLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                        "four" -> {
                                                            scope.launch{
                                                                val allImageUris = db.fourDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.fourDao().deleteAll()
                                                                db.fourLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                        "five" -> {
                                                            scope.launch{
                                                                val allImageUris = db.fiveDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.fiveDao().deleteAll()
                                                                db.fiveLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                        "six" -> {
                                                            scope.launch{
                                                                val allImageUris = db.sixDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.sixDao().deleteAll()
                                                                db.sixLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                        "seven" -> {
                                                            scope.launch{
                                                                val allImageUris = db.sevenDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.sevenDao().deleteAll()
                                                                db.sevenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                        "eight" -> {
                                                            scope.launch{
                                                                val allImageUris = db.eightDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.eightDao().deleteAll()
                                                                db.eightLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                        "nine" -> {
                                                            scope.launch{
                                                                val allImageUris = db.nineDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.nineDao().deleteAll()
                                                                db.nineLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                        "ten" -> {
                                                            scope.launch{
                                                                val allImageUris = db.tenDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.tenDao().deleteAll()
                                                                db.tenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                        "eleven" -> {
                                                            scope.launch{
                                                                val allImageUris = db.elevenDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.elevenDao().deleteAll()
                                                                db.elevenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                        "twelve" -> {
                                                            scope.launch{
                                                                val allImageUris = db.twelveDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.twelveDao().deleteAll()
                                                                db.twelveLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                        "thirteen" -> {
                                                            scope.launch{
                                                                val allImageUris = db.thirteenDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.thirteenDao().deleteAll()
                                                                db.thirteenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                        "fourteen" -> {
                                                            scope.launch{
                                                                val allImageUris = db.fourteenDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.fourteenDao().deleteAll()
                                                                db.fourteenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                        "fifteen" -> {
                                                            scope.launch{
                                                                val allImageUris = db.fifteenDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.fifteenDao().deleteAll()
                                                                db.fifteenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                        "sixteen" -> {
                                                            scope.launch{
                                                                val allImageUris = db.sixteenDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.sixteenDao().deleteAll()
                                                                db.sixteenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                        "seventeen" -> {
                                                            scope.launch{
                                                                val allImageUris = db.seventeenDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.seventeenDao().deleteAll()
                                                                db.seventeenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                        "eighteen" -> {
                                                            scope.launch{
                                                                val allImageUris = db.eighteenDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.eighteenDao().deleteAll()
                                                                db.eighteenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                        "nineteen" -> {
                                                            scope.launch{
                                                                val allImageUris = db.nineteenDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.nineteenDao().deleteAll()
                                                                db.nineteenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                        "twenty" -> {
                                                            scope.launch{
                                                                val allImageUris = db.twentyDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.twentyDao().deleteAll()
                                                                db.twentyLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                        "twentyOne" -> {
                                                            scope.launch{
                                                                val allImageUris = db.twentyOneDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.twentyOneDao().deleteAll()
                                                                db.twentyOneLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                        "twentyTwo" -> {
                                                            scope.launch{
                                                                val allImageUris = db.twentyTwoDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.twentyTwoDao().deleteAll()
                                                                db.twentyTwoLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                        "twentyThree" -> {
                                                            scope.launch{
                                                                val allImageUris = db.twentyThreeDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.twentyThreeDao().deleteAll()
                                                                db.twentyThreeLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                        "twentyFour" -> {
                                                            scope.launch{
                                                                val allImageUris = db.twentyFourDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.twentyFourDao().deleteAll()
                                                                db.twentyFourLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                        "twentyFive" -> {
                                                            scope.launch{
                                                                val allImageUris = db.twentyFiveDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.twentyFiveDao().deleteAll()
                                                                db.twentyFiveLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                        "twentySix" -> {
                                                            scope.launch{
                                                                val allImageUris = db.twentySixDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.twentySixDao().deleteAll()
                                                                db.twentySixLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                        "twentySeven" -> {
                                                            scope.launch{
                                                                val allImageUris = db.twentySevenDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.twentySevenDao().deleteAll()
                                                                db.twentySevenLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                        "twentyEight" -> {
                                                            scope.launch{
                                                                val allImageUris = db.twentyEightDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.twentyEightDao().deleteAll()
                                                                db.twentyEightLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                        "twentyNine" -> {
                                                            scope.launch{
                                                                val allImageUris = db.twentyNineDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.twentyNineDao().deleteAll()
                                                                db.twentyNineLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                        "thirty" -> {
                                                            scope.launch{
                                                                val allImageUris = db.thirtyDao().getAllImages().map { it.images }
                                                                    .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                                                    .map { Uri.parse(it) }
                                                                db.thirtyDao().deleteAll()
                                                                db.thirtyLinksDao().deleteAll()
                                                                allImageUris.forEach { imageUri ->
                                                                    context.contentResolver.delete(imageUri, null, null)
                                                                }
                                                                selectedItem?.let { db.mainListDao().deleteList(it) }
                                                            }
                                                        }
                                                    }
                                                    showDialog.value = false
                                                }) {
                                                Text(stringResource(R.string.alert_yes), color = colorResource(id = R.color.white), fontSize = 16.sp)
                                            }
                                        },
                                        dismissButton = {
                                            Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                                containerColor = colorResource(id = R.color.broun)
                                            ),
                                                onClick = {
                                                    showDialog.value = false
                                                }) {
                                                Text(stringResource(R.string.alert_cancel), color = colorResource(id = R.color.white), fontSize = 16.sp)
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
}

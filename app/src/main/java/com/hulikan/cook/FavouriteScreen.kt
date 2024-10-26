package com.hulikan.cook

import android.content.Context
import android.net.Uri
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.room.Room
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.hulikan.cook.database.AppDatabase
import com.hulikan.cook.database.Favourites
import com.hulikan.cook.database.OneLinks
import kotlinx.coroutines.launch
import java.net.URLEncoder

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FavouriteScreen(context : Context, navController: NavController){
    val scope = rememberCoroutineScope()
    val db = remember { Room.databaseBuilder(context, AppDatabase::class.java, "database").build() }
    val showDialog = remember { mutableStateOf(false) }
    val showDialogTwo = remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf<Favourites?>(null) }

Column(modifier = Modifier.fillMaxSize().systemBarsPadding(),
   horizontalAlignment = Alignment.CenterHorizontally ) {
    Row(modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween) {
        Text(
            text = "Избранное",
            modifier = Modifier.padding(start = 150.dp),
            textAlign = TextAlign.Start,
            fontSize = 20.sp,
            color = colorResource(id = R.color.broun),
            fontFamily = FontFamily(Font(R.font.imprisha))
        )
        Icon(
            painter = painterResource(id = R.drawable.venik),
            contentDescription = "delete_all_favourites",
            modifier = Modifier.size(35.dp).padding(end = 8.dp).clickable {
                showDialogTwo.value = true
            },
            tint = colorResource(R.color.broun)
        )
        if (showDialogTwo.value) {
            AlertDialog(
                onDismissRequest = {
                    showDialogTwo.value = false
                },
                containerColor = colorResource(id = R.color.white),
                title = { Text("Подтверждение", color = colorResource(id = R.color.broun),
                    fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                text = {
                    Text("Вы действительно хотите удалить все рецепты из избранного?",
                        color = colorResource(id = R.color.broun)
                    )
                },
                confirmButton = {
                    Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.broun)
                    ),
                        onClick = {
                            scope.launch {
                                db.favouritesDao().deleteAll()
                            }
                            showDialogTwo.value = false
                        }) {
                        Text("Да", color = colorResource(id = R.color.white), fontSize = 16.sp)
                    }
                },
                dismissButton = {
                    Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.broun)
                    ),
                        onClick = {
                            showDialogTwo.value = false
                        }) {
                        Text("Отмена", color = colorResource(id = R.color.white), fontSize = 16.sp)
                    }
                })
        }
    }

    var listFavourites by remember { mutableStateOf<List<Favourites>>(emptyList()) }
    LaunchedEffect(Unit) {
        db.favouritesDao().getAll().collect { favourites ->
            listFavourites = favourites
        }
    }
    LazyColumn {
        itemsIndexed(listFavourites) { index, item ->
            Card(modifier = Modifier.padding(top = 4.dp, start = 8.dp, end = 8.dp, bottom = 4.dp)
                .fillMaxWidth().height(120.dp).background(Color.Transparent),
                shape = CutCornerShape(bottomStart = 8.dp),
                elevation = 5.dp,
                border = BorderStroke(1.dp, color = colorResource(id = R.color.broun)),
                onClick = {
                    val encodedTitle = URLEncoder.encode(item.title, "UTF-8")
                    val encodedContent = URLEncoder.encode(item.content, "UTF-8")
                    val encodedImages = URLEncoder.encode(item.images, "UTF-8") ?: R.drawable.baseline_add_photo_alternate_24.toString()
                    when (item.favouriteskey) {
                        "OneRecepiesScreen" ->  navController.navigate("OneRecepiesScreen/$encodedTitle/$encodedContent/$encodedImages")
                        "TwoRecepiesScreen" -> navController.navigate("TwoRecepiesScreen/$encodedTitle/$encodedContent/$encodedImages")
                        // ... другие экраны ...
                        else -> { /* Unknown favouriteskey */ }
                    }
                }
            ){
                Row(modifier = Modifier.fillMaxSize().background(colorResource(R.color.white)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center){
                    Box(
                        modifier = Modifier.fillMaxHeight().weight(1f),
                        contentAlignment = Alignment.TopEnd
                    ) {
                        Row(modifier = Modifier.fillMaxHeight().background(colorResource(R.color.white)),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center) {
                            val firstImageUri = remember(item.images) { item.images.split(",")
                                    .firstOrNull { it.startsWith("content://") || it.startsWith("file://") }
                            }
                            AsyncImage(
                                model = ImageRequest.Builder(context)
                                    .data(firstImageUri)
                                    .crossfade(true)
                                    .build(),
                                contentDescription = "choise_image",
                                modifier = Modifier.fillMaxHeight().width(120.dp).fillMaxHeight(),
                                contentScale = ContentScale.Crop,
                                placeholder = painterResource(R.drawable.baseline_image_24),
                                error = painterResource(R.drawable.baseline_error)
                            )
                            Text(
                                text = item.title,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight(Alignment.CenterVertically)
                                    .padding(end = 8.dp),
                                textAlign = TextAlign.Center,
                                fontSize = 24.sp,
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
                                text = "${index + 1}",
                                modifier = Modifier.padding(end = 8.dp, top = 4.dp),
                                textAlign = TextAlign.Center,
                                fontSize = 12.sp,
                                color = colorResource(id = R.color.broun),
                            )
                        Icon(
                            painter = painterResource(id = R.drawable.venik),
                            contentDescription = "delete_item_favourites",
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
                                    Text("Вы действительно хотите удалить данный рецепт из избранного?",
                                        color = colorResource(id = R.color.broun)
                                    )
                                },
                                confirmButton = {
                                    Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                        containerColor = colorResource(id = R.color.broun)
                                    ),
                                        onClick = {
                                            scope.launch {
                                               db.favouritesDao().deleteFavourite(item.title, item.favouriteskey)
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
package com.hulikan.cook.screens.fourtythree


import android.content.Context
import android.net.Uri
import androidx.activity.compose.BackHandler
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.room.Room
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.hulikan.cook.R
import com.hulikan.cook.database.AppDatabase
import com.hulikan.cook.database.FortyThree
import com.hulikan.cook.database.FortyThreeLinks
import com.hulikan.cook.database.One
import com.hulikan.cook.database.OneLinks
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.net.URLEncoder

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FortyThreeScreen(context : Context, navController: NavController, title : String, content : String, image : String){
    val scope = rememberCoroutineScope()
    val db = remember { Room.databaseBuilder(context, AppDatabase::class.java, "database").build() }
    val itemsFlow: Flow<List<FortyThreeLinks>> = db.fortyThreeLinksDao().getAll()
    val fortyThreelistFlow: Flow<List<FortyThree>> = db.fortyThreeDao().getAll()
    val links by itemsFlow.collectAsState(initial = emptyList())
    val fortyThreelist by fortyThreelistFlow.collectAsState(initial = emptyList())
    val showDialog = remember { mutableStateOf(false) }
    val showDialogTwo = remember { mutableStateOf(false) }
    val showDialogThree = remember { mutableStateOf(false) }
    val showDialogFour = remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf<FortyThreeLinks?>(null) }
    var selectedItemTwo by remember { mutableStateOf<FortyThree?>(null) }

    BackHandler {
        navController.navigate("MainScreen/no_data/no_data/no_data")
    }
    LaunchedEffect(links) {
        db.fortyThreeLinksDao().getAll()
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .systemBarsPadding()){
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically) {
                Text(text = stringResource(R.string.one_links_to_recepies),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 42.dp),
                    textAlign = TextAlign.Start,
                    fontSize = 18.sp,
                    color = colorResource(id = R.color.broun),
                    fontFamily = FontFamily(Font(R.font.imprisha))
                )
                Row(
                    modifier = Modifier.padding(end = 42.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_add_24),
                        contentDescription = "add",
                        modifier = Modifier
                            .size(35.dp)
                            .padding(end = 8.dp)
                            .clickable {
                                navController.navigate("AddFortyThreeLinksScreen")
                            },
                        tint = colorResource(R.color.broun)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.venik),
                        contentDescription = "delete_all_links",
                        modifier = Modifier
                            .size(25.dp)
                            .clickable {
                                showDialog.value = true
                            },
                        tint = colorResource(R.color.broun)
                    )
                    if (showDialog.value) {
                        AlertDialog(
                            onDismissRequest = {
                                showDialog.value = false
                            },
                            containerColor = colorResource(id = R.color.white),
                            title = { Text(stringResource(R.string.alert_confirm), color = colorResource(id = R.color.broun),
                                fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                            text = {
                                Text(
                                    stringResource(R.string.alert_delete_all_links),
                                    color = colorResource(id = R.color.broun)
                                )
                            },
                            confirmButton = {
                                Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                    containerColor = colorResource(id = R.color.broun)
                                ),
                                    onClick = {
                                        scope.launch {
                                            db.fortyThreeLinksDao().deleteAll()
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
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .padding(start = 32.dp, end = 32.dp)
                .background(
                    colorResource(R.color.broun)
                )) {}
            LazyColumn(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(top = 4.dp, bottom = 4.dp)) {
                itemsIndexed(links) {index, item ->
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(bottom = 4.dp)) {
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(bottom = 4.dp),
                            verticalAlignment = Alignment.CenterVertically) {
                            Text(text = item.title,
                                modifier = Modifier
                                    .padding(start = 8.dp, end = 4.dp)
                                    .weight(1.5f),
                                textAlign = TextAlign.Start,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.broun),
                                fontFamily = FontFamily(Font(R.font.imprisha))
                            )
                            val uriHandler = LocalUriHandler.current
                            ClickableText(
                                text = AnnotatedString(
                                    text = item.link,
                                    spanStyle = SpanStyle(
                                        color = Color.Blue,
                                        textDecoration = TextDecoration.Underline,
                                        fontFamily = FontFamily(Font(R.font.imprisha)),
                                        fontSize = 12.sp
                                    )
                                ),
                                onClick = {
                                    uriHandler.openUri(item.link)
                                },
                                modifier = Modifier
                                    .padding(start = 8.dp, end = 4.dp)
                                    .weight(3.5f)
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.venik),
                                contentDescription = "delete",
                                modifier = Modifier
                                    .size(18.dp)
                                    .weight(0.5f)
                                    .clickable {
                                        showDialogTwo.value = true
                                        selectedItem = item
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
                                            stringResource(R.string.alert_delete_link),
                                            color = colorResource(id = R.color.broun)
                                        )
                                    },
                                    confirmButton = {
                                        Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                            containerColor = colorResource(id = R.color.broun)
                                        ),
                                            onClick = {
                                                scope.launch {
                                                    selectedItem?.let {
                                                        db.fortyThreeLinksDao().deleteFortyThreeLinks(it)
                                                    }
                                                }
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
                        }
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .padding(start = 16.dp, end = 8.dp)
                            .background(colorResource(R.color.red))){}
                    }
                }
            }
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .padding(start = 4.dp, end = 4.dp)
            .background(
                colorResource(R.color.broun)
            )) {}
        Row(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically) {
            Text(text = stringResource(R.string.one_your_recepies),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 42.dp),
                textAlign = TextAlign.Start,
                fontSize = 18.sp,
                color = colorResource(id = R.color.broun),
                fontFamily = FontFamily(Font(R.font.imprisha))
            )
            Row(
                modifier = Modifier.padding(end = 42.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_add_24),
                    contentDescription = "add_recepies",
                    modifier = Modifier
                        .size(35.dp)
                        .padding(end = 8.dp)
                        .clickable {
                            navController.navigate("NewFortyThreeRecepiesScreen")
                        },
                    tint = colorResource(R.color.broun)
                )
                Icon(
                    painter = painterResource(id = R.drawable.venik),
                    contentDescription = "delete_all_recepies",
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {
                            showDialogFour.value = true
                        },
                    tint = colorResource(R.color.broun)
                )
                if (showDialogFour.value) {
                    AlertDialog(
                        onDismissRequest = {
                            showDialogFour.value = false
                        },
                        containerColor = colorResource(id = R.color.white),
                        title = { Text(stringResource(R.string.alert_confirm), color = colorResource(id = R.color.broun),
                            fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                        text = {
                            Text(
                                stringResource(R.string.alert_delete_all_recepies),
                                color = colorResource(id = R.color.broun)
                            )
                        },
                        confirmButton = {
                            Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.broun)
                            ),
                                onClick = {
                                    scope.launch {
                                        val allImageUris = db.fortyThreeDao().getAllImages().map { it.images }
                                            .flatMap { it.split(",").filter { it.isNotBlank() && it.startsWith("content://") } }
                                            .map { Uri.parse(it) }
                                        db.fortyThreeDao().deleteAll()
                                        allImageUris.forEach { imageUri ->
                                            context.contentResolver.delete(imageUri, null, null)
                                        }
                                    }
                                    showDialogFour.value = false
                                }) {
                                Text(stringResource(R.string.alert_yes), color = colorResource(id = R.color.white), fontSize = 16.sp)
                            }
                        },
                        dismissButton = {
                            Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.broun)
                            ),
                                onClick = {
                                    showDialogFour.value = false
                                }) {
                                Text(stringResource(R.string.alert_cancel), color = colorResource(id = R.color.white), fontSize = 16.sp)
                            }
                        })
                }
            }
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .padding(start = 32.dp, end = 32.dp)
            .background(
                colorResource(R.color.broun)
            )) {}
        LaunchedEffect(fortyThreelist) {
            db.fortyThreeDao().getAll()
        }
        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .padding(top = 4.dp, bottom = 4.dp)) {
            itemsIndexed(fortyThreelist) {index, item ->
                Card(modifier = Modifier
                    .padding(top = 4.dp, start = 8.dp, end = 8.dp, bottom = 4.dp)
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(Color.Transparent),
                    shape = CutCornerShape(bottomStart = 8.dp),
                    elevation = 5.dp,
                    border = BorderStroke(1.dp, color = colorResource(id = R.color.broun)),
                    onClick = {
                        val encodedTitle = if (item.title.isEmpty()) {
                            "no_data"
                        } else {
                            URLEncoder.encode(item.title, "UTF-8")
                        }

                        val encodedContent = if (item.content.isEmpty()) {
                            "no_data"
                        } else {
                            URLEncoder.encode(item.content, "UTF-8")
                        }
                        val encodedImages = if (item.images.isEmpty()) {
                            R.drawable.baseline_add_photo_alternate_24.toString()
                        } else {
                            URLEncoder.encode(item.images, "UTF-8")
                        }
                        navController.navigate("FortyThreeRecepiesScreen/$encodedTitle/$encodedContent/$encodedImages")
                    }
                ){
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
                                .fillMaxHeight()
                                .background(colorResource(R.color.white)),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center) {
                                val firstImageUri = item.images.split(",")
                                    .firstOrNull { it.startsWith("content://") }
                                    ?.trim()
                                    ?: item.images.split(",").firstOrNull()?.trim()
                                val imageModel = if (firstImageUri.isNullOrEmpty()
                                    || firstImageUri == R.drawable.baseline_add_photo_alternate_24.toString()) {
                                    R.drawable.baseline_add_photo_alternate_24
                                } else {
                                    firstImageUri
                                }
                                AsyncImage(
                                    model = ImageRequest.Builder(context)
                                        .data(imageModel)
                                        .crossfade(true)
                                        .build(),
                                    contentDescription = "choise_image",
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .width(150.dp)
                                        .fillMaxHeight(),
                                    contentScale = ContentScale.Crop
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
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "${index + 1}",
                                    modifier = Modifier.padding(end = 8.dp, top = 4.dp),
                                    textAlign = TextAlign.Center,
                                    fontSize = 12.sp,
                                    color = colorResource(id = R.color.broun),
                                )
                                val isFavourite by produceState<Boolean>(initialValue = false, item.title) {
                                    value = db.favouritesDao().isFavourite(item.title, "FortyThreeRecepiesScreen")
                                }
                                Icon(
                                    painter = painterResource(
                                        id = if (isFavourite) R.drawable.baseline_favorite_red else R.drawable.baseline_favorite_border
                                    ),
                                    contentDescription = "show_favourites",
                                    modifier = Modifier
                                        .size(25.dp)
                                        .padding(end = 8.dp, bottom = 4.dp),
                                    tint = Color.Unspecified
                                )
                            }
                            Icon(
                                painter = painterResource(id = R.drawable.venik),
                                contentDescription = "delete_item",
                                modifier = Modifier
                                    .size(30.dp)
                                    .padding(end = 8.dp, bottom = 4.dp)
                                    .clickable {
                                        showDialogThree.value = true
                                        selectedItemTwo = item
                                    },
                                tint = colorResource(R.color.broun)
                            )
                            if (showDialogThree.value) {
                                AlertDialog(
                                    onDismissRequest = {
                                        showDialogThree.value = false
                                    },
                                    containerColor = colorResource(id = R.color.white),
                                    title = { Text(stringResource(R.string.alert_confirm), color = colorResource(id = R.color.broun),
                                        fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                                    text = {
                                        Text(
                                            stringResource(R.string.alert_delete_recepie),
                                            color = colorResource(id = R.color.broun)
                                        )
                                    },
                                    confirmButton = {
                                        Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                            containerColor = colorResource(id = R.color.broun)
                                        ),
                                            onClick = {
                                                scope.launch {
                                                    val imageUrisToDelete = selectedItemTwo?.images?.split(",")
                                                        ?.filter { it.isNotBlank() && it.startsWith("content://") }
                                                        ?.map { Uri.parse(it) } ?: emptyList()
                                                    selectedItemTwo?.let { db.fortyThreeDao().deleteFortyThree(it) }
                                                    imageUrisToDelete.forEach { imageUri ->
                                                        context.contentResolver.delete(imageUri, null, null)
                                                    }
                                                    val videoUrisToDelete = selectedItemTwo?.videos?.split(",")
                                                        ?.filter { it.isNotBlank() && it.startsWith("content://") }
                                                        ?.map { Uri.parse(it) } ?: emptyList()
                                                    videoUrisToDelete.forEach { videoUri ->
                                                        context.contentResolver.delete(videoUri, null, null)
                                                    }
                                                }
                                                showDialogThree.value = false
                                            }) {
                                            Text(stringResource(R.string.alert_yes), color = colorResource(id = R.color.white), fontSize = 16.sp)
                                        }
                                    },
                                    dismissButton = {
                                        Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                            containerColor = colorResource(id = R.color.broun)
                                        ),
                                            onClick = {
                                                showDialogThree.value = false
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
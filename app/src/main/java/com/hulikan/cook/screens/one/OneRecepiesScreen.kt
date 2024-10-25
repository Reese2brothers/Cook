package com.hulikan.cook.screens.one

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
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
import androidx.core.content.FileProvider
import androidx.core.net.toUri
import androidx.core.view.indices
import androidx.navigation.NavController
import androidx.room.Room
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.hulikan.cook.R
import com.hulikan.cook.database.AppDatabase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.File
import java.net.URLDecoder
import java.net.URLEncoder
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun OneRecepiesScreen(context : Context, navController: NavController, title : String, content : String, image : String){
    val scope = rememberCoroutineScope()
    val db = remember { Room.databaseBuilder(context, AppDatabase::class.java, "database").build() }
    var selectedImageUri by rememberSaveable { mutableStateOf<Uri?>(null) }
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }
    var isImageCaptured by remember { mutableStateOf(false) }
    val decodedTitle = URLDecoder.decode(title, "UTF-8")
    val decodedContent = URLDecoder.decode(content, "UTF-8")
    val decodedImage = URLDecoder.decode(image, "UTF-8")
    var imagesString by rememberSaveable { mutableStateOf(decodedImage) }
    var listImages by remember { mutableStateOf<List<String>>(emptyList()) }
    var bigPhoto by rememberSaveable { mutableStateOf<Uri?>(null) }
    val showDialog = remember { mutableStateOf(false) }
    val showDialogTwo = remember { mutableStateOf(false) }
    var selectedItemIndex by remember { mutableStateOf(0) }
    val titleText = rememberSaveable { mutableStateOf("") }
    val contentText = rememberSaveable { mutableStateOf("") }

    BackHandler {
        val encodedTitle = URLEncoder.encode(titleText.value, "UTF-8")
        val encodedContent = URLEncoder.encode(contentText.value, "UTF-8")
        val encodedImage = URLEncoder.encode(decodedImage, "UTF-8")

        navController.navigate("OneScreen/$encodedTitle/$encodedContent/$encodedImage") {
            popUpTo("OneScreen") { inclusive = true }
        }
    }

    LaunchedEffect(key1 = Unit) {
        listImages = if (decodedImage.isEmpty()) {
            emptyList()
        } else {
            decodedImage.split(",").filter { it.isNotBlank() && it.startsWith("content://") }
        }
    }
    LaunchedEffect(key1 = decodedTitle, key2 = decodedContent) {
        scope.launch {
            titleText.value = decodedTitle
            contentText.value = decodedContent
        }
    }
    fun onDelete(imageUri: String) {
        scope.launch {
            val uriToDelete = Uri.parse(imageUri)
            context.contentResolver.delete(uriToDelete, null, null)
            listImages = listImages.filter { it != imageUri }
            imagesString = listImages.joinToString(",")
            if (imagesString.isBlank()) {
                imagesString = R.drawable.baseline_add_photo_alternate_24.toString()
            }
            db.oneDao().updateImages(decodedTitle, imagesString)
        }
    }
    val cameraLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) { success ->
        if (success) {
            selectedImageUri?.let {
                bitmap = MediaStore.Images.Media.getBitmap(context.contentResolver, it)
                isImageCaptured = true
            }
        }
    }
    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            uri?.let { selectedImageUri = saveImageToFile(context, it) }
            isImageCaptured = true
        }
    )
    val legacyPhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            uri?.let { selectedImageUri = saveImageToFile(context, it) }
            isImageCaptured = true
        }
    )

    Column(modifier = Modifier
        .fillMaxSize()
        .systemBarsPadding()
        .background(colorResource(R.color.white))){
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)) {
            if(bigPhoto == null){
                if (listImages.isEmpty()) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_image_24),
                        contentDescription = "add_photo",
                        modifier = Modifier
                            .fillMaxSize()
                            .size(30.dp),
                    )
                } else {
                    AsyncImage(
                        model = ImageRequest.Builder(context)
                            .data(listImages.first())
                            .crossfade(true)
                            .build(),
                        contentDescription = "big_photo",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            } else {
                AsyncImage(
                    model = ImageRequest.Builder(context)
                        .data(bigPhoto)
                        .crossfade(true)
                        .build(),
                    contentDescription = "big_photo",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .padding(start = 4.dp, end = 4.dp)
            .background(colorResource(R.color.broun))){}
        Row(modifier  = Modifier
            .fillMaxWidth()
            .weight(1f)) {
            Column(modifier  = Modifier
                .fillMaxHeight()
                .weight(2f)) {
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier  = Modifier.fillMaxWidth()) {
                    Text(
                        text = titleText.value,
                        modifier = Modifier
                            .padding(start = 8.dp, end = 8.dp)
                            .wrapContentHeight()
                            .weight(1f),
                        textAlign = TextAlign.Start,
                        fontSize = 20.sp,
                        color = colorResource(id = R.color.broun),
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.imprisha))
                    )
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row() {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_edit_24),
                                contentDescription = "edit",
                                modifier = Modifier
                                    .size(30.dp)
                                    .padding(end = 8.dp)
                                    .clickable {
                                        scope.launch {
                                            val encodedTitle =
                                                URLEncoder.encode(decodedTitle, "UTF-8")
                                            val encodedContent =
                                                URLEncoder.encode(decodedContent, "UTF-8")
                                            val encodedImage =
                                                URLEncoder.encode(decodedImage, "UTF-8")
                                            navController.navigate("OneEditRecepiesScreen/$encodedTitle/$encodedContent/$encodedImage")
                                        }
                                    },
                                tint = colorResource(R.color.broun)
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_share),
                                contentDescription = "share_recepie",
                                modifier = Modifier.size(30.dp).padding(end = 8.dp).clickable {
                                        val maxLength = 1000
                                        val firstImageUri = if (listImages.isNotEmpty()) listImages[0] else null
                                        val text = "Рецепт: $decodedTitle\n\nСодержание: $decodedContent"
                                        if (text.length > maxLength) {
                                            scope.launch {
                                                val parts = text.chunked(maxLength)
                                                var inten : Intent? = null
                                                for (i in parts.indices.reversed()) {
                                                    if (i == 0 && firstImageUri != null) {
                                                        inten = Intent().apply {
                                                            action = Intent.ACTION_SEND
                                                            putExtra(Intent.EXTRA_TEXT, parts[i])
                                                            type = "text/plain"
                                                            putExtra(Intent.EXTRA_STREAM, Uri.parse(firstImageUri))
                                                            type = "*/*"
                                                            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                                                        }
                                                        context.startActivity(Intent.createChooser(inten, "Поделиться рецептом через..."))
                                                    } else {
                                                        delay(1000)
                                                        val nextShareIntent = Intent().apply {
                                                            action = Intent.ACTION_SEND
                                                            putExtra(Intent.EXTRA_TEXT, parts[i])
                                                            type = "text/plain"
                                                            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                                            inten?.component?.let { component ->
                                                                this.component = component
                                                            }
                                                        }
                                                        context.startActivity(Intent.createChooser(nextShareIntent, "Поделиться рецептом через..."))
                                                    }
                                                }
                                            }
                                        } else {
                                            val shareIntent = Intent().apply {
                                                action = Intent.ACTION_SEND
                                                putExtra(Intent.EXTRA_TEXT, text)
                                                type = "text/plain"
                                                if (firstImageUri != null) {
                                                    putExtra(Intent.EXTRA_STREAM, Uri.parse(firstImageUri))
                                                    type = "*/*"
                                                    addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                                                }
                                            }
                                            context.startActivity(Intent.createChooser(shareIntent, "Поделиться рецептом через..."))
                                        }
                                    },
                                tint = colorResource(R.color.broun)
                            )
                        }
                    }
                }
                Row(modifier = Modifier.fillMaxWidth().height(1.dp).padding(start = 4.dp, end = 4.dp)
                    .background(colorResource(R.color.broun))){}
                Box(modifier = Modifier.fillMaxHeight().weight(1f)) {
                    Text(
                        text = contentText.value,
                        modifier = Modifier
                            .padding(start = 8.dp, end = 8.dp)
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState()),
                        textAlign = TextAlign.Start,
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.broun),
                        fontFamily = FontFamily(Font(R.font.imprisha))
                    )
                }
            }
            Column(modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
                .padding(top = 4.dp, bottom = 4.dp)
                .background(colorResource(R.color.broun))){}
            Column(modifier  = Modifier
                .fillMaxHeight()
                .weight(1f)) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, bottom = 4.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_add_a_photo_24),
                        contentDescription = "camera",
                        modifier = Modifier
                            .size(27.dp)
                            .clickable {
                                scope.launch {
                                    val timeStamp: String = SimpleDateFormat(
                                        "yyyyMMdd_HHmmss",
                                        Locale.US
                                    ).format(Date())
                                    val storageDir: File = context.getExternalFilesDir(null)!!
                                    val photoFile = File.createTempFile(
                                        "JPEG_${timeStamp}_",
                                        ".jpg",
                                        storageDir
                                    )
                                    val uri = FileProvider.getUriForFile(
                                        context,
                                        "${context.packageName}.fileprovider",
                                        photoFile
                                    )
                                    selectedImageUri = uri
                                    cameraLauncher.launch(uri)
                                }
                            },
                        tint = colorResource(R.color.broun)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_add_photo_alternate_24),
                        contentDescription = "gallery",
                        modifier = Modifier
                            .size(30.dp)
                            .clickable {
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                                    photoPickerLauncher.launch(
                                        PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                                    )
                                } else {
                                    legacyPhotoPickerLauncher.launch("image/*")
                                }
                            },
                        tint = colorResource(R.color.broun)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.venik),
                        contentDescription = "delete_all_photos",
                        modifier = Modifier
                            .size(30.dp)
                            .clickable {
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
                                Text("Вы действительно хотите удалить все фото?",
                                    color = colorResource(id = R.color.broun)
                                )
                            },
                            confirmButton = {
                                Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                    containerColor = colorResource(id = R.color.broun)
                                ),
                                    onClick = {
                                        scope.launch {
                                            bigPhoto = null
                                            imagesString = R.drawable.baseline_add_photo_alternate_24.toString()
                                            listImages.forEach { imageUriString ->
                                                val imageUri = Uri.parse(imageUriString)
                                                context.contentResolver.delete(imageUri, null, null)
                                            }
                                            listImages = emptyList()
                                            db.oneDao().updateImages(decodedTitle, imagesString)
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

                LaunchedEffect(key1 = selectedImageUri, key2 = isImageCaptured) {
                    if(isImageCaptured){
                        selectedImageUri?.let { newUri ->
                            imagesString = if (imagesString.isEmpty()) {
                                newUri.toString()
                            } else {
                                "$imagesString,${newUri.toString()}"
                            }
                            scope.launch {
                                db.oneDao().updateImages(decodedTitle, imagesString)
                                listImages = imagesString.split(",")
                                    .filter { it.isNotBlank() && it.startsWith("content://") }
                            }
                        }
                    }
                   isImageCaptured = false
                }

                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(listImages.size) {item ->
                        androidx.compose.material.Card(
                            modifier = Modifier
                                .padding(top = 4.dp, start = 4.dp, end = 2.dp, bottom = 4.dp)
                                .fillMaxWidth()
                                .height(100.dp)
                                .background(Color.Transparent),
                            shape = CutCornerShape(bottomStart = 8.dp),
                            elevation = 5.dp,
                            onClick = {
                                bigPhoto = listImages[item].toUri()
                            }
                        ) {
                            Box(modifier = Modifier.fillMaxSize()) {
                                AsyncImage(
                                    model = ImageRequest.Builder(context)
                                            .data(listImages[item])
                                            .crossfade(true)
                                            .build(),
                                    contentDescription = "item_photo",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                                Box(
                                    modifier = Modifier
                                        .align(Alignment.BottomEnd)
                                        .padding(4.dp)
                                        .background(color = Color.White, shape = CircleShape)
                                        .padding(4.dp)
                                        .clickable {
                                            showDialog.value = true
                                            selectedItemIndex = item
                                        }
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.venik),
                                        contentDescription = "delete_image",
                                        modifier = Modifier.size(20.dp),
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
                                                Text("Вы действительно хотите удалить это фото?",
                                                    color = colorResource(id = R.color.broun)
                                                )
                                            },
                                            confirmButton = {
                                                Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                                    containerColor = colorResource(id = R.color.broun)
                                                ),
                                                    onClick = {
                                                        onDelete(listImages[selectedItemIndex])
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
}
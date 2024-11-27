package com.hulikan.cook.screens.thirtyfive

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.MotionEvent
import android.widget.VideoView
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
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.FileProvider
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.room.Room
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.hulikan.cook.FullscreenActivity
import com.hulikan.cook.R
import com.hulikan.cook.database.AppDatabase
import com.hulikan.cook.database.Favourites
import com.hulikan.cook.screens.one.saveImageToFile
import com.hulikan.cook.viewmodels.SharedViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.net.URLDecoder
import java.net.URLEncoder
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@SuppressLint("CoroutineCreationDuringComposition", "ClickableViewAccessibility", "RememberReturnType")
@Composable
fun ThirtyFiveRecepiesScreen(sharedViewModel: SharedViewModel, context : Context, navController: NavController, title : String, content : String, image : String){
    val scope = rememberCoroutineScope()
    val db = remember { Room.databaseBuilder(context, AppDatabase::class.java, "database").build() }
    var selectedImageUri by rememberSaveable { mutableStateOf<Uri?>(null) }
    val decodedTitle = try {
        URLDecoder.decode(title, "UTF-8").replace("+", " ")
    } catch (e: IllegalArgumentException) {
        title.replace("+", " ")
    }
    val decodedContent = try {
        URLDecoder.decode(content, "UTF-8").replace("+", " ")
    } catch (e: IllegalArgumentException) {
        content.replace("+", " ")
    }
    var decodedImage = URLDecoder.decode(image, "UTF-8")
    var imagesString by rememberSaveable { mutableStateOf(decodedImage) }
    var listImages = remember { mutableStateListOf<String>() }
    val showDialog = remember { mutableStateOf(false) }
    val showDialogTwo = remember { mutableStateOf(false) }
    val showDialogThree = remember { mutableStateOf(false) }
    val showDialogFour = remember { mutableStateOf(false) }
    var selectedItemIndex by remember { mutableStateOf(0) }
    var selectedItem by remember { mutableStateOf<String?>(null) }
    val titleText = rememberSaveable { mutableStateOf("") }
    val contentText = rememberSaveable { mutableStateOf("") }
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed))
    var videosString by remember { mutableStateOf("") }
    var listVideos by remember { mutableStateOf<List<String>>(emptyList()) }
    var currentVideoUri by remember { mutableStateOf<String?>(null) }
    var videoCount by remember { mutableStateOf(0) }
    var selectedVideoUri by remember { mutableStateOf<Uri?>(null) }
    var isVideoCaptured by remember { mutableStateOf(false) }
    var bigPhoto by rememberSaveable { mutableStateOf<Any>(R.drawable.baseline_image_24) }
    var mediaPlayer: MediaPlayer? by remember { mutableStateOf(null) }

    fun releaseMediaPlayer(mediaPlayer: MediaPlayer?) {
        try {
            mediaPlayer?.apply {
                reset()
                release()
            }
        } catch (e: IllegalStateException) {
            Log.e("TAG", "Error releasing media player: ${e.message}")
        }
    }
    LaunchedEffect(Unit) {
        scope.launch {
            val imageString = db.thirtyFiveDao().getImages(decodedTitle)
            val newImages = imageString?.split(",")?.filter { it.isNotBlank() } ?: emptyList()
            withContext(Dispatchers.Main) {
                listImages.clear()
                listImages.addAll(newImages)
                bigPhoto = if (listImages.isNotEmpty() && listImages.none { it.contains("content://") }) {
                    R.drawable.baseline_image_24
                } else {
                    listImages.firstOrNull { it.startsWith("content://") }?.toUri() ?: Uri.EMPTY
                }
            }
        }
    }
    LaunchedEffect(key1 = decodedTitle) {
        scope.launch {
            videoCount = db.thirtyFiveDao().getVideoCountByTitle(decodedTitle)
        }
    }
    LaunchedEffect(key1 = videoCount) {
        scope.launch {
            videosString = db.thirtyFiveDao().getVideosByTitle(decodedTitle) ?: ""
            withContext(Dispatchers.Main) {
                listVideos = videosString.split(",").filter { it.isNotBlank() && it.startsWith("content://") }
            }
        }
    }
    LaunchedEffect(key1 = Unit) {
        listImages.clear()
        val imageString = db.thirtyFiveDao().getImages(decodedTitle)
        val newImages = imageString?.split(",")?.filter { it.isNotBlank() } ?: emptyList()
        listImages.addAll(newImages)
    }
    BackHandler {
        releaseMediaPlayer(mediaPlayer)
        mediaPlayer = null

        val encodedTitle = URLEncoder.encode(titleText.value, "UTF-8")
        val encodedContent = URLEncoder.encode(contentText.value, "UTF-8")
        val encodedImage = URLEncoder.encode(decodedImage, "UTF-8")
        navController.navigate("ThirtyFiveScreen/$encodedTitle/$encodedContent/$encodedImage") {
            popUpTo("ThirtyFiveScreen") { inclusive = true }
        }
    }
    LaunchedEffect(key1 = decodedTitle, key2 = decodedContent) {
        scope.launch {
            titleText.value = decodedTitle
            contentText.value = decodedContent
        }
    }
    fun updateDatabaseWithImages(title: String, images: List<String>) {
        val distinctImages = images.distinct()
        val imagessString = distinctImages.joinToString(",")
        scope.launch {
            db.thirtyFiveDao().clearImages(decodedTitle)
            db.thirtyFiveDao().updateImages(decodedTitle, imagessString)
        }
    }
    fun onDelete(imageUri: String) {
        scope.launch {
            val uriToDelete = Uri.parse(imageUri)
            context.contentResolver.delete(uriToDelete, null, null)
            listImages.remove(imageUri)
            imagesString = listImages.joinToString(",")
            if (imagesString.isBlank()) {
                imagesString = R.drawable.baseline_add_photo_alternate_24.toString()
            }
            db.thirtyFiveDao().updateImages(decodedTitle, imagesString)
            withContext(Dispatchers.IO) {
                updateDatabaseWithImages(decodedTitle, listImages)
            }
        }
    }
    val cameraLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) { success ->
        if (success) {
            selectedImageUri?.let { uri ->
                scope.launch {
                    val savedUri = saveImageToFile(context, uri)
                    listImages.add(savedUri.toString())
                    db.thirtyFiveDao().appendImage(decodedTitle, savedUri.toString())
                    updateDatabaseWithImages(decodedTitle, listImages)
                }
            }
        }
    }
    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            uri?.let { originalUri ->
                scope.launch {
                    val savedUri = saveImageToFile(context, originalUri)
                    listImages.add(savedUri.toString())
                    db.thirtyFiveDao().appendImage(decodedTitle, savedUri.toString())
                    updateDatabaseWithImages(decodedTitle, listImages)
                }
            }
        }
    )
    val legacyPhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            uri?.let { originalUri ->
                scope.launch {
                    val savedUri = saveImageToFile(context, originalUri)
                    listImages.add(savedUri.toString())
                    db.thirtyFiveDao().appendImage(decodedTitle, savedUri.toString())
                    updateDatabaseWithImages(decodedTitle, listImages)
                }
            }
        }
    )
    val videoPickerLauncherNew = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            uri?.let { originalUri ->
                scope.launch {
                    val savedUri = saveVideoToFile(context, originalUri)
                    videosString = if (videosString.isEmpty()) {
                        savedUri.toString()
                    } else {
                        "$videosString,${savedUri.toString()}"
                    }
                    db.thirtyFiveDao().appendVideo(decodedTitle, savedUri.toString())
                    videoCount++
                    selectedVideoUri = savedUri
                    isVideoCaptured = true
                }
            }
        }
    )
    val videoPickerLauncherOld = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            uri?.let { originalUri ->
                scope.launch {
                    val savedUri = saveVideoToFile(context, originalUri)
                    videosString = if (videosString.isEmpty()) {
                        savedUri.toString()
                    } else {
                        "$videosString,${savedUri.toString()}"
                    }
                    db.thirtyFiveDao().appendVideo(decodedTitle, savedUri.toString())
                    videoCount++
                    selectedVideoUri = savedUri
                    isVideoCaptured = true
                }
            }
        }
    )
    val videoCaptureLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
        onResult = { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                result.data?.data?.let { uri ->
                    scope.launch {
                        val savedUri = saveVideoToFile(context, uri)
                        videosString = if (videosString.isEmpty()) {
                            savedUri.toString()
                        } else {
                            "$videosString,${savedUri.toString()}"
                        }
                        db.thirtyFiveDao().appendVideo(decodedTitle, savedUri.toString())
                        videoCount++
                        selectedVideoUri = savedUri
                        isVideoCaptured = true
                    }
                }
            }
        }
    )
    BottomSheetScaffold(
        modifier = Modifier
            .systemBarsPadding()
            .background(Color.Yellow),
        scaffoldState = bottomSheetScaffoldState,
        sheetPeekHeight = 28.dp,
        sheetGesturesEnabled = true,
        sheetShape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
        sheetContent = {
            val sheetState = bottomSheetScaffoldState.bottomSheetState
            Column(modifier = Modifier
                .fillMaxWidth()
                .height(600.dp)
                .background(colorResource(R.color.lightbroun)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val text = if (sheetState.isExpanded) {
                    stringResource(R.string.onerec_down_close)
                } else {
                    stringResource(R.string.onerec_up_open)
                }
                Text(text = text,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.broun),
                    fontFamily = FontFamily(Font(R.font.imprisha))
                )
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 8.dp, end = 8.dp)
                        .wrapContentHeight()
                        .background(Color.Transparent),
                    shape = RoundedCornerShape(8.dp)
                ){
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .weight(1f)
                                .clickable {
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                                        videoPickerLauncherNew.launch(
                                            PickVisualMediaRequest(
                                                ActivityResultContracts.PickVisualMedia.VideoOnly
                                            )
                                        )
                                    } else {
                                        videoPickerLauncherOld.launch("video/*")
                                    }
                                })
                        {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_video_library),
                                contentDescription = "add_video_from_gallery",
                                modifier = Modifier.size(35.dp),
                                tint = colorResource(R.color.broun)
                            )
                            Text(text = stringResource(R.string.onerec_video_from_gallery),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 4.dp, bottom = 4.dp),
                                textAlign = TextAlign.Center,
                                fontSize = 11.sp,
                                color = colorResource(id = R.color.broun),
                                fontFamily = FontFamily(Font(R.font.imprisha))
                            )
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .weight(1f)
                                .clickable {
                                    val intent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
                                    videoCaptureLauncher.launch(intent)
                                })
                        {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_videocamera),
                                contentDescription = "add_video_from_camera",
                                modifier = Modifier.size(39.dp),
                                tint = colorResource(R.color.broun)
                            )
                            Text(text = stringResource(R.string.onerec_video_from_camera),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 4.dp),
                                textAlign = TextAlign.Center,
                                fontSize = 11.sp,
                                color = colorResource(id = R.color.broun),
                                fontFamily = FontFamily(Font(R.font.imprisha))
                            )
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .weight(1f)
                                .clickable {
                                    showDialogThree.value = true
                                })
                        {
                            Icon(
                                painter = painterResource(id = R.drawable.venik),
                                contentDescription = "delete all videos",
                                modifier = Modifier.size(35.dp),
                                tint = colorResource(R.color.broun)
                            )
                            Text(text = stringResource(R.string.onerec_delete_all_videos),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 4.dp, bottom = 4.dp),
                                textAlign = TextAlign.Center,
                                fontSize = 11.sp,
                                color = colorResource(id = R.color.broun),
                                fontFamily = FontFamily(Font(R.font.imprisha))
                            )
                        }
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
                                        stringResource(R.string.alert_delete_all_videos),
                                        color = colorResource(id = R.color.broun)
                                    )
                                },
                                confirmButton = {
                                    Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                        containerColor = colorResource(id = R.color.broun)
                                    ),
                                        onClick = {
                                            scope.launch {
                                                val videoUris = videosString.split(",").filter { it.isNotBlank() && it.startsWith("content://") }
                                                videoUris.forEach { uriString ->
                                                    val uri = Uri.parse(uriString)
                                                    val file = uri.path?.let { File(it) }
                                                    if (file != null) {
                                                        if (file.exists()) {
                                                            file.delete()
                                                        }
                                                    }
                                                    try {
                                                        context.contentResolver.delete(uri, null, null)
                                                    } catch (e: SecurityException) {
                                                        Log.e("TAG", "Error deleting video file: ${e.message}")
                                                    }
                                                }
                                                videosString = ""
                                                db.thirtyFiveDao().updateVideos(decodedTitle, videosString)
                                                withContext(Dispatchers.Main) {
                                                    listVideos = emptyList()
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
                LazyColumn(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(top = 4.dp, bottom = 8.dp)){
                    itemsIndexed(items = listVideos) { index, item ->
                        VideoPlayer(videoUri = item)
                        Card(modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 4.dp, start = 8.dp, end = 8.dp)
                            .height(350.dp)
                            .background(Color.Transparent),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            fun createThumbnailForVideo(videoUri: Uri): String? {
                                try {
                                    val thumbnailFile = File(context.cacheDir, "thumbnail_${videoUri.hashCode()}.jpg")
                                    Glide.with(context)
                                        .asBitmap()
                                        .load(videoUri)
                                        .frame(1000)
                                        .into(object : CustomTarget<Bitmap>() {
                                            override fun onResourceReady(
                                                resource: Bitmap,
                                                transition: com.bumptech.glide.request.transition.Transition<in Bitmap>?
                                            ) {
                                                val byteArray = resource.toByteArray()
                                                FileOutputStream(thumbnailFile).use { it.write(byteArray) }
                                            }
                                            override fun onLoadCleared(placeholder: Drawable?) {}
                                        })
                                    return thumbnailFile.toURI().toString()
                                } catch (e: Exception) {
                                    Log.e("TAG", "Error creating thumbnail: ${e.message}")
                                }
                                return null
                            }
                            Column(modifier = Modifier
                                .fillMaxSize()
                                .background(colorResource(R.color.white)),
                                horizontalAlignment = Alignment.CenterHorizontally) {

                                var isPlaying by remember { mutableStateOf(false) }
                                var videoDuration by remember { mutableStateOf(0) }
                                var videoPosition by remember { mutableStateOf(0) }
                                var isSeeking by remember { mutableStateOf(false) }
                                var newPosition by remember { mutableStateOf(0) }
                                val thumbnailUri = remember(item) { createThumbnailForVideo(Uri.parse(item)) }
                                LaunchedEffect(key1 = isPlaying) {
                                    try {
                                        while (isPlaying && mediaPlayer != null && mediaPlayer?.isPlaying == true) {
                                            videoPosition = mediaPlayer!!.currentPosition
                                            delay(1000)
                                        }
                                    } catch (e: Exception) {
                                        Log.e("TAG", "Error in  LaunchedEffect: ${e.message}")
                                    }
                                }
                                LaunchedEffect(key1 = currentVideoUri) {
                                    if (currentVideoUri != null) {
                                        mediaPlayer?.reset()
                                        mediaPlayer?.setDataSource(context, Uri.parse(currentVideoUri))
                                        mediaPlayer?.prepareAsync()
                                    } else {
                                        releaseMediaPlayer(mediaPlayer)
                                        mediaPlayer = null
                                    }
                                }
                                key(item) {
                                    Box(modifier = Modifier
                                        .fillMaxWidth()
                                        .weight(1f)) {
                                        AndroidView(
                                            factory = { context ->
                                                VideoView(context).apply {
                                                    requestFocus()
                                                    setOnTouchListener { v, event ->
                                                        when (event.action) {
                                                            MotionEvent.ACTION_DOWN -> {
                                                                isSeeking = true
                                                                try {
                                                                    if (mediaPlayer?.isPlaying == true) {
                                                                        mediaPlayer?.pause()
                                                                    }
                                                                } catch (e: IllegalStateException) {
                                                                    Log.e(
                                                                        "VideoView",
                                                                        "Error pausing video: ${e.message}"
                                                                    )
                                                                }
                                                            }

                                                            MotionEvent.ACTION_MOVE -> {
                                                                if (isSeeking) {
                                                                    newPosition =
                                                                        (event.x / v.width * videoDuration).toInt()
                                                                    newPosition =
                                                                        newPosition.coerceIn(
                                                                            0,
                                                                            videoDuration
                                                                        )
                                                                    try {
                                                                        if (mediaPlayer != null && mediaPlayer?.isPlaying == true) {
                                                                            mediaPlayer?.seekTo(
                                                                                newPosition
                                                                            )
                                                                        }
                                                                    } catch (e: IllegalStateException) {
                                                                        Log.e(
                                                                            "VideoView",
                                                                            "Error seeking video: ${e.message}"
                                                                        )
                                                                    }
                                                                }
                                                            }

                                                            MotionEvent.ACTION_UP -> {
                                                                isSeeking = false
                                                                try {
                                                                    if (isPlaying && mediaPlayer != null && mediaPlayer?.isPlaying == false) {
                                                                        mediaPlayer?.start()
                                                                    }
                                                                } catch (e: IllegalStateException) {
                                                                    Log.e(
                                                                        "VideoView",
                                                                        "Error starting video: ${e.message}"
                                                                    )
                                                                }
                                                            }
                                                        }
                                                        true
                                                    }
                                                    mediaPlayer?.let {
                                                        sharedViewModel.setMediaPlayer(it)
                                                    }
                                                }
                                            },
                                            update = { view ->
                                                view.setVideoURI(Uri.parse(item))
                                                view.setOnPreparedListener { player ->
                                                    mediaPlayer = player
                                                    videoDuration = player.duration
                                                    isPlaying = false
                                                }
                                            },
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .fillMaxHeight()
                                                .onReady {
                                                    try {
                                                        if (mediaPlayer != null && mediaPlayer?.isPlaying == true) {
                                                            mediaPlayer?.start()
                                                        }
                                                    } catch (e: IllegalStateException) {
                                                        Log.e(
                                                            "VideoView",
                                                            "Error starting video in onReady: ${e.message}"
                                                        )
                                                    }
                                                }
                                        )
                                        AsyncImage(
                                            model = thumbnailUri,
                                            contentDescription = "Video Thumbnail",
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .aspectRatio(16f / 10f)
                                                .alpha(if (!isPlaying && videoPosition == 0) 1f else 0f)
                                        )
                                    }
                                }
                                Slider(
                                    value = videoPosition.toFloat(),
                                    onValueChange = {
                                        try {
                                            if (mediaPlayer != null && mediaPlayer?.isPlaying == true) {
                                                videoPosition = it.toInt()
                                                mediaPlayer?.seekTo(videoPosition)
                                            }
                                        } catch (e: IllegalStateException) {
                                            Log.e("VideoView", "Error seeking video: ${e.message}")
                                        }
                                    },
                                    valueRange = 0f..videoDuration.toFloat(),
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = SliderColors(
                                        thumbColor = Color.Red,
                                        activeTrackColor = Color.Red,
                                        inactiveTrackColor = Color.LightGray,
                                        activeTickColor = Color.Red,
                                        disabledActiveTickColor = Color.Gray,
                                        disabledActiveTrackColor = Color.Gray,
                                        disabledInactiveTickColor = Color.LightGray,
                                        disabledInactiveTrackColor = Color.LightGray,
                                        disabledThumbColor = Color.Gray,
                                        inactiveTickColor = Color.LightGray
                                    )
                                )
                                fun formatTime(timeInMillis: Int): String {
                                    val totalSeconds = timeInMillis / 1000
                                    val seconds = totalSeconds % 60
                                    val minutes = (totalSeconds / 60) % 60
                                    val hours = totalSeconds / 3600
                                    return String.format("%02d:%02d:%02d", hours, minutes, seconds)
                                }
                                Row( modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .background(colorResource(R.color.white)),
                                    horizontalArrangement = Arrangement.SpaceAround,
                                    verticalAlignment = Alignment.CenterVertically) {
                                    Icon(painter = painterResource(R.drawable.baseline_fullscreen),
                                        contentDescription = "go_to_full_screen",
                                        modifier = Modifier
                                            .size(30.dp)
                                            .padding(start = 8.dp)
                                            .clickable {
                                                val intent = Intent(
                                                    context,
                                                    FullscreenActivity::class.java
                                                ).apply {
                                                    putExtra("videoUri", item.toString())
                                                }
                                                context.startActivity(intent)
                                            }
                                    )
                                    Text(
                                        text = formatTime(videoPosition) + " / " + formatTime(videoDuration),
                                        modifier = Modifier.weight(0.7f),
                                        textAlign = TextAlign.Center
                                    )
                                    Icon(painter = if (isPlaying) painterResource(R.drawable.baseline_video_pause)
                                    else painterResource(R.drawable.baseline_video_play),
                                        contentDescription = if (isPlaying) "Pause" else "Play",
                                        modifier = Modifier
                                            .size(30.dp)
                                            .padding(end = 4.dp)
                                            .clickable {
                                                isPlaying = !isPlaying
                                                if (isPlaying) {
                                                    mediaPlayer?.start()
                                                } else {
                                                    mediaPlayer?.pause()
                                                }
                                            }
                                    )
                                    Icon(painter = painterResource(R.drawable.baseline_video_stop), contentDescription = "Stop",
                                        modifier = Modifier
                                            .size(35.dp)
                                            .clickable {
                                                isPlaying = false
                                                mediaPlayer?.pause()
                                                mediaPlayer?.seekTo(0)
                                                videoPosition = 0
                                                releaseMediaPlayer(mediaPlayer)
                                            })
                                    Icon(
                                        painter = painterResource(id = R.drawable.venik),
                                        contentDescription = "delete_item_video",
                                        modifier = Modifier
                                            .size(30.dp)
                                            .padding(end = 8.dp)
                                            .clickable {
                                                showDialogFour.value = true
                                                selectedItem = item
                                            },
                                        tint = colorResource(R.color.black)
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
                                                    stringResource(R.string.alert_delete_video),
                                                    color = colorResource(id = R.color.broun)
                                                )
                                            },
                                            confirmButton = {
                                                Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                                    containerColor = colorResource(id = R.color.broun)
                                                ),
                                                    onClick = {
                                                        scope.launch {
                                                            val videoUriToDelete = Uri.parse(selectedItem)
                                                            try {
                                                                context.contentResolver.delete(videoUriToDelete, null, null)
                                                                Log.d("TAG", "Deleted video URI: $videoUriToDelete")
                                                            } catch (e: SecurityException) {
                                                                Log.e("TAG", "Error deleting video file: ${e.message}")
                                                            }
                                                            val updatedList = videosString.split(",").filter { it != selectedItem }
                                                            videosString = updatedList.joinToString(",")
                                                            db.thirtyFiveDao().updateVideos(decodedTitle, videosString)
                                                            withContext(Dispatchers.Main) {
                                                                listVideos = listVideos.filter { it != selectedItem }
                                                                if (currentVideoUri == selectedItem) {
                                                                    currentVideoUri = null
                                                                }
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
                        }
                    }
                }
            }
        },
    ) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(innerPadding)) {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(colorResource(R.color.white))){
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)) {
                    if(bigPhoto == null){
                        Image(painter = painterResource(id = R.drawable.baseline_image_24),
                            contentDescription = "add_photo",
                            modifier = Modifier
                                .fillMaxSize()
                                .size(30.dp),)
                    } else {
                        AsyncImage(model = ImageRequest.Builder(context)
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
                            Text(text = titleText.value,
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
                                    Icon(painter = painterResource(id = R.drawable.baseline_edit_24),
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
                                                    navController.navigate("ThirtyFiveEditRecepiesScreen/$encodedTitle/$encodedContent/$encodedImage")
                                                }
                                            },
                                        tint = colorResource(R.color.broun)
                                    )
                                    var tints by remember { mutableStateOf(false) }

                                    LaunchedEffect(key1 = decodedTitle) {
                                        tints = db.favouritesDao().isFavourite(decodedTitle, "ThirtyFiveRecepiesScreen")
                                    }
                                    Icon(
                                        painter = painterResource(id = if (tints) R.drawable.baseline_favorite_red
                                        else R.drawable.baseline_favorite_border),
                                        contentDescription = "favourite",
                                        modifier = Modifier
                                            .size(32.dp)
                                            .padding(end = 8.dp)
                                            .clickable {
                                                scope.launch {
                                                    if (tints) {
                                                        db
                                                            .favouritesDao()
                                                            .deleteFavourite(
                                                                decodedTitle,
                                                                "ThirtyFiveRecepiesScreen"
                                                            )
                                                    } else {
                                                        db
                                                            .favouritesDao()
                                                            .insertFavourites(
                                                                Favourites(
                                                                    title = decodedTitle,
                                                                    content = decodedContent,
                                                                    images = decodedImage,
                                                                    favouriteskey = "ThirtyFiveRecepiesScreen"
                                                                )
                                                            )
                                                    }
                                                    tints = !tints
                                                }
                                            },
                                        tint = Color.Unspecified
                                    )
                                    Icon(painter = painterResource(id = R.drawable.baseline_share),
                                        contentDescription = "share_recepie",
                                        modifier = Modifier
                                            .size(30.dp)
                                            .padding(end = 8.dp)
                                            .clickable {
                                                val maxLength = 1000
                                                val firstImageUri =
                                                    if (listImages.isNotEmpty()) listImages[0] else null
                                                val text =
                                                    "Recepie: $decodedTitle\n\nContent: $decodedContent"
                                                if (text.length > maxLength) {
                                                    scope.launch {
                                                        val parts = text.chunked(maxLength)
                                                        var inten: Intent? = null
                                                        for (i in parts.indices.reversed()) {
                                                            if (i == 0 && firstImageUri != null) {
                                                                inten = Intent().apply {
                                                                    action = Intent.ACTION_SEND
                                                                    putExtra(
                                                                        Intent.EXTRA_TEXT,
                                                                        parts[i]
                                                                    )
                                                                    type = "text/plain"
                                                                    putExtra(
                                                                        Intent.EXTRA_STREAM,
                                                                        Uri.parse(firstImageUri)
                                                                    )
                                                                    type = "*/*"
                                                                    addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                                                                }
                                                                context.startActivity(
                                                                    Intent.createChooser(
                                                                        inten,
                                                                        context.getString(R.string.onerec_share_recepie_via)
                                                                    )
                                                                )
                                                            } else {
                                                                delay(1000)
                                                                val nextShareIntent =
                                                                    Intent().apply {
                                                                        action =
                                                                            Intent.ACTION_SEND
                                                                        putExtra(
                                                                            Intent.EXTRA_TEXT,
                                                                            parts[i]
                                                                        )
                                                                        type = "text/plain"
                                                                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                                                        inten?.component?.let { component ->
                                                                            this.component =
                                                                                component
                                                                        }
                                                                    }
                                                                context.startActivity(
                                                                    Intent.createChooser(
                                                                        nextShareIntent,
                                                                        context.getString(R.string.onerec_share_recepie_via)
                                                                    )
                                                                )
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    val shareIntent = Intent().apply {
                                                        action = Intent.ACTION_SEND
                                                        putExtra(Intent.EXTRA_TEXT, text)
                                                        type = "text/plain"
                                                        if (firstImageUri != null) {
                                                            putExtra(
                                                                Intent.EXTRA_STREAM,
                                                                Uri.parse(firstImageUri)
                                                            )
                                                            type = "*/*"
                                                            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                                                        }
                                                    }
                                                    context.startActivity(
                                                        Intent.createChooser(
                                                            shareIntent,
                                                            context.getString(R.string.onerec_share_recepie_via)
                                                        )
                                                    )
                                                }
                                            },
                                        tint = colorResource(R.color.broun)
                                    )
                                }
                            }
                        }
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .padding(start = 4.dp, end = 4.dp)
                            .background(colorResource(R.color.broun))){}
                        Box(modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)) {
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
                                            val storageDir: File =
                                                context.getExternalFilesDir(null)!!
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
                            Icon(painter = painterResource(id = R.drawable.baseline_add_photo_alternate_24),
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
                            Icon(painter = painterResource(id = R.drawable.venik),
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
                                    title = { Text(stringResource(R.string.alert_confirm), color = colorResource(id = R.color.broun),
                                        fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                                    text = {
                                        Text(
                                            stringResource(R.string.alert_delete_all_photo),
                                            color = colorResource(id = R.color.broun)
                                        )
                                    },
                                    confirmButton = {
                                        Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                            containerColor = colorResource(id = R.color.broun)
                                        ),
                                            onClick = {
                                                scope.launch {
                                                    imagesString = R.drawable.baseline_add_photo_alternate_24.toString()
                                                    listImages.forEach { imageUriString ->
                                                        if (imageUriString.startsWith("content://")) {
                                                            val imageUri = Uri.parse(imageUriString)
                                                            try {
                                                                context.contentResolver.delete(imageUri, null, null)
                                                            } catch (e: SecurityException) {
                                                                Log.e("TAG", "Error deleting video file: ${e.message}")
                                                            }
                                                        } else {
                                                            Log.d("TAG", "Skipping deletion for resource ID: $imageUriString")
                                                        }
                                                    }
                                                    listImages = mutableStateListOf()
                                                    db.thirtyFiveDao().updateImages(decodedTitle, imagesString)
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
                        LazyColumn(modifier = Modifier.fillMaxSize()) {
                            itemsIndexed(listImages) {index, item ->
                                if (item.isNotBlank() && item != R.drawable.baseline_add_photo_alternate_24.toString()) {
                                    Card(
                                        modifier = Modifier
                                            .padding(
                                                top = 4.dp,
                                                start = 4.dp,
                                                end = 2.dp,
                                                bottom = 4.dp
                                            )
                                            .fillMaxWidth()
                                            .height(100.dp)
                                            .background(Color.Transparent),
                                        shape = CutCornerShape(bottomStart = 8.dp),
                                        elevation = 5.dp,
                                        onClick = {
                                            bigPhoto = item.toUri()
                                        }
                                    ) {
                                        Box(modifier = Modifier.fillMaxSize()) {
                                            AsyncImage(
                                                model = ImageRequest.Builder(context)
                                                    .data(item)
                                                    .crossfade(true).build(),
                                                contentDescription = "item_photo",
                                                modifier = Modifier.fillMaxSize(),
                                                contentScale = ContentScale.Crop
                                            )
                                            Box(
                                                modifier = Modifier
                                                    .align(Alignment.BottomEnd)
                                                    .padding(4.dp)
                                                    .background(
                                                        color = Color.White, shape = CircleShape
                                                    )
                                                    .padding(4.dp)
                                                    .clickable {
                                                        showDialog.value = true
                                                        selectedItemIndex = listImages.indexOf(item)
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
                                                        title = { Text(stringResource(R.string.alert_confirm), color = colorResource(id = R.color.broun),
                                                            fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                                                        text = {
                                                            Text(
                                                                stringResource(R.string.alert_delete_photo),
                                                                color = colorResource(id = R.color.broun)
                                                            )
                                                        },
                                                        confirmButton = {
                                                            Button(colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                                                containerColor = colorResource(id = R.color.broun)
                                                            ),
                                                                onClick = {
                                                                    if (selectedItemIndex in 0 until listImages.size) {
                                                                        onDelete(listImages[selectedItemIndex])
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
            Card(modifier = Modifier.fillMaxWidth(), onClick = {
                scope.launch {
                    if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                        bottomSheetScaffoldState.bottomSheetState.expand()
                    } else {
                        bottomSheetScaffoldState.bottomSheetState.collapse()
                    }
                }
            }) {}
        }
    }

}

fun saveVideoToFile(context: Context, uri: Uri): Uri {
    val inputStream = context.contentResolver.openInputStream(uri)
    val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())
    val storageDir: File? = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES)
    if (!storageDir?.exists()!!) {
        storageDir.mkdirs()
    }
    val videoFile = File(storageDir, "VIDEO_${timeStamp}.mp4")
    if (!videoFile.exists()) {
        val outputStream = FileOutputStream(videoFile)
        inputStream?.copyTo(outputStream)
        inputStream?.close()
        outputStream.close()
    }
    return FileProvider.getUriForFile(context, "${context.packageName}.fileprovider", videoFile)
}
@Composable
fun VideoPlayer(videoUri: String) {
    var mediaPlayer: MediaPlayer? by remember { mutableStateOf(null) }
    val context = LocalContext.current
    LaunchedEffect(key1 = videoUri) {
        mediaPlayer = MediaPlayer().apply {
            try {
                setDataSource(context, Uri.parse(videoUri))
                prepareAsync()
            } catch (e: Exception) {
                Log.e("VideoPlayer", "Error initialized MediaPlayer: ${e.message}")
            }
        }
    }
}
fun Modifier.onReady(onReady: () -> Unit): Modifier = composed {
    var isReady by remember { mutableStateOf(false) }
    DisposableEffect(key1 = isReady) {
        if (!isReady) {
            onReady()
            isReady = true
        }
        onDispose {  }
    }
    this
}
fun Bitmap.toByteArray(): ByteArray {
    val stream = com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.output.ByteArrayOutputStream()
    compress(Bitmap.CompressFormat.JPEG, 100, stream)
    return stream.toByteArray()
}
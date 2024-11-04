package com.hulikan.cook.screens.eleven

import android.Manifest
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.widget.Toast
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
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.FileProvider
import androidx.navigation.NavController
import androidx.room.Room
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.hulikan.cook.R
import com.hulikan.cook.database.AppDatabase
import com.hulikan.cook.database.Eleven
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.net.URLEncoder
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun NewElevenRecepiesScreen(context : Context, navController: NavController){
    val scope = rememberCoroutineScope()
    val db = remember { Room.databaseBuilder(context, AppDatabase::class.java, "database").build() }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val titleText = rememberSaveable { mutableStateOf("") }
    val contentText = rememberSaveable { mutableStateOf("") }
    var selectedImageUri by rememberSaveable { mutableStateOf<Uri?>(null) }
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }


    val cameraLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) { success ->
        if (success) {
            selectedImageUri?.let {
                bitmap = MediaStore.Images.Media.getBitmap(context.contentResolver, it)
            }
        }
    }
    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            uri?.let { selectedImageUri = saveImageToFile(context, it) }
        }
    )
    val legacyPhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            uri?.let { selectedImageUri = saveImageToFile(context, it) }
        }
    )
    val permissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        arrayOf(
            Manifest.permission.READ_MEDIA_IMAGES,
            Manifest.permission.CAMERA
        )
    } else {
        arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
        )
    }
    val permissionState = rememberMultiplePermissionsState(permissions.toList())

    LaunchedEffect(Unit) {
        permissionState.launchMultiplePermissionRequest()
    }

    if (permissionState.allPermissionsGranted) {
        ProvideWindowInsets {
            Column(modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
                .navigationBarsWithImePadding()
                .background(
                    colorResource(R.color.white)
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp, bottom = 4.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_save_24),
                        contentDescription = "save",
                        modifier = Modifier
                            .size(30.dp)
                            .padding(end = 4.dp)
                            .clickable {
                                if (titleText.value.isNullOrBlank() && contentText.value.isNullOrBlank()) {
                                    Toast
                                        .makeText(
                                            context,
                                            context.getString(R.string.toast_full_empty_fields),
                                            Toast.LENGTH_SHORT
                                        )
                                        .show()
                                } else {
                                    scope.launch {
                                        val title = titleText.value
                                        val content = contentText.value
                                        val images = selectedImageUri?.toString()
                                            ?: R.drawable.baseline_add_photo_alternate_24.toString()

                                        db
                                            .elevenDao()
                                            .insertEleven(
                                                Eleven(
                                                    title = title,
                                                    content = content,
                                                    images = images,
                                                    videos = ""
                                                )
                                            )

                                        val encodedTitle = URLEncoder.encode(title.ifEmpty { "empty" }, "UTF-8")
                                        val encodedContent = URLEncoder.encode(content.ifEmpty { "empty" }, "UTF-8")
                                        val encodedImageUri = if (selectedImageUri != null) {
                                            URLEncoder.encode(selectedImageUri.toString(), "UTF-8")
                                        } else {
                                            URLEncoder.encode(
                                                R.drawable.baseline_add_photo_alternate_24.toString(),
                                                "UTF-8"
                                            )
                                        }
                                        navController.navigate("ElevenScreen/$encodedTitle/$encodedContent/$encodedImageUri")
                                    }
                                }
                            },
                        tint = colorResource(R.color.broun)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_add_a_photo_24),
                        contentDescription = "camera",
                        modifier = Modifier
                            .size(27.dp)
                            .clickable {
                                scope.launch {
                                    val timeStamp: String =
                                        SimpleDateFormat(
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
                                scope.launch {
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                                        photoPickerLauncher.launch(
                                            PickVisualMediaRequest(
                                                ActivityResultContracts.PickVisualMedia.ImageOnly
                                            )
                                        )
                                    } else {
                                        legacyPhotoPickerLauncher.launch("image/*")
                                    }
                                }
                            },
                        tint = colorResource(R.color.broun)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.venik),
                        contentDescription = "clear_big_photo",
                        modifier = Modifier
                            .size(30.dp)
                            .clickable {
                                selectedImageUri = null
                                bitmap = null
                            },
                        tint = colorResource(R.color.broun)
                    )
                }
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)) {
                    Row(modifier = Modifier.fillMaxSize()) {
                        bitmap?.let {
                            val highQualityBitmap = it.copy(Bitmap.Config.ARGB_8888, true)
                            highQualityBitmap.prepareToDraw()
                            Image(
                                bitmap = highQualityBitmap?.asImageBitmap()!!,
                                contentDescription = "cameraBitmap",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        }
                        selectedImageUri?.let { uri ->
                            AsyncImage(
                                model = ImageRequest.Builder(context)
                                    .data(uri)
                                    .crossfade(true)
                                    .build(),
                                contentDescription = "item_photo",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        } ?: run {
                            Image(
                                painter = painterResource(id = R.drawable.baseline_add_photo_alternate_24),
                                contentDescription = "newphoto",
                                Modifier
                                    .fillMaxSize()
                                    .background(colorResource(R.color.white))
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .padding(start = 4.dp, end = 4.dp)
                        .background(colorResource(R.color.broun))
                ) {}
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)) {
                    Column(modifier = Modifier
                        .fillMaxHeight()
                        .weight(2f)) {
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()) {
                            TextField(
                                colors = TextFieldDefaults.textFieldColors(
                                    containerColor = colorResource(id = R.color.white),
                                    cursorColor = colorResource(id = R.color.broun),
                                    unfocusedIndicatorColor = colorResource(id = R.color.broun),
                                    focusedIndicatorColor = colorResource(id = R.color.red),
                                    focusedTextColor = colorResource(id = R.color.broun),
                                    unfocusedTextColor = colorResource(id = R.color.broun)
                                ),
                                value = titleText.value, onValueChange = { newValue ->
                                    titleText.value = newValue
                                },
                                trailingIcon = null,
                                placeholder = {
                                    Text(
                                        stringResource(R.string.new_name_recepie), fontSize = 14.sp,
                                        color = colorResource(id = R.color.broun)
                                    )
                                },
                                keyboardOptions = KeyboardOptions.Default.copy(
                                    imeAction = ImeAction.Done
                                ),
                                keyboardActions = KeyboardActions(onDone = {
                                    keyboardController?.hide()
                                    focusManager.clearFocus()
                                }),
                                modifier = Modifier
                                    .wrapContentHeight()
                                    .fillMaxWidth(),
                                textStyle = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily(Font(R.font.imprisha)),
                                    textAlign = TextAlign.Start
                                )
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.venik),
                                contentDescription = "Clear title",
                                modifier = Modifier
                                    .size(30.dp)
                                    .padding(top = 4.dp, bottom = 8.dp, end = 8.dp)
                                    .align(Alignment.TopEnd)
                                    .clickable { titleText.value = "" },
                                tint = colorResource(R.color.broun)
                            )
                        }
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)) {
                            TextField(
                                colors = TextFieldDefaults.textFieldColors(
                                    containerColor = colorResource(id = R.color.white),
                                    cursorColor = colorResource(id = R.color.broun),
                                    unfocusedIndicatorColor = colorResource(id = R.color.broun),
                                    focusedIndicatorColor = colorResource(id = R.color.red),
                                    focusedTextColor = colorResource(id = R.color.broun),
                                    unfocusedTextColor = colorResource(id = R.color.broun)
                                ),
                                value = contentText.value, onValueChange = { newValue ->
                                    contentText.value = newValue
                                },
                                trailingIcon = null,
                                placeholder = {
                                    Text(
                                        stringResource(R.string.new_enter_recepie),
                                        fontSize = 14.sp,
                                        color = colorResource(id = R.color.broun)
                                    )
                                },
                                keyboardOptions = KeyboardOptions(
                                    imeAction = ImeAction.Done
                                ),
                                keyboardActions = KeyboardActions(onDone = {
                                    keyboardController?.hide()
                                    focusManager.clearFocus()
                                }),
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth()
                                    .imePadding(),
                                textStyle = TextStyle(
                                    fontSize = 16.sp,
                                    fontFamily = FontFamily(Font(R.font.imprisha)),
                                    textAlign = TextAlign.Start
                                )
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.venik),
                                contentDescription = "Clear content",
                                modifier = Modifier
                                    .size(30.dp)
                                    .padding(top = 4.dp, bottom = 8.dp, end = 8.dp)
                                    .align(Alignment.TopEnd)
                                    .clickable { contentText.value = "" },
                                tint = colorResource(R.color.broun)
                            )
                        }
                    }
                }
            }
        }
    } else{
        //Toast.makeText(context, "Permissions are required to display photos!", Toast.LENGTH_SHORT).show()
    }
}

fun saveImageToFile(context: Context, uri: Uri): Uri {
    val inputStream = context.contentResolver.openInputStream(uri)
    val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())
    val storageDir: File = File(context.getExternalFilesDir(null), "images")
    if (!storageDir.exists()) {
        storageDir.mkdirs()
    }
    val photoFile = File(storageDir, "JPEG_${timeStamp}.jpg")
    if (!photoFile.exists()) {
        val outputStream = FileOutputStream(photoFile)
        inputStream?.copyTo(outputStream)
        inputStream?.close()
        outputStream.close()
    }
    return FileProvider.getUriForFile(context, "${context.packageName}.fileprovider", photoFile)
}
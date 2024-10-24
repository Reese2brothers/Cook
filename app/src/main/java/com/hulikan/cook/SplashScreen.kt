package com.hulikan.cook

import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.ComponentRegistry
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(navController: NavController){
    val scope = rememberCoroutineScope()
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components(fun ComponentRegistry.Builder.() {
            if (Build.VERSION.SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        })
        .build()
    LaunchedEffect(key1 = true) {
        scope.launch {
            delay(2000)
            navController.navigate("MainScreen")
        }
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Image(painter = painterResource(R.drawable.cooking), contentDescription = "cooking_photo",
            modifier = Modifier.fillMaxSize())
        Column(
            modifier = Modifier.fillMaxSize().padding(top = 100.dp, bottom = 100.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Кулинария",
                modifier = Modifier.padding(4.dp),
                fontSize = 44.sp,
                color = colorResource(id = R.color.broun),
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.imprisha))
            )
                val gifPainter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(R.drawable.povarr)
                        .build(),
                    imageLoader = imageLoader
                )
                Image(
                    painter = gifPainter,
                    contentDescription = null,
                    modifier = Modifier.size(100.dp)
                )
        }
    }
}
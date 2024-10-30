package com.hulikan.cook

import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.net.toUri
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import com.hulikan.cook.viewmodels.FullscreenViewModel

class FullscreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel = ViewModelProvider(this, SavedStateViewModelFactory(application, this)).get(FullscreenViewModel::class.java)
            val videoUriString = intent.getStringExtra("videoUri")
            if (videoUriString != null) {
                viewModel.setVideoUri(videoUriString.toUri())
            }
            FullscreenVideoScreen(viewModel)
        }
    }

}

@Composable
fun FullscreenVideoScreen(viewModel: FullscreenViewModel) {
    val context = LocalContext.current
    val mediaController = remember { MediaController(context) }
    var videoView by remember { mutableStateOf<VideoView?>(null) }
    val videoUri by viewModel.videoUri.collectAsState(initial = null)
    var videoViewInitialized by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = videoUri) {
        if (videoUri != null && !videoViewInitialized) {
            videoView = VideoView(context).apply {
                requestFocus()
                setVideoURI(videoUri)
                setOnPreparedListener {
                    mediaController.setAnchorView(this)
                    it.start()
                }
                setMediaController(mediaController)
            }
            videoViewInitialized = true
        }
    }
    videoView?.let {
        AndroidView(
            factory = { videoView!! },
            modifier = Modifier.fillMaxSize()
        )
    }
}

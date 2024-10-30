package com.hulikan.cook.viewmodels

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.SavedStateHandle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FullscreenViewModel(application: Application, private val stateHandle: SavedStateHandle) : AndroidViewModel(application) {
private val _videoUri = MutableStateFlow<Uri?>(null)
    val videoUri: StateFlow<Uri?> = _videoUri.asStateFlow()

    init {
        stateHandle.get<String>("videoUri")?.let { uriString ->
            _videoUri.value = Uri.parse(uriString)
        }
    }
    fun setVideoUri(uri: Uri) {
        _videoUri.value = uri
        stateHandle.set("videoUri", uri.toString())
    }

}
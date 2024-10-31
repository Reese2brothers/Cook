package com.hulikan.cook.viewmodels

import android.app.Application
import android.media.MediaPlayer
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SharedViewModel(application: Application) : AndroidViewModel(application) {
    private val _mediaPlayer = MutableLiveData<MediaPlayer?>()
    val mediaPlayer: LiveData<MediaPlayer?> get() = _mediaPlayer

    fun setMediaPlayer(player: MediaPlayer) {
        _mediaPlayer.value = player
    }

    fun clearMediaPlayer() {
        _mediaPlayer.value?.release()
        _mediaPlayer.value = null
    }
}
package com.hulikan.cook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.res.colorResource
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.hulikan.cook.viewmodels.SharedViewModel

class MainActivity : ComponentActivity() {
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            sharedViewModel = ViewModelProvider(this).get(SharedViewModel::class.java)

            ScreenStatusBar(colorResource(id = R.color.broun))
            val navController = rememberNavController()
            NavGraphNavigate(this, navController, sharedViewModel)
        }
    }
    override fun onPause() {
        super.onPause()
        sharedViewModel.clearMediaPlayer()
    }

    override fun onDestroy() {
        super.onDestroy()
        sharedViewModel.clearMediaPlayer()
    }
}


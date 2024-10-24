package com.hulikan.cook.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hulikan.cook.R

@Composable
fun ThreeScreen() {
    Box(modifier = Modifier.fillMaxSize().systemBarsPadding()) {
        Text(
            text = "threescreen",
            modifier = Modifier.fillMaxWidth()
                .wrapContentHeight(Alignment.CenterVertically).padding(end = 8.dp),
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            color = colorResource(id = R.color.broun),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.imprisha))
        )
    }
}
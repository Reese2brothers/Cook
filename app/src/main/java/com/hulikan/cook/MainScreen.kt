package com.hulikan.cook

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.hulikan.cook.viewmodels.MainViewModel

@Composable
fun MainScreen(navController: NavController){
    //val viewModel: MainViewModel = viewModel()
    //val list by viewModel.mainlist.collectAsState(initial = emptyList())
Box(modifier = Modifier.fillMaxSize().systemBarsPadding()) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth().height(40.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically){
            Icon(painter = painterResource(id = R.drawable.baseline_add_24),
                contentDescription = "Favorite",
                modifier = Modifier.padding(end = 12.dp).size(35.dp)
                    .clickable {
                        navController.navigate("ResourceScreen")
                    },
                tint = colorResource(R.color.broun)
            )
        }
        Row(modifier = Modifier.fillMaxWidth().height(1.dp)
            .padding(start = 4.dp, end = 4.dp)
            .background(color = colorResource(R.color.broun))){}
        LazyColumn(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
//            itemsIndexed(list) { index, item ->
//
//            }
        }
    }
}
}

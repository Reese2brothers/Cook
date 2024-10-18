package com.hulikan.cook.screens

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.Room
import com.hulikan.cook.R
import com.hulikan.cook.database.AppDatabase
import com.hulikan.cook.database.MainList
import com.hulikan.cook.database.OneLinks
import kotlinx.coroutines.flow.Flow

@Composable
fun OneScreen(context : Context){
    val scope = rememberCoroutineScope()
    val db = remember { Room.databaseBuilder(context, AppDatabase::class.java, "database").build() }
    val itemsFlow: Flow<List<OneLinks>> = db.oneLinksDao().getAll()
    val links by itemsFlow.collectAsState(initial = emptyList())
    LaunchedEffect(links) {
        db.oneLinksDao().getAll()
    }

    Column(modifier = Modifier.fillMaxSize().systemBarsPadding()){
        Column(modifier = Modifier.fillMaxWidth().height(200.dp)) {
            Row(modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Ссылки на рецепты",
                    modifier = Modifier.weight(1f).padding(start = 42.dp),
                    textAlign = TextAlign.Start,
                    fontSize = 18.sp,
                    color = colorResource(id = R.color.broun),
                    fontFamily = FontFamily(Font(R.font.imprisha))
                )
                Row(
                    modifier = Modifier.padding(end = 42.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_add_24),
                        contentDescription = "add",
                        modifier = Modifier.size(35.dp).padding(end = 8.dp).clickable {

                        },
                        tint = colorResource(R.color.broun)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.venik),
                        contentDescription = "delete",
                        modifier = Modifier.size(25.dp).clickable {

                        },
                        tint = colorResource(R.color.broun)
                    )
                }
            }
            Row(modifier = Modifier.fillMaxWidth().height(1.dp).padding(start = 32.dp, end = 32.dp).background(
                colorResource(R.color.broun)
            )) {}
            LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f).padding(top = 4.dp, bottom = 4.dp)) {
                itemsIndexed(links) {index, item ->
                    Card(modifier = Modifier.padding(top = 4.dp, start = 8.dp, end = 8.dp, bottom = 4.dp)
                        .fillMaxWidth().wrapContentHeight().background(Color.Transparent),
                        shape = RoundedCornerShape(8.dp),
                        elevation = 5.dp,
                        border = BorderStroke(1.dp, color = colorResource(R.color.broun))
                    ){
                        Row(modifier = Modifier.fillMaxWidth(),
                           verticalAlignment = Alignment.CenterVertically) {
                            Text(text = item.title,
                                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                                textAlign = TextAlign.Start,
                                fontSize = 18.sp,
                                color = colorResource(id = R.color.broun),
                                fontFamily = FontFamily(Font(R.font.imprisha))
                            )
                            Column(modifier = Modifier.fillMaxHeight().width(1.dp).padding(top = 4.dp, bottom = 4.dp)) {}
                            Text(
                                text = item.link,
                                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                                textAlign = TextAlign.Start,
                                fontSize = 10.sp,
                                color = Color.Blue,
                                fontFamily = FontFamily(Font(R.font.imprisha)),
                                textDecoration = TextDecoration.Underline
                            )
                        }
                    }
                }
            }
        }
        Row(modifier = Modifier.fillMaxWidth().height(1.dp).padding(start = 4.dp, end = 4.dp).background(
            colorResource(R.color.broun)
        )) {}
        LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f).padding(top = 4.dp, bottom = 4.dp)) {

        }
    }
}
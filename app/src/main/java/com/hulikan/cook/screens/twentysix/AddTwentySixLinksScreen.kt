package com.hulikan.cook.screens.twentysix

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.room.Room
import com.hulikan.cook.R
import com.hulikan.cook.database.AppDatabase
import com.hulikan.cook.database.OneLinks
import com.hulikan.cook.database.TwentySixLinks
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTwentySixLinksScreen(context : Context, navController: NavController){
    val scope = rememberCoroutineScope()
    val db = remember { Room.databaseBuilder(context, AppDatabase::class.java, "database").build() }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val titleText = rememberSaveable { mutableStateOf("") }
    val linkText = rememberSaveable { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .systemBarsPadding()
        .background(colorResource(R.color.white)),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(24.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
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
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.venik),
                        contentDescription = "Clear content",
                        modifier = Modifier
                            .size(30.dp)
                            .padding(end = 8.dp)
                            .align(Alignment.TopEnd)
                            .clickable { titleText.value = "" },
                        tint = colorResource(R.color.broun)
                    ) },
                placeholder = {
                    Text(
                        stringResource(R.string.links_name_link),
                        fontSize = 14.sp,
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
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.imprisha)),
                    textAlign = TextAlign.Start
                )
            )
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(24.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            TextField(
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = colorResource(id = R.color.white),
                    cursorColor = colorResource(id = R.color.broun),
                    unfocusedIndicatorColor = colorResource(id = R.color.broun),
                    focusedIndicatorColor = colorResource(id = R.color.red),
                    focusedTextColor = colorResource(id = R.color.broun),
                    unfocusedTextColor = colorResource(id = R.color.broun)
                ),
                value = linkText.value, onValueChange = { newValue ->
                    linkText.value = newValue
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.venik),
                        contentDescription = "Clear content",
                        modifier = Modifier
                            .size(30.dp)
                            .padding(end = 8.dp)
                            .align(Alignment.TopEnd)
                            .clickable { linkText.value = "" },
                        tint = colorResource(R.color.broun)
                    )
                },
                placeholder = {
                    Text(
                        stringResource(R.string.links_in_link),
                        fontSize = 14.sp,
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
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.imprisha)),
                    textAlign = TextAlign.Start
                )
            )
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(24.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(end = 24.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_save_24),
                contentDescription = "save link",
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 8.dp)
                    .clickable {
                        scope.launch {
                            if (titleText.value.isNotBlank() && linkText.value.isNotBlank()) {
                                db
                                    .twentySixLinksDao()
                                    .insertTwentySixLinks(
                                        TwentySixLinks(
                                            title = titleText.value,
                                            link = linkText.value
                                        )
                                    )
                                navController.navigate("TwentySixScreen/${titleText.value}/\"no_data\"/\"no_data\"")
                            } else {
                                Toast
                                    .makeText(
                                        context,
                                        context.getString(R.string.toast_full_fields),
                                        Toast.LENGTH_SHORT
                                    )
                                    .show()
                            }
                        }
                    },
                tint = colorResource(R.color.broun)
            )
        }
    }
}
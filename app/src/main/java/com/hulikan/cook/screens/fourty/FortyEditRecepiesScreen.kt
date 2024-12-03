package com.hulikan.cook.screens.fourty

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.room.Room
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.hulikan.cook.R
import com.hulikan.cook.database.AppDatabase
import kotlinx.coroutines.launch
import java.net.URLDecoder
import java.net.URLEncoder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FortyEditRecepiesScreen(context: Context, navController: NavController, title: String, content: String, image : String){
    val decodedTitle = try {
        URLDecoder.decode(title, "UTF-8").replace("+", " ")
    } catch (e: IllegalArgumentException) {
        title.replace("+", " ")
    }
    val decodedContent = try {
        URLDecoder.decode(content, "UTF-8").replace("+", " ")
    } catch (e: IllegalArgumentException) {
        content.replace("+", " ")
    }
    val decodedImage = URLDecoder.decode(image, "UTF-8")
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val titleText = rememberSaveable { mutableStateOf(decodedTitle) }
    val contentText = rememberSaveable { mutableStateOf(decodedContent) }
    val scope = rememberCoroutineScope()
    val db by lazy { Room.databaseBuilder(context, AppDatabase::class.java, "database").build() }
    val showDialog = remember { mutableStateOf(false) }
    val showDialogTwo = remember { mutableStateOf(false) }
    val showDialogThree = remember { mutableStateOf(false) }

    ProvideWindowInsets {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
                .padding(4.dp)
                .navigationBarsWithImePadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
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
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(onDone = {
                            keyboardController?.hide()
                            focusManager.clearFocus()
                        }),
                        modifier = Modifier
                            .fillMaxWidth()
                            .imePadding(),
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
                            .clickable { showDialogThree.value = true },
                        tint = colorResource(R.color.broun)
                    )
                    if (showDialogThree.value) {
                        AlertDialog(
                            onDismissRequest = {
                                showDialogThree.value = false
                            },
                            containerColor = colorResource(id = R.color.white),
                            title = {
                                Text(stringResource(R.string.alert_confirm), color = colorResource(id = R.color.broun),
                                    fontSize = 20.sp, fontWeight = FontWeight.Bold
                                )
                            },
                            text = {
                                Text(
                                    stringResource(R.string.alert_clear_text),
                                    color = colorResource(id = R.color.broun)
                                )
                            },
                            confirmButton = {
                                Button(colors = ButtonDefaults.buttonColors(
                                    containerColor = colorResource(id = R.color.broun)
                                ),
                                    onClick = {
                                        titleText.value = ""
                                        showDialogThree.value = false
                                    }) {
                                    Text(
                                        stringResource(R.string.alert_yes),
                                        color = colorResource(id = R.color.white),
                                        fontSize = 16.sp
                                    )
                                }
                            },
                            dismissButton = {
                                Button(colors = ButtonDefaults.buttonColors(
                                    containerColor = colorResource(id = R.color.broun)
                                ),
                                    onClick = {
                                        showDialogThree.value = false
                                    }) {
                                    Text(
                                        stringResource(R.string.alert_cancel),
                                        color = colorResource(id = R.color.white),
                                        fontSize = 16.sp
                                    )
                                }
                            })
                    }
                }
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
                        value = contentText.value, onValueChange = { newValue ->
                            contentText.value = newValue
                        },
                        trailingIcon = null,
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(onDone = {
                            keyboardController?.hide()
                            focusManager.clearFocus()
                        }),
                        modifier = Modifier
                            .fillMaxWidth()
                            .imePadding(),
                        textStyle = TextStyle(
                            fontSize = 20.sp,
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
                            .clickable { showDialogTwo.value = true },
                        tint = colorResource(R.color.broun)
                    )
                    if (showDialogTwo.value) {
                        AlertDialog(
                            onDismissRequest = {
                                showDialogTwo.value = false
                            },
                            containerColor = colorResource(id = R.color.white),
                            title = {
                                Text(
                                    stringResource(R.string.alert_confirm), color = colorResource(id = R.color.broun),
                                    fontSize = 20.sp, fontWeight = FontWeight.Bold
                                )
                            },
                            text = {
                                Text(
                                    stringResource(R.string.alert_clear_text),
                                    color = colorResource(id = R.color.broun)
                                )
                            },
                            confirmButton = {
                                Button(colors = ButtonDefaults.buttonColors(
                                    containerColor = colorResource(id = R.color.broun)
                                ),
                                    onClick = {
                                        contentText.value = ""
                                        showDialogTwo.value = false
                                    }) {
                                    Text(
                                        stringResource(R.string.alert_yes),
                                        color = colorResource(id = R.color.white),
                                        fontSize = 16.sp
                                    )
                                }
                            },
                            dismissButton = {
                                Button(colors = ButtonDefaults.buttonColors(
                                    containerColor = colorResource(id = R.color.broun)
                                ),
                                    onClick = {
                                        showDialogTwo.value = false
                                    }) {
                                    Text(
                                        stringResource(R.string.alert_cancel),
                                        color = colorResource(id = R.color.white),
                                        fontSize = 16.sp
                                    )
                                }
                            })
                    }
                }
            }
            Button(
                onClick = { showDialog.value = true },
                modifier = Modifier
                    .wrapContentSize()
                    .padding(top = 32.dp, start = 16.dp, end = 16.dp),
                colors = ButtonDefaults.buttonColors(colorResource(R.color.broun))
            ) {
                Text(
                    text = stringResource(R.string.edit_save_changes),
                    modifier = Modifier
                        .padding(start = 8.dp, end = 8.dp)
                        .wrapContentHeight(),
                    textAlign = TextAlign.Center,
                    fontSize = 32.sp,
                    color = colorResource(id = R.color.white),
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.imprisha))
                )
            }
            if (showDialog.value) {
                AlertDialog(
                    onDismissRequest = {
                        showDialog.value = false
                    },
                    containerColor = colorResource(id = R.color.white),
                    title = {
                        Text(
                            stringResource(R.string.alert_confirm), color = colorResource(id = R.color.broun),
                            fontSize = 20.sp, fontWeight = FontWeight.Bold
                        )
                    },
                    text = {
                        Text(
                            stringResource(R.string.alert_save_changes),
                            color = colorResource(id = R.color.broun)
                        )
                    },
                    confirmButton = {
                        Button(colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.broun)
                        ),
                            onClick = {
                                scope.launch {
                                    scope.launch {
                                        db.fortyDao().updateRecepie(
                                            titleText.value,
                                            contentText.value,
                                            decodedTitle,
                                            decodedImage
                                        )
                                    }
                                    val updatedTitle = URLEncoder.encode(titleText.value, "UTF-8")
                                    val updatedContent =
                                        URLEncoder.encode(contentText.value, "UTF-8")
                                    val updatedImage = URLEncoder.encode(decodedImage, "UTF-8")
                                    navController.navigate("FortyRecepiesScreen/$updatedTitle/$updatedContent/$updatedImage")
                                }
                                showDialog.value = false
                            }) {
                            Text(stringResource(R.string.alert_yes), color = colorResource(id = R.color.white), fontSize = 16.sp)
                        }
                    },
                    dismissButton = {
                        Button(colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.broun)
                        ),
                            onClick = {
                                showDialog.value = false
                            }) {
                            Text(
                                stringResource(R.string.alert_cancel),
                                color = colorResource(id = R.color.white),
                                fontSize = 16.sp
                            )
                        }
                    })
            }
        }
    }
}
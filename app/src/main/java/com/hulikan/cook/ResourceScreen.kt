package com.hulikan.cook

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResourceScreen(navController: NavController){
    val currentText = rememberSaveable { mutableStateOf("") }
    val titleText = rememberSaveable { mutableStateOf("") }
    val selectedImage = rememberSaveable { mutableStateOf(R.drawable.baseline_image_24) }
    val image = rememberSaveable { mutableStateOf(R.drawable.baseline_image_24) }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val images = listOf(
        R.drawable.fisher, R.drawable.barbecuesauce, R.drawable.burger,
        R.drawable.cake, R.drawable.cakes, R.drawable.chasha,
        R.drawable.cocktail, R.drawable.conservacia, R.drawable.dessert,
        R.drawable.fish
    )

    Box(modifier = Modifier.fillMaxSize().systemBarsPadding()){
        Column(modifier = Modifier.fillMaxSize(),
            //verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally){
            LazyRow(modifier = Modifier.fillMaxWidth().height(160.dp).padding(top = 16.dp)) {
                items(images) { image ->
                    Image(
                        painter = painterResource(id = image),
                        contentDescription = null,
                        modifier = Modifier
                            .size(150.dp)
                            .padding(4.dp)
                            .clickable {
                                selectedImage.value = image
                            }
                    )
                    Column(modifier = Modifier.width(1.dp).fillMaxHeight().padding(top = 4.dp, bottom = 4.dp)
                        .background(color = colorResource(R.color.broun))) {  }
                }
            }
            TextField(
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = colorResource(id = R.color.white),
                    cursorColor = colorResource(id = R.color.broun),
                    unfocusedIndicatorColor = colorResource(id = R.color.broun),
                    focusedIndicatorColor = colorResource(id = R.color.red),
                    focusedTextColor = colorResource(id = R.color.broun),
                    unfocusedTextColor = colorResource(id = R.color.broun)
                ),
                value = currentText.value, onValueChange = { newValue ->
                    currentText.value = newValue
                    //viewModel.addToEditEntity(newValue)
                    //imageSave.value = R.drawable.baseline_done_red
                    //saveTextColor.value = R.color.red
                },
                trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.venik),
                            contentDescription = "Clear text",
                            modifier = Modifier.size(35.dp).padding(end = 8.dp).clickable { currentText.value = "" },
                            tint = colorResource(R.color.broun)
                        )
                },
                placeholder = {
                    Text("введите название раздела...", color = colorResource(id = R.color.broun))
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {
                    titleText.value = currentText.value
                    keyboardController?.hide()
                    focusManager.clearFocus()
                }),
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
            )
            Column(modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Card(modifier = Modifier.padding(start = 12.dp, end = 12.dp).fillMaxWidth().height(150.dp)
                    .background(Color.Transparent),
                    shape = CutCornerShape(bottomStart = 8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                    border = BorderStroke(1.dp, color = colorResource(id = R.color.broun))) {
                    Row(modifier = Modifier.fillMaxSize().background(colorResource(R.color.white)),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center){
                        Image(painter = painterResource(id = selectedImage.value), contentDescription = "choise_image",
                            modifier = Modifier.fillMaxHeight().width(150.dp).padding(start = 8.dp))
                        Text(text = titleText.value,
                            modifier = Modifier.fillMaxWidth()
                                .wrapContentHeight(Alignment.CenterVertically).padding(end = 8.dp),
                            textAlign = TextAlign.Center,
                            fontSize = 30.sp,
                            color = colorResource(id = R.color.broun),
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily(Font(R.font.appetiteitalic))
                        )
                    }
                }
                Button(modifier = Modifier.fillMaxWidth().height(150.dp).padding(start = 16.dp, end = 16.dp),
                    onClick = {

                    },
                    colors = ButtonDefaults.buttonColors(colorResource(R.color.white)),
                    border = BorderStroke(1.dp, colorResource(R.color.broun)),
                    shape = CutCornerShape(8.dp)
                ) {
                    Text(text = "Сохранить",
                        fontSize = 44.sp,
                        color = colorResource(id = R.color.broun),
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.appetiteitalic))
                    )
                }
            }
        }
    }
}
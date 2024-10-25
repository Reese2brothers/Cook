package com.hulikan.cook

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.room.Room
import com.hulikan.cook.database.AppDatabase
import com.hulikan.cook.database.MainList
import com.hulikan.cook.database.One
import com.hulikan.cook.database.OneDao
import kotlinx.coroutines.launch
import java.net.URLDecoder
import java.net.URLEncoder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResourceScreen(context : Context, navController: NavController, title : String, image : String, wordkey : String){
    var decodedTitle = URLDecoder.decode(title, "UTF-8").let { if (it == "empty") "" else it }
    val decodedImage = URLDecoder.decode(image, "UTF-8")
    val decodedWordkey = URLDecoder.decode(wordkey, "UTF-8")
    val currentText = rememberSaveable { mutableStateOf(decodedTitle) }
    val titleText = rememberSaveable { mutableStateOf("") }
    val selectedImage = rememberSaveable { mutableStateOf(if (decodedImage.isBlank()
        || decodedImage == "no_image") R.drawable.baseline_image_24 else decodedImage.toInt()) }
    val scope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val db = remember { Room.databaseBuilder(context, AppDatabase::class.java, "database").build() }
    val mainListDao = db.mainListDao()
    val wordKeys = listOf(
        "one", "two", "three", "four", "five",
        "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "fourteen", "fifteen",
        "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
        "twentyone", "twentytwo", "twentythree", "twentyfour", "twentyfive",
        "twentysix", "twentyseven", "twentyeight", "twentynine", "thirty")

        val images = listOf(
        R.drawable.bbq, R.drawable.bize, R.drawable.blini,
        R.drawable.blinsnachinkoi, R.drawable.borsch, R.drawable.brinza,
        R.drawable.burger, R.drawable.buterbrot, R.drawable.cake,
        R.drawable.caketwo,R.drawable.chainik, R.drawable.cheburek, R.drawable.cocktail,
        R.drawable.decor, R.drawable.duhovka, R.drawable.fish,
        R.drawable.fishtwo, R.drawable.fishthree, R.drawable.fri,
        R.drawable.garnir,R.drawable.grill, R.drawable.hleb, R.drawable.kabachki,
        R.drawable.konfeti, R.drawable.konfetitwo, R.drawable.kotleti,
        R.drawable.krem, R.drawable.kremtwo, R.drawable.lavash,
        R.drawable.meat,R.drawable.meattwo, R.drawable.microvolnovka, R.drawable.morozivo,
        R.drawable.morozivotwo, R.drawable.multivarka, R.drawable.narezka,
        R.drawable.narezkatwo, R.drawable.oladi, R.drawable.oladitwo,
        R.drawable.olivie,R.drawable.panini, R.drawable.paninitwo, R.drawable.pashtet,
        R.drawable.pasta, R.drawable.pechentort, R.drawable.pechivo,
        R.drawable.pechivotwo, R.drawable.pirog, R.drawable.pirogtwo,
        R.drawable.pirogenoe,R.drawable.pizza, R.drawable.pizzatwo, R.drawable.pizzathree,
        R.drawable.rulet, R.drawable.salat, R.drawable.salattwo,
        R.drawable.salatthree, R.drawable.salatfour, R.drawable.salatfive,
        R.drawable.shashlik,R.drawable.shashliktwo, R.drawable.smuzi, R.drawable.smuzitwo,
        R.drawable.solenia, R.drawable.soleniatwo, R.drawable.sous,
        R.drawable.soustwo, R.drawable.sousthree, R.drawable.suppure,
        R.drawable.suppuretwo,R.drawable.teacup, R.drawable.testo, R.drawable.tikva,
        R.drawable.tikvatwo, R.drawable.tushen, R.drawable.tushentwo,
        R.drawable.tworog, R.drawable.vipechka, R.drawable.vipechkatwo,
        R.drawable.zhele
    )

    Box(modifier = Modifier.fillMaxSize().systemBarsPadding()){
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "выберите фотографию",
                fontSize = 14.sp,
                color = colorResource(id = R.color.broun),
                modifier = Modifier.padding(top = 4.dp)
            )
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
                            modifier = Modifier.fillMaxHeight().width(150.dp).padding(top = 4.dp, bottom = 4.dp, start = 8.dp))
                        Text(text = titleText.value,
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
                Button(modifier = Modifier.fillMaxWidth().height(150.dp).padding(start = 16.dp, end = 16.dp),
                    onClick = {
                        scope.launch {
                            val titles = titleText.value
                            val imagess = selectedImage.value
                            val wordkeys = decodedWordkey
                            val existingSection = mainListDao.getSectionByWordkey(wordkeys)
                            if (existingSection != null) {
                                mainListDao.updateSection(titles, imagess, wordkey)
                                Toast.makeText(context, "Категория обновлена", Toast.LENGTH_SHORT).show()
                            } else {
                                var newWordKey: String? = null
                                val existingKeys = mainListDao.getAllKeys()
                                for (key in wordKeys) {
                                    if (!existingKeys.contains(key)) {
                                        newWordKey = key
                                        break
                                    }
                                }
                                if (newWordKey == null) {
                                    Toast.makeText(context, "Больше ничего сохранить нельзя", Toast.LENGTH_SHORT).show()
                                } else {
                                    val mainList = MainList(text = titles, image = imagess, wordkey = newWordKey)
                                    mainListDao.insert(mainList)
                                    Toast.makeText(context, "Новая категория сохранена", Toast.LENGTH_SHORT).show()
                                }
                            }
                            val encodedTitle = URLEncoder.encode(titles, "UTF-8")
                            val encodedImage = URLEncoder.encode(imagess.toString(), "UTF-8")
                            val encodedWordkey = URLEncoder.encode(decodedWordkey, "UTF-8")
                            navController.navigate("MainScreen/$encodedTitle/$encodedImage/$encodedWordkey")
                        }
                    },
                    colors = ButtonDefaults.buttonColors(colorResource(R.color.white)),
                    border = BorderStroke(1.dp, colorResource(R.color.broun)),
                    shape = CutCornerShape(8.dp)
                ) {
                    Text(text = "Сохранить",
                        fontSize = 44.sp,
                        color = colorResource(id = R.color.broun),
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.imprisha))
                    )
                }
            }
        }
    }
}
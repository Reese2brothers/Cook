package com.hulikan.cook.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hulikan.cook.database.MainListDao
import com.hulikan.cook.database.MainList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel(var mainListDao : MainListDao) : ViewModel() {
    val mainlist: Flow<List<MainList>> = mainListDao.getAll()
    fun addToMainList(text : String, image : String){
        viewModelScope.launch {
            //mainDao.deleteAll()
            //mainListDao.insertList(MainList(text, image.toInt(), ""))
        }
    }
    fun deleteAll(){
        viewModelScope.launch {
            mainListDao.deleteAll()
        }
    }
}
package com.hulikan.cook.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hulikan.cook.database.MainDao
import com.hulikan.cook.database.MainList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel(var mainDao : MainDao) : ViewModel() {
    val mainlist: Flow<List<MainList>> = mainDao.getAll()
    fun addToMainList(text : String, image : String){
        viewModelScope.launch {
            //mainDao.deleteAll()
            mainDao.insertList(MainList(text, image))
        }
    }
    fun deleteAll(){
        viewModelScope.launch {
            mainDao.deleteAll()
        }
    }
}
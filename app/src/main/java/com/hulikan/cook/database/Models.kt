package com.hulikan.cook.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MainList(
    val text : String,
    val image : String
)
{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
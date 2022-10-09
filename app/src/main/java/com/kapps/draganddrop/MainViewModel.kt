package com.kapps.draganddrop

import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class MainViewModel :ViewModel() {

    var isCurrentlyDragging by mutableStateOf(false)
        private set

    var items by mutableStateOf(mutableListOf<PersonUiItem>())
        private set

    var addedPersons = mutableStateListOf<PersonUiItem>()
        private set

    init {
        items = mutableListOf(
            PersonUiItem("E","0", Color.Gray),
            PersonUiItem("D","1", Color.Gray),
            PersonUiItem("C","2", Color.Gray),
            PersonUiItem("B","3", Color.Gray),
            PersonUiItem("A","4", Color.Gray)
        )
    }

    fun startDragging(){
        isCurrentlyDragging = true
    }
    fun stopDragging(){
        isCurrentlyDragging = false
    }

    fun addPerson(personUiItem: PersonUiItem){
        if ((items.size - 1) == (personUiItem.id.toInt())){
            removePerson(personUiItem)
            addedPersons.add(personUiItem)
        }
    }
    private fun removePerson(personUiItem: PersonUiItem){
        items.removeAt(personUiItem.id.toInt())
    }


}

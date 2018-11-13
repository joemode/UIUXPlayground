package com.schoenherr.uiuxplayground.ui.recyclergrid

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.schoenherr.uiuxplayground.SingleLiveEvent
import com.schoenherr.uiuxplayground.data.Word
import com.schoenherr.uiuxplayground.data.WordRepository

class GridRecyclerViewModel(application: Application) : AndroidViewModel(application) {

    // TODO: REMOVE
    private val sourceString: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum faucibus vulputate lectus vel suscipit. In eleifend odio non tempus vestibulum. Nam enim massa, molestie et magna sit amet, congue vestibulum tortor. Curabitur vel libero sed mauris commodo dictum. Pellentesque pretium mauris orci, sed molestie purus pretium a. Ut consectetur erat ac felis mollis mattis. Donec ac lacus eget ligula ultrices ultricies. Phasellus et massa ipsum. Morbi ut fringilla libero."
    private val sourceList: List<String> = sourceString.split(" ")
    private var sourceIndex: Int = 0

    // Database
    private val repository = WordRepository(application)
    val allWords: LiveData<List<Word>> = repository.allWords

    // Dialog Action
    private val _openNewWordDialog = SingleLiveEvent<Any>()
    val openNewWordDialog: LiveData<Any>
        get() = _openNewWordDialog


    fun insert(word: Word) {
        repository.insert(word)
    }

    fun delete(word: Word) {
        repository.delete(word)
    }

    fun addItemClick() {
        _openNewWordDialog.call()
//        insert(Word(sourceList[++sourceIndex]))
    }
}
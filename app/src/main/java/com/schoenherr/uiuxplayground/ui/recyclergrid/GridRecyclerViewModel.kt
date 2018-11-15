package com.schoenherr.uiuxplayground.ui.recyclergrid

import android.app.Application
import androidx.lifecycle.LiveData
import com.schoenherr.uiuxplayground.SingleLiveEvent
import com.schoenherr.uiuxplayground.data.DataManager
import com.schoenherr.uiuxplayground.data.Word
import com.schoenherr.uiuxplayground.data.WordRepository
import com.schoenherr.uiuxplayground.ui.base.BaseViewModel
import javax.inject.Inject

class GridRecyclerViewModel(application: Application, dataManager: DataManager) : BaseViewModel(application) {

    init {
        getModelComponent().inject(this)
    }

    // Database
    @Inject lateinit var repository: WordRepository
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
    }
}
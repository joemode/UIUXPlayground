package com.schoenherr.uiuxplayground.data

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import javax.inject.Inject

class WordRepository @Inject constructor(db: WordRoomDatabase){

//    lateinit var application: Application
//    @Inject lateinit var db: WordRoomDatabase
//    private val db: WordRoomDatabase = WordRoomDatabase.getInstance(application)
    private val wordDao = db.wordDao()
    val allWords = wordDao.getAllWords()

    fun insert(word: Word) {
        InsertAsyncTask(wordDao).execute(word)
    }

    fun delete(word: Word) {
        DeleteAsyncTask(wordDao).execute(word)
    }

    class InsertAsyncTask(private val wordDao: WordDao): AsyncTask<Word, Void, Void>() {
        override fun doInBackground(vararg params: Word?): Void? {
            wordDao.insert(params[0]!!)
            return null
        }
    }

    class DeleteAsyncTask(private val wordDao: WordDao): AsyncTask<Word, Void, Void>() {
        override fun doInBackground(vararg params: Word?): Void? {
            wordDao.delete(params[0]!!)
            return null
        }
    }
}
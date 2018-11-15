package com.schoenherr.uiuxplayground.data

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.os.AsyncTask.execute
import androidx.sqlite.db.SupportSQLiteDatabase



@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class WordRoomDatabase: RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object {
        private var INSTANCE: WordRoomDatabase? = null

//        private val roomDatabaseCallback = object : RoomDatabase.Callback() {
//
//            override fun onOpen(db: SupportSQLiteDatabase) {
//                super.onOpen(db)
////                PopulateDbAsync(INSTANCE!!).execute()
//            }
//        }

        fun getInstance(context: Context): WordRoomDatabase {
            if (INSTANCE == null) {
                synchronized(WordRoomDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        WordRoomDatabase::class.java,
                        "word_database")
//                        .addCallback(roomDatabaseCallback)
                        .build()
                }
            }
            return INSTANCE!!
        }
    }

//    private class PopulateDbAsync(db: WordRoomDatabase): AsyncTask<Void, Void, Void>() {
//
//        private val dao: WordDao = db.wordDao()
//
//        override fun doInBackground(vararg params: Void?): Void? {
//            dao.deleteAll()
//            dao.insert(Word("Hello"))
//            dao.insert(Word("World"))
//            return null
//        }
//
//    }
}
package com.schoenherr.uiuxplayground.di.model

import android.app.Application
import com.schoenherr.uiuxplayground.data.WordRoomDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModelModule(private val application: Application) {

    @Provides
    fun provideWordDatabase(): WordRoomDatabase = WordRoomDatabase.getInstance(application)
}
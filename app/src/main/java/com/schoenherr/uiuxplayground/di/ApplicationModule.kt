package com.schoenherr.uiuxplayground.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.schoenherr.uiuxplayground.data.DataManagerImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Application) {

//    private val application = application

    @Provides
    fun provideSharedPreferences(): SharedPreferences {
        return application.getSharedPreferences("global_preferences", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideDataManager(sharedPreferences: SharedPreferences): DataManagerImpl {
        return DataManagerImpl(sharedPreferences)
    }

//    @Provides
//    fun provideStyledMapViewModel()
}
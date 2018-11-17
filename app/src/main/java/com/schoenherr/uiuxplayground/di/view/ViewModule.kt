package com.schoenherr.uiuxplayground.di.view

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.schoenherr.uiuxplayground.data.DataManager
import com.schoenherr.uiuxplayground.data.DataManagerImpl
import com.schoenherr.uiuxplayground.data.WordRepository
import com.schoenherr.uiuxplayground.data.WordRoomDatabase
import com.schoenherr.uiuxplayground.ui.recyclergrid.GridRecyclerViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModule(private val fragmentActivity: FragmentActivity) {

    @Provides
    fun provideFragmentManager() = fragmentActivity.supportFragmentManager

//    @Provides
//    fun provideLayoutInflater

    @Provides
    fun provideActivity(): Activity = fragmentActivity

    @Provides
    fun provideContext(activity: Activity) : Context = activity

    @Provides
    fun provideDataManager(dataManagerImpl: DataManagerImpl) : DataManager = dataManagerImpl

    @Provides
    fun provideWordDatabase(application: Application): WordRoomDatabase = WordRoomDatabase.getInstance(application)

//    @Provides
//    fun provideGridRecyclerViewModel(application: Application, dataManager: DataManager): GridRecyclerViewModel =
//        GridRecyclerViewModel(application, dataManager)
}
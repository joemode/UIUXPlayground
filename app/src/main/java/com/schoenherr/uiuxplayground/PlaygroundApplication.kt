package com.schoenherr.uiuxplayground

import android.app.Application
import com.schoenherr.uiuxplayground.di.ApplicationComponent
import com.schoenherr.uiuxplayground.di.ApplicationModule
//import com.schoenherr.uiuxplayground.di.DaggerApplicationComponent

class PlaygroundApplication : Application() {

    private var applicationComponent: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()

//        getApplicationComponent().inject(this)
    }

//    fun getApplicationComponent() : ApplicationComponent {
//        if (applicationComponent == null) {
//            applicationComponent = DaggerApplicationComponent
//                .builder()
//                .applicationModule(ApplicationModule(this))
//                .build()
//        }
//        return applicationComponent!!
//    }
}
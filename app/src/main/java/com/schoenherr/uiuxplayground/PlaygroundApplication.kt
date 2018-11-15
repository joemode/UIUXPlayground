package com.schoenherr.uiuxplayground

import android.app.Application
//import com.schoenherr.uiuxplayground.di.DaggerApplicationComponent
import com.schoenherr.uiuxplayground.di.DaggerBindingComponent
import com.schoenherr.uiuxplayground.di.application.ApplicationComponent
import com.schoenherr.uiuxplayground.di.application.ApplicationModule
import com.schoenherr.uiuxplayground.di.application.DaggerApplicationComponent

//import com.schoenherr.uiuxplayground.di.DaggerApplicationComponent

class PlaygroundApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()

//        val bindingComponent:
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
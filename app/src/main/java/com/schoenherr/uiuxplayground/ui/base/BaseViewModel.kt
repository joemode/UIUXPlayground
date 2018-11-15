package com.schoenherr.uiuxplayground.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.schoenherr.uiuxplayground.PlaygroundApplication
import com.schoenherr.uiuxplayground.di.application.ApplicationComponent
import com.schoenherr.uiuxplayground.di.model.ModelComponent
import com.schoenherr.uiuxplayground.di.model.ModelModule

abstract class BaseViewModel(application: Application): AndroidViewModel(application) {

    private var isInjectorUsed: Boolean = false

    protected fun getModelComponent(): ModelComponent {
        if (isInjectorUsed) throw RuntimeException("there is no need to use the injector more than once")

        isInjectorUsed = true
        return getApplicationComponent().newModelComponent(ModelModule(getApplication<PlaygroundApplication>()))
    }
    private fun getApplicationComponent(): ApplicationComponent = getApplication<PlaygroundApplication>().applicationComponent

}
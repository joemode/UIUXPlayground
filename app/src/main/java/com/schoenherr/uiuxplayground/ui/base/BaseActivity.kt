package com.schoenherr.uiuxplayground.ui.base

import androidx.appcompat.app.AppCompatActivity
import com.schoenherr.uiuxplayground.PlaygroundApplication
import com.schoenherr.uiuxplayground.di.application.ApplicationComponent
import com.schoenherr.uiuxplayground.di.view.ViewComponent
import com.schoenherr.uiuxplayground.di.view.ViewModule
import java.lang.RuntimeException

abstract class BaseActivity: AppCompatActivity() {

    private var isInjectorUsed: Boolean = false

    private fun getApplicationComponent(): ApplicationComponent = (application as PlaygroundApplication).applicationComponent

    protected fun getViewComponent(): ViewComponent {
        if (isInjectorUsed) throw RuntimeException("there is no need to use the injector more than once")

        isInjectorUsed = true
        return getApplicationComponent().newViewComponent(ViewModule(this))
    }
}
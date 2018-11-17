package com.schoenherr.uiuxplayground.ui.base

import androidx.fragment.app.Fragment
import com.schoenherr.uiuxplayground.PlaygroundApplication
import com.schoenherr.uiuxplayground.di.application.ApplicationComponent
import com.schoenherr.uiuxplayground.di.view.ViewComponent
import com.schoenherr.uiuxplayground.di.view.ViewModule

abstract class BaseFragment: Fragment() {

    protected val name: String = this.javaClass.simpleName

    private var isInjectorUsed: Boolean = false

    private fun getApplicationComponent(): ApplicationComponent = (activity!!.application as PlaygroundApplication).applicationComponent

    protected fun getViewComponent(): ViewComponent {
        if (isInjectorUsed) throw RuntimeException("there is no need to use the injector more than once")

        isInjectorUsed = true
        return getApplicationComponent().newViewComponent(ViewModule(activity!!))
    }
}
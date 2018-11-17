package com.schoenherr.uiuxplayground.di.application

import com.schoenherr.uiuxplayground.di.view.ViewComponent
import com.schoenherr.uiuxplayground.di.view.ViewModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun newViewComponent(viewModule: ViewModule): ViewComponent
}
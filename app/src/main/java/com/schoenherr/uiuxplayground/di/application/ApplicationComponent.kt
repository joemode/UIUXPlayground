package com.schoenherr.uiuxplayground.di.application

import com.schoenherr.uiuxplayground.di.view.ViewComponent
import com.schoenherr.uiuxplayground.di.view.ViewModule
import com.schoenherr.uiuxplayground.di.model.ModelComponent
import com.schoenherr.uiuxplayground.di.model.ModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
//    fun inject(application: PlaygroundApplication)
    fun newViewComponent(viewModule: ViewModule): ViewComponent
    fun newModelComponent(viewModelModule: ModelModule): ModelComponent
}
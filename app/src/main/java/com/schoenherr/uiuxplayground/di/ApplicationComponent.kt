package com.schoenherr.uiuxplayground.di

import com.schoenherr.uiuxplayground.PlaygroundApplication
import com.schoenherr.uiuxplayground.ui.MainActivity
import com.schoenherr.uiuxplayground.ui.styledmap.StyledMapFragment
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(application: PlaygroundApplication)
    fun inject(activity: MainActivity)
    fun inject(fragment: StyledMapFragment)
}
package com.schoenherr.uiuxplayground.di

import androidx.databinding.DataBindingComponent
import com.schoenherr.uiuxplayground.di.application.ApplicationComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface DaggerBindingComponent: DataBindingComponent {
}
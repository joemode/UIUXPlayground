package com.schoenherr.uiuxplayground.di.model

import com.schoenherr.uiuxplayground.ui.recyclergrid.GridRecyclerViewModel
import dagger.Subcomponent
import javax.inject.Singleton

@Subcomponent(modules = [ModelModule::class])
interface ModelComponent {
    fun inject(gridRecyclerViewModel: GridRecyclerViewModel)
}
package com.schoenherr.uiuxplayground.di.view

import com.schoenherr.uiuxplayground.data.WordRepository
import com.schoenherr.uiuxplayground.ui.MainActivity
import com.schoenherr.uiuxplayground.ui.recyclergrid.GridRecyclerFragment
import com.schoenherr.uiuxplayground.ui.styledmap.StyledMapFragment
import dagger.Subcomponent

@Subcomponent(modules = [ViewModule::class])
interface ViewComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(gridRecyclerFragment: GridRecyclerFragment)
    fun inject(styledMapFragment: StyledMapFragment)
//    fun inject(wordRepository: WordRepository)
}
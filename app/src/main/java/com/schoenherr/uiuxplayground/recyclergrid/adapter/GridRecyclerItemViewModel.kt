package com.schoenherr.uiuxplayground.recyclergrid.adapter

import android.databinding.ObservableField

class GridRecyclerItemViewModel(string: String) {

    val stringField: ObservableField<String> = ObservableField(string)

}
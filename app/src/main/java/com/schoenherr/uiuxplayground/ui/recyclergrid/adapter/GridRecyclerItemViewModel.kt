package com.schoenherr.uiuxplayground.ui.recyclergrid.adapter

import androidx.databinding.ObservableField

class GridRecyclerItemViewModel(string: String) {

    val stringField: ObservableField<String> = ObservableField(string)
}
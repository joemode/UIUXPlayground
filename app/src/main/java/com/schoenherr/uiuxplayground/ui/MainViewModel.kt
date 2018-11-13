package com.schoenherr.uiuxplayground.ui

import androidx.lifecycle.ViewModel
import androidx.databinding.ObservableBoolean
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(view: MainView) : ViewModel() {

    var mainView : MainView = view
    val isLoading = ObservableBoolean(false)

    private val compositeDisposable : CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}
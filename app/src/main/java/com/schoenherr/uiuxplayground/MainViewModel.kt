package com.schoenherr.uiuxplayground

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
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
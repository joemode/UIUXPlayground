package com.schoenherr.uiuxplayground

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class SafeLiveData<T>(private val initValue: T): MutableLiveData<T>() {

    init {
        value = initValue
    }

    override fun getValue(): T = super.getValue() ?: initValue

    fun observe(owner: LifecycleOwner, body: (T) -> Unit) {
        observe(owner, Observer<T> {t -> body(t!!) })
    }
}
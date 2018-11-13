package com.schoenherr.uiuxplayground.ui.styledmap

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.schoenherr.uiuxplayground.data.DataManager
import javax.inject.Inject

class StyledMapViewModel : ViewModel(), // @Inject constructor(dataManager: DataManager) : ViewModel(),
        OnMapReadyCallback {


    fun<T: Any?> MutableLiveData<T>.default(initialValue: T) = apply { value = initialValue }

    val numClicks = MutableLiveData<String>().default("0")

    var clicks: Int = 0

    init {
        // Would need to retrieve value here from repo for useful
        // post-rotation usefulness
        numClicks.value = numClicks.value
    }

    override fun onMapReady(p0: GoogleMap?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    fun initializeMap(callback: (String) -> Unit) {
        callback("ready")
    }

    fun fabClick() {
//        numClicks.value = (++clicks).toString()
        numClicks.postValue((++clicks).toString())
    }
}
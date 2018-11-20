package com.schoenherr.uiuxplayground.ui.recyclergrid

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.google.android.gms.maps.model.LatLng
import com.schoenherr.uiuxplayground.utils.SafeLiveData
import com.schoenherr.uiuxplayground.utils.SingleLiveEvent
import com.schoenherr.uiuxplayground.data.DataManager
import com.schoenherr.uiuxplayground.data.Word
import com.schoenherr.uiuxplayground.data.WordRepository
import javax.inject.Inject

class GridRecyclerViewModel @Inject constructor(application: Application,
                                                private val dataManager: DataManager,
                                                private val repository: WordRepository)
    : AndroidViewModel(application) {

    val allWords: LiveData<List<Word>> = repository.allWords

    private val _neverNull = SafeLiveData("thing")
    val neverNull: LiveData<String>
        get() = _neverNull

    fun setNeverNull(new: String) {
        _neverNull.value = new
    }

    // Dialog Action
    private val _openNewWordDialog = SingleLiveEvent<String>()
    val openNewWordDialog: LiveData<String>
        get() = _openNewWordDialog

    // New Location
    private var location = LatLng(0.0, 0.0)
    private var radius = 5000
    private var hasMarker = false
    private val _updateLocation =
        SafeLiveData(LocationUpdate(location, radius, hasMarker))
    val updateLocation: LiveData<LocationUpdate>
        get() = _updateLocation

    fun insert(word: Word) {
        repository.insert(word)
    }

    fun delete(word: Word) {
        repository.delete(word)
    }

    fun addItemClick() {
        _openNewWordDialog.call()
    }



    data class LocationUpdate(val location: LatLng, val radius: Int, val hasMarker: Boolean)
}
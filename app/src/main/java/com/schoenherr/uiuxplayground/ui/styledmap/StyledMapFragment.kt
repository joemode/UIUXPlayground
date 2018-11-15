package com.schoenherr.uiuxplayground.ui.styledmap

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapsInitializer
import com.schoenherr.uiuxplayground.R
import com.schoenherr.uiuxplayground.data.DataManagerImpl
import com.schoenherr.uiuxplayground.databinding.FragmentStyledMapBinding
import com.schoenherr.uiuxplayground.ui.base.BaseFragment
import javax.inject.Inject

//import org.koin.androidx.viewmodel.ext.android.viewModel

class StyledMapFragment : BaseFragment() {

    val vm: StyledMapViewModel = StyledMapViewModel()

    private lateinit var binding: FragmentStyledMapBinding
    private lateinit var googleMap: GoogleMap

//    lateinit var mapView: MapView

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
////        viewModel = StyledMapViewModel()
//    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_styled_map, container, false)
        val view: View = binding.root
//        initializeMapView(savedInstanceState)

        binding.viewModel = vm
        binding.setLifecycleOwner(viewLifecycleOwner)
        return view
    }

    private fun initMap() {
        vm.initializeMap { thing ->
            Log.d("StyledMapFragment", thing)
        }
    }

    private fun initializeMapView(savedInstanceState: Bundle?) {
        binding.mapView.onCreate(savedInstanceState)
        binding.mapView.onResume()

        MapsInitializer.initialize(activity?.applicationContext)

        binding.mapView.getMapAsync { map ->
            googleMap = map
//            googleMap.isMyLocationEnabled = true


        }
    }

}
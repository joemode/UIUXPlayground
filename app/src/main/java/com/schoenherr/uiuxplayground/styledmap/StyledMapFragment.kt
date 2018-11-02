package com.schoenherr.uiuxplayground.styledmap

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.MapsInitializer
import com.schoenherr.uiuxplayground.R
import com.schoenherr.uiuxplayground.databinding.FragmentStyledMapBinding
import kotlinx.android.synthetic.main.fragment_styled_map.view.*

class StyledMapFragment : Fragment() {

    private lateinit var viewModel: StyledMapViewModel
    private lateinit var binding: FragmentStyledMapBinding
    private lateinit var googleMap: GoogleMap

//    lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = StyledMapViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_styled_map, container, false)
        val view: View = binding.root
        initializeMapView(savedInstanceState)
        // more stuff
        return view
    }

    private fun initializeMapView(savedInstanceState: Bundle?) {
        binding.mapView.onCreate(savedInstanceState)
        binding.mapView.onResume()

        MapsInitializer.initialize(activity?.applicationContext)

        binding.mapView.getMapAsync { map ->
            googleMap = map
            googleMap.isMyLocationEnabled = true


        }
    }

}
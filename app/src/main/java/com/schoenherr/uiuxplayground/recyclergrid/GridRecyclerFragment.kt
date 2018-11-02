package com.schoenherr.uiuxplayground.recyclergrid

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.schoenherr.uiuxplayground.R
import com.schoenherr.uiuxplayground.databinding.FragmentGridRecyclerBinding
import com.schoenherr.uiuxplayground.recyclergrid.adapter.GridRecyclerAdapter

class GridRecyclerFragment : Fragment() {

    private lateinit var viewModel: GridRecyclerViewModel
    private lateinit var binding: FragmentGridRecyclerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = GridRecyclerViewModel()
    }

    override
    fun onCreateView(inflater: LayoutInflater,
                     container: ViewGroup?,
                     savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_grid_recycler, container, false)
        val view: View = binding.root

        binding.viewModel = viewModel
        // TODO: Setup recycler
        val layoutManager: GridLayoutManager = GridLayoutManager(activity, 2)
        val list: List<String> = listOf("One", "Two", "Three", "Four")
        val gridAdapter: GridRecyclerAdapter = GridRecyclerAdapter(list)
        binding.recycler.adapter = gridAdapter
        binding.recycler.layoutManager = layoutManager
        return view
    }
}
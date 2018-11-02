package com.schoenherr.uiuxplayground.recyclergrid.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.schoenherr.uiuxplayground.databinding.GridRecyclerItemBinding

class GridRecyclerAdapter(list: List<String>): RecyclerView.Adapter<GridRecyclerAdapter.ViewHolder>() {

    var itemList: MutableList<String> = list.toMutableList()
    fun addItems(list: List<String>) {
        itemList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val gridRecyclerItemBinding: GridRecyclerItemBinding = GridRecyclerItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(gridRecyclerItemBinding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(position)
    }


    inner class ViewHolder(binding: GridRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val gridRecyclerItemBinding: GridRecyclerItemBinding = binding
        fun onBind(position: Int) {
            val string: String = itemList[position]
            val viewModel = GridRecyclerItemViewModel(string)
            gridRecyclerItemBinding.viewModel = viewModel
        }
    }
}
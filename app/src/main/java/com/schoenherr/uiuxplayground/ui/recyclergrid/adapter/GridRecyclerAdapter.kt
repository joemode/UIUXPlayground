package com.schoenherr.uiuxplayground.ui.recyclergrid.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.schoenherr.uiuxplayground.data.Word
import com.schoenherr.uiuxplayground.databinding.GridRecyclerItemBinding

class GridRecyclerAdapter(list: List<Word>, private val callback: AdapterActionCallback): RecyclerView.Adapter<GridRecyclerAdapter.GridViewHolder>() {

    var itemList: MutableList<Word> = list.toMutableList()

    fun setItems(list: List<Word>) {
        itemList = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val gridRecyclerItemBinding: GridRecyclerItemBinding = GridRecyclerItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return GridViewHolder(gridRecyclerItemBinding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        holder.onBind(position)
    }


    inner class GridViewHolder(binding: GridRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val gridRecyclerItemBinding: GridRecyclerItemBinding = binding
        fun onBind(position: Int) {
            val thisWord = itemList[position]
            val string: String = thisWord.word
            val viewModel = GridRecyclerItemViewModel(string)
            gridRecyclerItemBinding.viewModel = viewModel

            gridRecyclerItemBinding.itemTile.setOnLongClickListener {
                callback.onAdapterDelete(thisWord)
                return@setOnLongClickListener true
            }

            gridRecyclerItemBinding.itemTile.setOnClickListener {
                callback.onAdapterClick(thisWord)
            }
        }
    }

    interface AdapterActionCallback {
        fun onAdapterClick(word: Word)
        fun onAdapterDelete(word: Word)
    }
}
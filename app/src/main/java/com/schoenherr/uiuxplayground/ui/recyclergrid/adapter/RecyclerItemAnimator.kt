package com.schoenherr.uiuxplayground.ui.recyclergrid.adapter

import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView

class RecyclerItemAnimator: DefaultItemAnimator() {

    override fun canReuseUpdatedViewHolder(viewHolder: RecyclerView.ViewHolder): Boolean {
        return true
    }

    override fun recordPreLayoutInformation(
        state: RecyclerView.State,
        viewHolder: RecyclerView.ViewHolder,
        changeFlags: Int,
        payloads: MutableList<Any>
    ): ItemHolderInfo {
        return super.recordPreLayoutInformation(state, viewHolder, changeFlags, payloads)
    }

    override fun animateAppearance(
        viewHolder: RecyclerView.ViewHolder,
        preLayoutInfo: ItemHolderInfo?,
        postLayoutInfo: ItemHolderInfo
    ): Boolean {
        return super.animateAppearance(viewHolder, preLayoutInfo, postLayoutInfo)
    }

    override fun animateRemove(holder: RecyclerView.ViewHolder?): Boolean {
        return super.animateRemove(holder)
    }
}
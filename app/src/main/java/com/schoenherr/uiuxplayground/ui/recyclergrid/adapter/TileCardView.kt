package com.schoenherr.uiuxplayground.ui.recyclergrid.adapter

import android.content.Context
import androidx.cardview.widget.CardView
import android.util.AttributeSet

class TileCardView : androidx.cardview.widget.CardView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }
}
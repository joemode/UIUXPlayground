package com.schoenherr.uiuxplayground.recyclergrid.adapter

import android.content.Context
import android.support.v7.widget.CardView
import android.util.AttributeSet

class TileCardView : CardView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }
}
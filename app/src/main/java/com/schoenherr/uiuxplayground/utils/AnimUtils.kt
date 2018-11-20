package com.schoenherr.uiuxplayground.utils

import android.content.Context
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils

import com.schoenherr.uiuxplayground.R

object AnimUtils {

    /**
     * Animate a view so that it slides out to the left and remains invisible
     */
    fun slideOutToLeft(context: Context, view: View, delay: Long = 0) {
        runSimpleAnimation(context, view, R.anim.slide_to_left, delay)
        view.visibility = View.INVISIBLE
    }

    /**
     * Animate a view so that it slides out to the right and remains invisible
     */
    fun slideOutToRight(context: Context, view: View, delay: Long = 0) {
        runSimpleAnimation(context, view, R.anim.slide_to_right, delay)
        view.visibility = View.INVISIBLE
    }

    fun slideInFromTop(context: Context, view: View, delay: Long = 0) {
        runSimpleAnimation(context, view, R.anim.slide_from_top, delay)
    }

    //TODO slideInFromLeft & slideInFromRight

    private fun runSimpleAnimation(context: Context,
                                   view: View,
                                   animId: Int,
                                   delay: Long) {
        val animation: Animation = AnimationUtils.loadAnimation(context, animId)
        animation.startOffset = delay
        view.startAnimation(animation)
    }
}
package ru.sinx.coins.extensions

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import kotlin.math.abs


class SpinnerLayoutManager(context: Context?) : LinearLayoutManager(context) {

    private var scaleDownBy = 0.66f
    private var scaleDownDistance = 0.9f
    private var changeAlpha = true

    private var scrollStopListener: onScrollStopListener? = null

    override fun onLayoutChildren(recycler: Recycler?, state: RecyclerView.State?) {
        super.onLayoutChildren(recycler, state)
        scaleDownView()
    }

    override fun scrollVerticallyBy(dy: Int, recycler: Recycler?, state: RecyclerView.State?): Int {
        val orientation = orientation
        return if (orientation == VERTICAL) {
            val scrolled = super.scrollVerticallyBy(dy, recycler, state)
            scaleDownView()
            scrolled
        } else 0
    }

    private fun scaleDownView() {
        val mid = height / 2.0f
        val unitScaleDownDist = scaleDownDistance * mid
        for (i in 0 until childCount) {
            getChildAt(i)?.let { child ->
                val childMid = (getDecoratedTop(child) + getDecoratedBottom(child)) / 2.0f
                val scale =
                    1.0f + -1 * scaleDownBy * unitScaleDownDist.coerceAtMost(abs(mid - childMid)) / unitScaleDownDist
                child.scaleX = scale
                child.scaleY = scale
                if (changeAlpha) {
                    child.alpha = scale
                }
            }
        }
    }

    override fun onScrollStateChanged(state: Int) {
        super.onScrollStateChanged(state)
        if (state == 0) {
            if (scrollStopListener != null) {
                var selected = 0
                var lastHeight = 0f
                for (i in 0 until childCount) {
                    getChildAt(i)?.let { child ->
                        if (lastHeight < child.scaleY) {
                            lastHeight = child.scaleY
                            selected = i
                        }
                    }
                }
                scrollStopListener?.selectedView(getChildAt(selected))
            }
        }
    }

    fun getScaleDownBy(): Float {
        return scaleDownBy
    }

    fun setScaleDownBy(scaleDownBy: Float) {
        this.scaleDownBy = scaleDownBy
    }

    fun getScaleDownDistance(): Float {
        return scaleDownDistance
    }

    fun setScaleDownDistance(scaleDownDistance: Float) {
        this.scaleDownDistance = scaleDownDistance
    }

    fun isChangeAlpha(): Boolean {
        return changeAlpha
    }

    fun setChangeAlpha(changeAlpha: Boolean) {
        this.changeAlpha = changeAlpha
    }

    fun setOnScrollStopListener(onScrollStopListener: onScrollStopListener?) {
        this.scrollStopListener = onScrollStopListener
    }

    interface onScrollStopListener {
        fun selectedView(view: View?)
    }

}
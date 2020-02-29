package ru.sinx.coins.ui.addpair.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.sinx.coins.R
import ru.sinx.coins.utils.DividerPairUI

class SpinnerPairHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvPair = view.findViewById<TextView>(R.id.tvItemAddPair)

    fun bind(pair: DividerPairUI) {
        tvPair.text = pair.toString()
    }

}

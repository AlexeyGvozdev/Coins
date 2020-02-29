package ru.sinx.coins.ui.addpair.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.sinx.coins.R
import ru.sinx.coins.extensions.inflate
import ru.sinx.coins.utils.DividerPairUI

class SpinnerPairAdapter : RecyclerView.Adapter<SpinnerPairHolder>() {

    private val listPair = mutableListOf<DividerPairUI>()

    fun setListPair(lisPair: List<DividerPairUI>) {
        this.listPair.clear()
        this.listPair.addAll(lisPair)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpinnerPairHolder {
        return SpinnerPairHolder(parent.inflate(R.layout.item_add_pair))
    }

    override fun getItemCount() = listPair.size

    override fun onBindViewHolder(holder: SpinnerPairHolder, position: Int) {
        holder.bind(listPair[position])
    }
}
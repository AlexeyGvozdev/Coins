package ru.sinx.coins.ui.pairs.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.sinx.coins.R
import ru.sinx.coins.extensions.inflate
import ru.sinx.coins.utils.PairCurrency
import ru.sinx.coins.utils.PairCurrencyWithBidTop

class PairsAdapter : RecyclerView.Adapter<PairHolder>() {
    private val listPair = mutableListOf<PairCurrencyWithBidTop>()

    fun setListPair(listPair: List<PairCurrencyWithBidTop>) {
        this.listPair.clear()
        this.listPair.addAll(listPair)
        notifyDataSetChanged()
    }

    private var onClickPair: (PairCurrency) -> Unit = {}

    fun setOnClickListener(onClickPair: (PairCurrency) -> Unit) {
        this.onClickPair = onClickPair
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PairHolder {
       return PairHolder(parent.inflate(R.layout.item_pair))
    }

    override fun getItemCount() = listPair.size

    override fun onBindViewHolder(holder: PairHolder, position: Int) {
        holder.bind(listPair[position], onClickPair)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        onClickPair = {}
        listPair.clear()
        super.onDetachedFromRecyclerView(recyclerView)
    }
}
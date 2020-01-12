package ru.sinx.coins.ui.pairs.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.sinx.coins.R
import ru.sinx.coins.utils.DividerPairUI
import ru.sinx.coins.utils.PairCurrency
import ru.sinx.coins.utils.PairCurrencyWithBidTop

class PairHolder(view: View): RecyclerView.ViewHolder(view) {

    private val tvNamePair = view.findViewById<TextView>(R.id.tv_name_pair)
    private val tvPricePair = view.findViewById<TextView>(R.id.tv_price_pair)

    fun bind(
        pairCurrencyWithBidTop: PairCurrencyWithBidTop,
        onClickPair: (PairCurrency) -> Unit
    ) {
        with(pairCurrencyWithBidTop) {
            itemView.setOnClickListener { onClickPair(pairCurrency) }
            tvNamePair.text = DividerPairUI(pairCurrency).toString()
            tvPricePair.text = String.format("%.2f", bidTop.toFloat())
        }
    }
}

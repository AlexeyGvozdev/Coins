package ru.sinx.coins.utils

class DividerPairApi(private val pairCurrency: PairCurrency) {

    private val divider = "_"

    override fun toString(): String {
        return pairCurrency.first.toString() + divider + pairCurrency.second.toString()
    }
}
package ru.sinx.coins.utils

class DividerPairUI(private val pairCurrency: PairCurrency) {

    private val divider = "/"

    override fun toString(): String {
        return "${pairCurrency.first}$divider${pairCurrency.second}"
    }
}
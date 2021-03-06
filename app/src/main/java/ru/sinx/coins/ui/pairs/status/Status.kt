package ru.sinx.coins.ui.pairs.status

import ru.sinx.coins.utils.PairCurrencyWithBidTop

sealed class Status {
    object Loading : Status()
    class Loaded(val data: List<PairCurrencyWithBidTop>) : Status()
    class Error(val msg: String) : Status()
    class LoadedRefresh(val data: List<PairCurrencyWithBidTop>) : Status()
    object Refresh : Status()
    object NotHavePairs : Status()
}
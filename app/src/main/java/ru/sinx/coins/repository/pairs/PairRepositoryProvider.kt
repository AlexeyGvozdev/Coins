package ru.sinx.coins.repository.pairs

import ru.sinx.coins.utils.PairCurrencyWithBidTop

interface PairRepositoryProvider {
    suspend fun fetchListPairs(): List<PairCurrencyWithBidTop>
}
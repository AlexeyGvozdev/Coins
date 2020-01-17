package ru.sinx.coins.repository.pairs

import ru.sinx.coins.di.services.api.Api
import ru.sinx.coins.utils.DividerPairApi
import ru.sinx.coins.utils.PairCurrency
import ru.sinx.coins.utils.PairCurrencyWithBidTop

class PairRepositoryProviderImpl(val api: Api) : PairRepositoryProvider {
    override suspend fun fetchListPairs(listPair: List<PairCurrency>): List<PairCurrencyWithBidTop> {
        return listPair.map {
            PairCurrencyWithBidTop(
                pairCurrency = it,
                bidTop = api.fetchPair(DividerPairApi(it).toString()).bidTop
            )
        }
    }
}
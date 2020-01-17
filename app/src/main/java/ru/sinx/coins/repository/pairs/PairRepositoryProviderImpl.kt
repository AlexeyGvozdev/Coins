package ru.sinx.coins.repository.pairs

import kotlinx.coroutines.delay
import ru.sinx.coins.di.services.api.Api
import ru.sinx.coins.utils.Currency
import ru.sinx.coins.utils.DividerPairApi
import ru.sinx.coins.utils.PairCurrency
import ru.sinx.coins.utils.PairCurrencyWithBidTop

class PairRepositoryProviderImpl(private val api: Api) : PairRepositoryProvider {
    override suspend fun fetchListPairs(listPair: List<PairCurrency>): List<PairCurrencyWithBidTop> {
        return listPair.map {
            PairCurrencyWithBidTop(
                pairCurrency = it,
                bidTop = api.fetchPair(DividerPairApi(it).toString()).bidTop
            )
        }
    }

    override suspend fun fetchLocalPairs(): List<PairCurrency> {
        delay(1000)
        return listOf(
//            PairCurrency(Currency("BTC"), Currency("USD")),
//            PairCurrency(Currency("BTC"), Currency("RUB")),
//            PairCurrency(Currency("XRP"), Currency("USD")),
//            PairCurrency(Currency("XRP"), Currency("RUB")),
//            PairCurrency(Currency("ETH"), Currency("USD")),
//            PairCurrency(Currency("ETH"), Currency("RUB"))
        )
    }
}
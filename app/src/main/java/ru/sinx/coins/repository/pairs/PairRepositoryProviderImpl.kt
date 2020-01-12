package ru.sinx.coins.repository.pairs

import kotlinx.coroutines.delay
import ru.sinx.coins.utils.Currency
import ru.sinx.coins.utils.PairCurrency
import ru.sinx.coins.utils.PairCurrencyWithBidTop

class PairRepositoryProviderImpl: PairRepositoryProvider {
    override suspend fun fetchListPairs(): List<PairCurrencyWithBidTop> {
        delay(2000)
        return listOf(
            PairCurrencyWithBidTop(pairCurrency = PairCurrency(Currency("BTC"), Currency("USD")), bidTop = 1.4),
            PairCurrencyWithBidTop(pairCurrency = PairCurrency(Currency("BTC"), Currency("RUB")), bidTop = 1.5),
            PairCurrencyWithBidTop(pairCurrency = PairCurrency(Currency("XRP"), Currency("USD")), bidTop = 1.6),
            PairCurrencyWithBidTop(pairCurrency = PairCurrency(Currency("XRP"), Currency("RUB")), bidTop = 1.7),
            PairCurrencyWithBidTop(pairCurrency = PairCurrency(Currency("ETH"), Currency("USD")), bidTop = 1.8),
            PairCurrencyWithBidTop(pairCurrency = PairCurrency(Currency("ETH"), Currency("RUB")), bidTop = 1.9)
        )
    }
}
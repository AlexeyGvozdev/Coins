package ru.sinx.coins

import org.junit.Assert
import org.junit.Test
import ru.sinx.coins.utils.Currency
import ru.sinx.coins.utils.DividerPairApi
import ru.sinx.coins.utils.DividerPairUI
import ru.sinx.coins.utils.PairCurrency

class PairsTest {

    @Test
    fun additional_two_coins_to_api() {
        val btc = "BTC"
        val rub = "RUB"
        Assert.assertEquals(
            "${btc}_$rub",
            DividerPairApi(PairCurrency(Currency(btc), Currency(rub))).toString()
        )
    }

    @Test
    fun additional_two_coins_to_ui() {
        val btc = "BTC"
        val rub = "RUB"
        Assert.assertEquals(
            "${btc}/$rub",
            DividerPairUI(PairCurrency(Currency(btc), Currency(rub))).toString()
        )
    }

}
package ru.sinx.coins.di.services.api

import kotlinx.coroutines.delay
import retrofit2.http.GET
import retrofit2.http.Query
import ru.sinx.coins.di.services.api.response.BidTop

interface Api {

    @GET("/")
    suspend fun fetchPair(@Query("pair") pair: String): BidTop

    @GET("/")
    suspend fun fetchCurrency(): List<String>

    class FakeApi() : Api {
        override suspend fun fetchPair(pair: String): BidTop {
            delay(1000)
            return BidTop(Math.random() * 100)
        }

        override suspend fun fetchCurrency(): List<String> {
            delay(1000)
            return listOf("BTC", "RUB", "EUR", "XRP", "USD")
        }

    }

}
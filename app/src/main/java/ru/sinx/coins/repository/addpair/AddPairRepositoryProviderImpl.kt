package ru.sinx.coins.repository.addpair

import kotlinx.coroutines.delay
import ru.sinx.coins.di.services.api.Api
import javax.inject.Inject

class AddPairRepositoryProviderImpl @Inject constructor(private val api: Api) : AddPairRepositoryProvider{
    override suspend fun loadCurrency(): List<String> {
        delay(1000)
        return listOf(
            "BTC",
            "RUB",
            "XRP",
            "EUR",
            "USD"
        )
    }
}
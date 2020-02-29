package ru.sinx.coins.repository.addpair

interface AddPairRepositoryProvider {
    suspend fun loadCurrency() : List<String>
}
package ru.sinx.coins.di.modules

import dagger.Module
import dagger.Provides
import ru.sinx.coins.di.services.api.Api
import ru.sinx.coins.repository.addpair.AddPairRepositoryProvider
import ru.sinx.coins.repository.addpair.AddPairRepositoryProviderImpl
import ru.sinx.coins.repository.pairs.PairRepositoryProvider
import ru.sinx.coins.repository.pairs.PairRepositoryProviderImpl

@Module
class RepositoryModule {

    @Provides
    fun providePairRepository(api: Api) : PairRepositoryProvider {
        return PairRepositoryProviderImpl(api)
    }

    @Provides
    fun provideAddPairRepository(api: Api): AddPairRepositoryProvider {
        return AddPairRepositoryProviderImpl(api)
    }
}
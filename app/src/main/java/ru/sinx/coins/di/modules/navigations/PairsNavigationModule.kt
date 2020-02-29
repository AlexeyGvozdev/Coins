package ru.sinx.coins.di.modules.navigations

import dagger.Module
import dagger.Provides
import ru.sinx.coins.navigation.pairs.implementation.PairNavCommandProviderImpl
import ru.sinx.coins.navigation.pairs.provider.PairNavCommandProvider

@Module
class PairsNavigationModule {

    @Provides
    fun providePairNavCommandProvider(): PairNavCommandProvider {
        return PairNavCommandProviderImpl()
    }
}
package ru.sinx.coins.di.modules

import dagger.Module
import dagger.Provides
import ru.sinx.coins.di.services.api.Api
import ru.sinx.coins.navigation.pairs.provider.PairNavCommandProvider
import ru.sinx.coins.repository.pairs.PairRepositoryProvider
import ru.sinx.coins.ui.pairs.viewmodel.PairsViewModule

@Module
class ViewModelModule {


    @Provides
    fun providePairViewModel(pairRepositoryProvider: PairRepositoryProvider, pairNavCommandProvider: PairNavCommandProvider ): PairsViewModule {
        return PairsViewModule(pairRepositoryProvider, pairNavCommandProvider)
    }

}
package ru.sinx.coins.di.modules.navigations

import dagger.Module
import dagger.Provides
import ru.sinx.coins.navigation.addpair.provider.AddPairNavCommandProvider
import ru.sinx.coins.navigation.addpair.implementation.AddPairNavCommandProviderImpl

@Module
class AddPairNavigationModule {

    @Provides
    fun provideAddPairCommandProvider(): AddPairNavCommandProvider {
        return AddPairNavCommandProviderImpl()
    }

}

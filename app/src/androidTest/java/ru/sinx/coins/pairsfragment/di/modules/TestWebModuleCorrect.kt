package ru.sinx.coins.pairsfragment.di.modules

import dagger.Module
import dagger.Provides
import ru.sinx.coins.di.services.api.Api

@Module
class TestWebModuleCorrect {

    @Provides
    fun provideApi() : Api {
        return Api.FakeApiCorrect()
    }

}
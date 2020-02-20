package ru.sinx.coins.pairsfragment.di

import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector
import ru.sinx.coins.container.ContainerActivity
import ru.sinx.coins.di.modules.ActivityModule
import ru.sinx.coins.di.modules.RepositoryModule
import ru.sinx.coins.di.modules.ViewModelModule
import ru.sinx.coins.di.modules.WebModule
import ru.sinx.coins.di.modules.fragment.PairsModule
import ru.sinx.coins.di.scope.ActivityScope
import ru.sinx.coins.pairsfragment.di.modules.TestWebModuleCorrect

@Module(
    includes = [
        AndroidInjectionModule::class,
        TestWebModuleCorrect::class,
        ViewModelModule::class,
        RepositoryModule::class,
        PairsModule::class]
)
interface TestApplicationModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    fun activityInjector(): ContainerActivity
}

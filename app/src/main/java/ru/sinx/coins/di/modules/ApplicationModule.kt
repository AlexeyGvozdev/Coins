package ru.sinx.coins.di.modules

import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector
import ru.sinx.coins.MainActivity
import ru.sinx.coins.di.modules.fragment.AddPairModule
import ru.sinx.coins.di.modules.fragment.PairsModule
import ru.sinx.coins.di.scope.ActivityScope
import ru.sinx.coins.ui.pairs.fragment.PairsFragment

@Module(includes = [
    AndroidInjectionModule::class,
    WebModule::class,
    ViewModelModule::class,
    RepositoryModule::class,
    PairsModule::class,
    AddPairModule::class])
interface ApplicationModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    fun activityInjector(): MainActivity
}
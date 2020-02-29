package ru.sinx.coins.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.sinx.coins.di.modules.fragment.AddPairModule
import ru.sinx.coins.di.modules.fragment.PairsModule
import ru.sinx.coins.di.scope.FragmentScope
import ru.sinx.coins.ui.addpair.fragment.AddPairFragment
import ru.sinx.coins.ui.pairs.fragment.PairsFragment

@Module
interface ActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [PairsModule::class])
    fun pairsFragmentInjector() : PairsFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [AddPairModule::class])
    fun addPairsFragmentInjector() : AddPairFragment

}
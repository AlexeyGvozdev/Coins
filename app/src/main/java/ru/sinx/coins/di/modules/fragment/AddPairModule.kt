package ru.sinx.coins.di.modules.fragment

import dagger.Module
import ru.sinx.coins.di.modules.navigations.AddPairNavigationModule

@Module(includes = [AddPairNavigationModule::class])
interface AddPairModule

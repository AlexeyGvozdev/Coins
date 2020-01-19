package ru.sinx.coins.di.modules.fragment

import dagger.Module
import ru.sinx.coins.di.modules.navigations.PairsNavigationModule

@Module(includes = [PairsNavigationModule::class])
interface PairsModule
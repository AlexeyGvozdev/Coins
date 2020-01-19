package ru.sinx.coins

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ru.sinx.coins.di.DaggerApplicationComponent


class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent
            .factory()
            .create(this)
    }

}
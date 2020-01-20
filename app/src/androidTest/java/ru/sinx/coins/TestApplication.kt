package ru.sinx.coins

import ru.sinx.coins.di.ApplicationComponent

class TestApplication: App() {

    override fun onCreate() {
        super.onCreate()
    }

    fun setComponent(component: ApplicationComponent) {
        component.inject(this)
    }

}
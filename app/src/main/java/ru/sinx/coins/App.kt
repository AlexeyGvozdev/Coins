package ru.sinx.coins

import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import ru.sinx.coins.di.DaggerApplicationComponent
import javax.inject.Inject


open class App : Application(), HasAndroidInjector {

    override fun onCreate() {
        super.onCreate()
        DaggerApplicationComponent
            .factory()
            .create(this)
            .inject(this)
    }

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector() = dispatchingActivityInjector

}
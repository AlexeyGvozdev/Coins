package ru.sinx.coins.pairsfragment.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import ru.sinx.coins.App
import ru.sinx.coins.di.ApplicationComponent
import ru.sinx.coins.di.modules.ApplicationModule
import ru.sinx.coins.di.scope.ApplicationScope

@ApplicationScope
@Component(
    modules = [
        TestApplicationModule::class
    ]
)
interface TestApplicationComponent : ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance appContext: Context): TestApplicationComponent
    }
}
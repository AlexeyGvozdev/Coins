package ru.sinx.coins.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import ru.sinx.coins.App
import ru.sinx.coins.di.modules.ApplicationModule
import ru.sinx.coins.di.scope.ApplicationScope

@ApplicationScope
@Component(
    modules = [
        ApplicationModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance appContext: Context): ApplicationComponent
    }
}
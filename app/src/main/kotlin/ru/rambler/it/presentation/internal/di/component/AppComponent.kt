package ru.rambler.it.presentation.internal.di.component

import android.content.Context
import dagger.Component
import ru.rambler.it.presentation.internal.di.module.AppModule
import ru.rambler.it.presentation.internal.di.module.DomainModule
import ru.rambler.it.presentation.internal.di.module.MainScreenModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, DomainModule::class))
interface AppComponent {
    fun getAppContext(): Context

    fun plus(mainScreenModule : MainScreenModule) : MainScreenSubcomponent

}

package ru.rambler.it.other.di.component

import android.content.Context
import dagger.Component
import ru.rambler.it.other.di.module.AppModule
import ru.rambler.it.other.di.module.DomainModule
import ru.rambler.it.other.di.module.MainScreenModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, DomainModule::class))
interface AppComponent {
    fun getAppContext(): Context

    fun plus(mainScreenModule : MainScreenModule) : MainScreenSubcomponent

}

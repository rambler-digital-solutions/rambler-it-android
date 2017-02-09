package ru.rambler.it.other.di

import ru.rambler.it.other.di.component.AppComponent
import ru.rambler.it.other.di.component.DaggerAppComponent
import ru.rambler.it.other.di.module.AppModule
import ru.rambler.it.presentation.RamblerITApplication
import java.util.*

private var appComponent: AppComponent? = null

fun initializeAppComponent(application: RamblerITApplication) {
    appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(application))
            .build()
}

fun getAppComponent(): AppComponent? {
    Objects.requireNonNull(appComponent, "appComponent is null")
    return appComponent
}
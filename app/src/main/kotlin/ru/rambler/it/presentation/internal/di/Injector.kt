package ru.rambler.it.presentation.internal.di

import ru.rambler.it.presentation.RamblerITApplication
import ru.rambler.it.presentation.internal.di.component.AppComponent
import ru.rambler.it.presentation.internal.di.component.DaggerAppComponent
import ru.rambler.it.presentation.internal.di.module.AppModule
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
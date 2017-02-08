package ru.rambler.it.other.di

import ru.rambler.it.other.di.component.AppComponent
import ru.rambler.it.other.di.component.DaggerAppComponent
import ru.rambler.it.other.di.component.DaggerMapperComponent
import ru.rambler.it.other.di.component.MapperComponent
import ru.rambler.it.other.di.module.AppModule
import ru.rambler.it.other.di.module.MapperModule
import ru.rambler.it.presentation.RamblerITApplication
import java.util.Objects

private var appComponent: AppComponent? = null
private var mapperComponent: MapperComponent? = null

fun initializeAppComponent(application: RamblerITApplication) {
    appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(application))
            .build();
}

fun getAppComponent(): AppComponent? {
    Objects.requireNonNull(appComponent, "appComponent is null")
    return appComponent;
}

fun initializeMapperComponent() {
    mapperComponent = DaggerMapperComponent.builder()
            .mapperModule(MapperModule())
            .build()
}

fun getMapperComponent(): MapperComponent? {
    Objects.requireNonNull(mapperComponent, "mapperComponent is null")
    return mapperComponent
}

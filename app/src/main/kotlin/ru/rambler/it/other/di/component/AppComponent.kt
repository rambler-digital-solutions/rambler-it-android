package ru.rambler.it.other.di.component

import android.content.Context
import dagger.Component
import ru.rambler.it.other.di.module.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun getAppContext(): Context
}

package ru.rambler.it.presentation

import android.app.Application
import ru.rambler.it.other.di.initializeAppComponent

class RamblerITApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeAppComponent(this)
    }
}
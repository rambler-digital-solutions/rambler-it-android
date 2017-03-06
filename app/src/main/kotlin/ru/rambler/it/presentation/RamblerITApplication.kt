package ru.rambler.it.presentation

import android.app.Application
import com.robohorse.rocketgame.RocketGame
import ru.rambler.it.other.di.initializeAppComponent

class RamblerITApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeAppComponent(this)
        RocketGame.initialize(this)
    }
}
package ru.rambler.it.other.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.rambler.it.data.network.ApiModule
import ru.rambler.it.data.network.NetworkDataProvider
import ru.rambler.it.data.network.NetworkDataProviderImpl
import ru.rambler.it.presentation.RamblerITApplication
import javax.inject.Singleton

@Module
class AppModule(private val application: RamblerITApplication) {

    @Provides
    @Singleton
    fun provideAppContext(): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideNetworkDataProvider(): NetworkDataProvider {
        return NetworkDataProviderImpl(ApiModule.itRamblerApi)
    }
}
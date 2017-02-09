package ru.rambler.it.other.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.rambler.it.data.cache.CacheProvider
import ru.rambler.it.data.cache.RealmCacheProvider
import ru.rambler.it.data.mappers.EventMapper
import ru.rambler.it.data.network.NetworkDataProvider
import ru.rambler.it.data.network.NetworkDataProviderImpl
import ru.rambler.it.domain.executor.JobExecutor
import ru.rambler.it.domain.executor.PostExecutionThread
import ru.rambler.it.domain.executor.ThreadExecutor
import ru.rambler.it.domain.executor.UIThread
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
        return NetworkDataProviderImpl(EventMapper())
    }

    @Provides
    @Singleton
    fun provideCacheProvider(): CacheProvider {
        return RealmCacheProvider()
    }

    @Provides
    @Singleton
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @Singleton
    internal fun providePostExecutionThread(uiThread: UIThread): PostExecutionThread {
        return uiThread
    }




}
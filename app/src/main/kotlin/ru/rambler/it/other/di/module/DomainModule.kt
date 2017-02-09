package ru.rambler.it.other.di.module

import dagger.Module
import ru.rambler.it.data.cache.CacheProvider
import ru.rambler.it.data.network.NetworkDataProvider
import ru.rambler.it.domain.executor.PostExecutionThread
import ru.rambler.it.domain.executor.ThreadExecutor
import ru.rambler.it.domain.interactors.EventsInteractor
import ru.rambler.it.domain.interactors.LocalEventsInteractor

@Module
class DomainModule {

    internal fun provideEventInteractor(networkDataProvider: NetworkDataProvider, cacheProvider: CacheProvider,
                                        threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread): EventsInteractor {

        return EventsInteractor(networkDataProvider, cacheProvider, threadExecutor, postExecutionThread)
    }

    internal fun provideLocalEventInteractor(networkDataProvider: NetworkDataProvider, cacheProvider: CacheProvider,
                                             threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread): LocalEventsInteractor {
        return LocalEventsInteractor(networkDataProvider, cacheProvider, threadExecutor, postExecutionThread)
    }

}
package ru.rambler.it.domain.interactors

import ru.rambler.it.data.cache.CacheProvider
import ru.rambler.it.data.network.NetworkDataProvider
import ru.rambler.it.domain.entities.Event
import ru.rambler.it.domain.executor.PostExecutionThread
import ru.rambler.it.domain.executor.ThreadExecutor
import rx.Observable
import javax.inject.Inject

/**
 * Created by a.tkachenko on 08.02.17.
 */
class LocalEventsInteractor @Inject constructor(networkProvider: NetworkDataProvider, cacheProvider: CacheProvider, threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread)
    : Interactor<Void, List<Event>>(networkProvider, cacheProvider, threadExecutor, postExecutionThread) {

    override fun buildObservable(param: Void?): Observable<List<Event>> {
        return cacheProvider.getEventsFromCache()
    }
}
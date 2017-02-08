package ru.rambler.it.domain.interactors

import ru.rambler.it.data.cache.CacheProvider
import ru.rambler.it.data.dbo.EventDbo
import ru.rambler.it.data.network.NetworkDataProvider
import ru.rambler.it.domain.executor.PostExecutionThread
import ru.rambler.it.domain.executor.ThreadExecutor
import rx.Observable

/**
 * Created by a.tkachenko on 08.02.17.
 */
class EventsInteractor(networkProvider: NetworkDataProvider, databaseProvider: CacheProvider, threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread)

    : Interactor<Void, List<EventDbo>>(networkProvider, databaseProvider, threadExecutor, postExecutionThread) {


    override fun buildObservable(param: Void): Observable<List<EventDbo>> {
        return networkProvider.getAllEvents().
    }
}
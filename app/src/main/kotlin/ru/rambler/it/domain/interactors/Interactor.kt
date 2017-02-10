package ru.rambler.it.domain.interactors

import ru.rambler.it.data.cache.CacheProvider
import ru.rambler.it.data.network.NetworkDataProvider
import ru.rambler.it.domain.executor.PostExecutionThread
import ru.rambler.it.domain.executor.ThreadExecutor
import rx.Observable
import rx.schedulers.Schedulers


abstract class Interactor<P, R>(protected val networkProvider: NetworkDataProvider,
                                protected val cacheProvider: CacheProvider,
                                protected val threadExecutor: ThreadExecutor,
                                protected val postExecutionThread: PostExecutionThread) {

    protected abstract fun buildObservable(param: P? = null): Observable<R>

    open fun getObservable(param: P? = null): Observable<R> {
        return buildObservable(param)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
    }

}

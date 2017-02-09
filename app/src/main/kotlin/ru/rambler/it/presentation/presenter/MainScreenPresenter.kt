package ru.rambler.it.presentation.presenter

import android.os.Bundle
import ru.rambler.it.domain.interactors.EventsInteractor
import ru.rambler.it.domain.interactors.LocalEventsInteractor
import ru.rambler.it.other.di.scope.PerActivity
import ru.rambler.it.presentation.view.interfaces.MainScreenView

@PerActivity
class MainScreenPresenter(view: MainScreenView, val eventsInteractor: EventsInteractor, val localEventsInteractor: LocalEventsInteractor)
    : BasePresenter<MainScreenView>(view) {

    override fun onCreate(state: Bundle?) {
        super.onCreate(state)
        eventsInteractor.getObservable().subscribe { println("ooololo" + it) }
    }
}
package ru.rambler.it.presentation.presenter

import android.os.Bundle
import ru.rambler.it.domain.entities.Event
import ru.rambler.it.domain.interactors.EventsInteractor
import ru.rambler.it.domain.interactors.LocalEventsInteractor
import ru.rambler.it.presentation.internal.di.scope.PerActivity
import ru.rambler.it.presentation.view.interfaces.MainScreenView
import java.util.*

@PerActivity
class MainScreenPresenter(view: MainScreenView, val eventsInteractor: EventsInteractor,
                          val localEventsInteractor: LocalEventsInteractor)
    : BasePresenter<MainScreenView>(view) {

    val events = ArrayList<Event>()

    override fun onCreate(state: Bundle?) {
        super.onCreate(state)
        eventsInteractor.getObservable().subscribe {
            events.clear()
            events.addAll(it)
            view.onEventsUpdated()
        }
    }


}
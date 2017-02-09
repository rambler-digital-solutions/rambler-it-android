package ru.rambler.it.other.di.module

import dagger.Module
import dagger.Provides
import ru.rambler.it.domain.interactors.EventsInteractor
import ru.rambler.it.domain.interactors.LocalEventsInteractor
import ru.rambler.it.other.di.scope.PerActivity
import ru.rambler.it.presentation.presenter.MainScreenPresenter
import ru.rambler.it.presentation.view.interfaces.MainScreenView

@Module
class MainScreenModule(var view: MainScreenView) {

    @Provides
    @PerActivity
    fun provideMainScreenPresenter(eventsInteractor: EventsInteractor, localEventsInteractor: LocalEventsInteractor): MainScreenPresenter {
        return MainScreenPresenter(view, eventsInteractor, localEventsInteractor)
    }
}
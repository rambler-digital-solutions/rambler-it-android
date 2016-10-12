package ru.rambler.it.other.di.module

import dagger.Module
import dagger.Provides
import ru.rambler.it.other.di.scope.PerActivity
import ru.rambler.it.presentation.presenter.MainScreenPresenter
import ru.rambler.it.presentation.view.interfaces.MainScreenView

@Module
class MainScreenModule(var view: MainScreenView) {

    @Provides
    @PerActivity
    fun provideMainScreenPresenter(): MainScreenPresenter {
        return MainScreenPresenter(view)
    }
}
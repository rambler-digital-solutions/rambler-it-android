package ru.rambler.it.presentation.presenter

import ru.rambler.it.other.di.scope.PerActivity
import ru.rambler.it.presentation.view.interfaces.MainScreenView

@PerActivity
class MainScreenPresenter(view: MainScreenView) : BasePresenter<MainScreenView>(view) {

}
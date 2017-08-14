package ru.rambler.it.presentation.main_screen

import ru.rambler.it.presentation.BaseView

interface MainScreenView : BaseView {
    fun openEventPager()

    fun openNavigationPage()

    fun openSearchPage()
}
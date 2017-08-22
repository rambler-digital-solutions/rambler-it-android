package ru.rambler.it.presentation.main_screen

import android.support.annotation.IdRes
import android.support.annotation.NonNull
import ru.rambler.it.R

class MainScreenPresenter(@NonNull val view: MainScreenView) {
    fun onNavigateTo(@IdRes buttonRes: Int) {
        when (buttonRes) {
            R.id.navigate_event_pager -> view.openEventPager()
            R.id.navigate_navigation -> view.openNavigationPage()
            R.id.navigate_search -> view.openSearchPage()
        }
    }
}
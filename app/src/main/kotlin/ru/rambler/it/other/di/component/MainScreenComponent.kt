package ru.rambler.it.other.di.component

import dagger.Component
import ru.rambler.it.other.di.module.MainScreenModule
import ru.rambler.it.other.di.scope.PerActivity
import ru.rambler.it.presentation.view.activities.MainActivity

@PerActivity
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(MainScreenModule::class))
interface MainScreenComponent {
    fun inject(activity: MainActivity)
}
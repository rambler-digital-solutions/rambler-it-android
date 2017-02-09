package ru.rambler.it.other.di.component

import dagger.Subcomponent
import ru.rambler.it.other.di.module.MainScreenModule
import ru.rambler.it.other.di.scope.PerActivity
import ru.rambler.it.presentation.view.activities.MainActivity

@PerActivity
@Subcomponent(modules = arrayOf(MainScreenModule::class))
interface MainScreenSubcomponent {
    fun inject(activity: MainActivity)
}
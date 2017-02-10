package ru.rambler.it.presentation.internal.di.component

import dagger.Subcomponent
import ru.rambler.it.presentation.internal.di.module.MainScreenModule
import ru.rambler.it.presentation.internal.di.scope.PerActivity
import ru.rambler.it.presentation.view.activities.MainActivity

@PerActivity
@Subcomponent(modules = arrayOf(MainScreenModule::class))
interface MainScreenSubcomponent {
    fun inject(activity: MainActivity)
}
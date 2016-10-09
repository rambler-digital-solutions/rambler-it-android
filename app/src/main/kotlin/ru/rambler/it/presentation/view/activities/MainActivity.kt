package ru.rambler.it.presentation.view.activities

import android.os.Bundle
import ru.rambler.it.R
import ru.rambler.it.other.di.component.DaggerMainScreenComponent
import ru.rambler.it.other.di.getAppComponent
import ru.rambler.it.other.di.module.MainScreenModule
import ru.rambler.it.presentation.presenter.MainScreenPresenter
import ru.rambler.it.presentation.view.interfaces.MainScreenView

class MainActivity : BaseActivity<MainScreenPresenter>(), MainScreenView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun inject() {
        DaggerMainScreenComponent.builder()
                .appComponent(getAppComponent())
                .mainScreenModule(MainScreenModule(this))
                .build().inject(this)
    }
}

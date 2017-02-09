package ru.rambler.it.presentation.view.activities

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import ru.rambler.it.R
import ru.rambler.it.other.di.getAppComponent
import ru.rambler.it.other.di.module.MainScreenModule
import ru.rambler.it.presentation.adapters.EventsAdapter
import ru.rambler.it.presentation.presenter.MainScreenPresenter
import ru.rambler.it.presentation.view.interfaces.MainScreenView

class MainActivity : BaseActivity<MainScreenPresenter>(), MainScreenView {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EventsAdapter

    override fun inject() {
        getAppComponent()?.plus(MainScreenModule(this))?.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = EventsAdapter(presenter.events)
        recyclerView = findViewById(R.id.events_list) as RecyclerView

        recyclerView.adapter = adapter
    }

    override fun onEventsUpdated() {
        adapter.notifyDataSetChanged()
    }

}

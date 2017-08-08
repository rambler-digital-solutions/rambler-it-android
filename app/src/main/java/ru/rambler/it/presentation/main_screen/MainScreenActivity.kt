package ru.rambler.it.presentation.main_screen

import android.os.Bundle
import android.support.v4.app.FragmentManager
import ru.rambler.it.R
import ru.rambler.it.presentation.BaseActivity
import ru.rambler.it.presentation.main_screen.event_pager.EventPagerFragment

class MainScreenActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)
        openEventPager()
    }

    private fun openEventPager() {
        val fm: FragmentManager = supportFragmentManager
        val eventPagerFragment = EventPagerFragment.newInstance()
        fm.beginTransaction()
                .replace(R.id.page_container, eventPagerFragment)
                .commit()
    }
}

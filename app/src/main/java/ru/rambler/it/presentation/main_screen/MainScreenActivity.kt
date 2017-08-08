package ru.rambler.it.presentation.main_screen

import android.os.Bundle
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
        val eventPagerFragment = EventPagerFragment.newInstance()
        supportFragmentManager.beginTransaction()
                .replace(R.id.page_container, eventPagerFragment)
                .commit()
    }
}

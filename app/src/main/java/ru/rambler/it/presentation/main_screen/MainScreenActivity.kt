package ru.rambler.it.presentation.main_screen

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import ru.rambler.it.R
import ru.rambler.it.presentation.main_screen.event_pager.EventPagerFragment

class MainScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)
        openEventPager()
    }

    fun openEventPager() {
        val fm: FragmentManager = supportFragmentManager
        val eventPagerFragment = EventPagerFragment.newInstance()
        fm.beginTransaction()
                .replace(R.id.page_container, eventPagerFragment)
                .commit()
    }

}

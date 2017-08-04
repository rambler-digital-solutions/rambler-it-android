package ru.rambler.it.presentation.main_screen.event_pager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import ru.rambler.it.presentation.main_screen.event_page.EventFragment

class EventPagerAdapter(val colors: List<Int>, fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return EventFragment.newInstance(colors[position])
    }

    override fun getCount(): Int {
        return colors.size
    }
}
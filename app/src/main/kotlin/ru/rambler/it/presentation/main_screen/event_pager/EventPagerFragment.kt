package ru.rambler.it.presentation.main_screen.event_pager

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.bindView
import ru.rambler.it.R

class EventPagerFragment : Fragment() {
    companion object {
        fun newInstance(): EventPagerFragment = EventPagerFragment()
    }

    private val eventPager by bindView<ViewPager>(R.id.event_pager)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_event_pager, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupEventPager()
    }

    private fun setupEventPager() {
        eventPager.adapter = EventPagerAdapter(
                listOf(Color.BLUE, Color.CYAN, Color.YELLOW),
                fragmentManager)
    }
}

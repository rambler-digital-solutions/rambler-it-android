package ru.rambler.it.presentation.main_screen.event_pager

import android.graphics.Color
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.rambler.it.R
import ru.rambler.it.presentation.BaseFragment

class EventPagerFragment : BaseFragment() {
    companion object {
        fun newInstance(): EventPagerFragment = EventPagerFragment()
    }

    lateinit var eventPager: ViewPager

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater?.inflate(R.layout.fragment_event_pager, container, false)
        setupEventPager(rootView!!)
        return rootView
    }

    fun setupEventPager(rootView: View) {
        eventPager = rootView.findViewById<ViewPager>(R.id.event_pager)!!
        eventPager.adapter = EventPagerAdapter(
                listOf(Color.BLUE, Color.CYAN, Color.YELLOW),
                fragmentManager)
    }
}

package ru.rambler.it.presentation.main_screen.event_pager

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_event_pager.*
import ru.rambler.it.R
import ru.rambler.it.presentation.BaseFragment

class EventPagerFragment : BaseFragment() {
    companion object {
        fun newInstance(): EventPagerFragment = EventPagerFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_event_pager, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupEventPager()
    }

    private fun setupEventPager() {
        event_pager.adapter = EventPagerAdapter(
                listOf(Color.BLUE, Color.CYAN, Color.YELLOW),
                fragmentManager)
    }
}

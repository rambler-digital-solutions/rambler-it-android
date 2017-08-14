package ru.rambler.it.presentation.main_screen.navigation_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.rambler.it.R
import ru.rambler.it.presentation.BaseFragment

class NavigationPageFragment : BaseFragment() {
    companion object {
        fun newInstance(): NavigationPageFragment {
            return NavigationPageFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_navigation, container, false)
    }
}
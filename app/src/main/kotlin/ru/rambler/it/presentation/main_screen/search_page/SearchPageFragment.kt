package ru.rambler.it.presentation.main_screen.search_page

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.rambler.it.R

class SearchPageFragment : Fragment() {
    companion object {
        fun newInstance(): SearchPageFragment {
            return SearchPageFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_search, container, false)
    }
}
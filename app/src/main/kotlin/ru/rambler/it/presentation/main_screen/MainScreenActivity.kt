package ru.rambler.it.presentation.main_screen

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.widget.LinearLayout
import butterknife.bindView
import kotlinx.android.synthetic.main.activity_main_screen.*
import ru.rambler.it.R
import ru.rambler.it.presentation.BaseActivity
import ru.rambler.it.presentation.main_screen.event_pager.EventPagerFragment
import ru.rambler.it.presentation.main_screen.navigation_page.NavigationPageFragment
import ru.rambler.it.presentation.main_screen.search_page.SearchPageFragment

class MainScreenActivity : BaseActivity(), MainScreenView {
    private val presenter: MainScreenPresenter = MainScreenPresenter(this)

    private val navigateEventPager by bindView<LinearLayout>(R.id.navigate_event_pager)
    private val navigateNavigation by bindView<LinearLayout>(R.id.navigate_navigation)
    private val navigateSearch by bindView<LinearLayout>(R.id.navigate_search)

    private val navigationButtonListener: View.OnClickListener = View.OnClickListener { view: View ->
        presenter.onNavigateTo(view.id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)
        navigateEventPager.setOnClickListener(navigationButtonListener)
        navigateNavigation.setOnClickListener(navigationButtonListener)
        navigateSearch.setOnClickListener(navigationButtonListener)
        openEventPager()
    }

    override fun openEventPager() {
        if (findCurrentFragment() !is EventPagerFragment) {
            replaceContent(EventPagerFragment.newInstance())
        }
    }

    override fun openNavigationPage() {
        if (findCurrentFragment() !is NavigationPageFragment) {
            replaceContent(NavigationPageFragment.newInstance())
        }
    }

    override fun openSearchPage() {
        if (findCurrentFragment() !is SearchPageFragment) {
            replaceContent(SearchPageFragment.newInstance())
        }
    }

    private fun findCurrentFragment(): Fragment? {
        return supportFragmentManager.findFragmentById(page_container.id)
    }

    private fun replaceContent(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.page_container, fragment)
                .commit()
    }
}

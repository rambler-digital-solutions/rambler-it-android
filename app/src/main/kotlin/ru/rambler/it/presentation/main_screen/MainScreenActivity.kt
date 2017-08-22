package ru.rambler.it.presentation.main_screen

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.LinearLayout
import butterknife.bindView
import kotlinx.android.synthetic.main.activity_main_screen.*
import ru.rambler.it.R
import ru.rambler.it.presentation.main_screen.event_pager.EventPagerFragment
import ru.rambler.it.presentation.main_screen.navigation_page.NavigationPageFragment
import ru.rambler.it.presentation.main_screen.search_page.SearchPageFragment

class MainScreenActivity : AppCompatActivity(), MainScreenView {
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
        replaceContent { EventPagerFragment.newInstance() }
    }

    override fun openNavigationPage() {
        replaceContent { NavigationPageFragment.newInstance() }
    }

    override fun openSearchPage() {
        replaceContent { SearchPageFragment.newInstance() }
    }

    private fun findCurrentFragment(): Fragment? {
        return supportFragmentManager.findFragmentById(page_container.id)
    }

    private inline fun <reified T : Fragment> replaceContent(createFragment: () -> T) {
        if (findCurrentFragment() !is T) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.page_container, createFragment())
                    .commit()
        }
    }
}

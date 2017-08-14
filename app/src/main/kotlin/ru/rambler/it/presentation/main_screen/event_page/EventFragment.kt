package ru.rambler.it.presentation.main_screen.event_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import butterknife.bindView
import ru.rambler.it.R
import ru.rambler.it.presentation.BaseFragment

class EventFragment : BaseFragment() {
    companion object {
        private const val ARG_COLOR: String = "arg_color"

        fun newInstance(color: Int): EventFragment {
            val fragment = EventFragment()
            val args: Bundle = Bundle()
            args.putInt(ARG_COLOR, color)
            fragment.arguments = args
            return fragment
        }
    }

    private val rootLayout by bindView<LinearLayout>(R.id.root_layout)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_event, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rootLayout.setBackgroundColor(arguments.getInt(ARG_COLOR))
    }
}
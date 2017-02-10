package ru.rambler.it.presentation.adapters.viewholder.events

import android.view.View
import android.widget.TextView
import ru.rambler.it.R
import ru.rambler.it.domain.entities.Event

class SimpleEventsViewHolder(itemView: View) : AbstractEventsViewHolder(itemView) {

    lateinit var title: TextView

    override fun bind(event: Event) {
        title = itemView.findViewById(R.id.title) as TextView
        title.text = event.attributes?.name
    }
}

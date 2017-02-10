package ru.rambler.it.presentation.adapters.viewholder.events

import android.view.LayoutInflater
import android.view.ViewGroup
import ru.rambler.it.R
import ru.rambler.it.domain.entities.Event

class EventsViewHolderFactory  {

    fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AbstractEventsViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.event_list_item, parent, false)
        return SimpleEventsViewHolder(itemView)
    }

    fun getItemViewType(event: Event, position: Int): Int {
        return R.layout.event_list_item
    }
}
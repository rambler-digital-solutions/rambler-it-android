package ru.rambler.it.presentation.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import ru.rambler.it.domain.entities.Event
import ru.rambler.it.presentation.adapters.viewholder.events.AbstractEventsViewHolder
import ru.rambler.it.presentation.adapters.viewholder.events.EventsViewHolderFactory

class EventsAdapter(val events: List<Event>) : RecyclerView.Adapter<AbstractEventsViewHolder>() {

    val viewHolderFactory = EventsViewHolderFactory()

    override fun getItemCount(): Int {
        return events.size
    }

    override fun onBindViewHolder(holder: AbstractEventsViewHolder?, position: Int) {
        holder?.bind(events[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AbstractEventsViewHolder {
        return viewHolderFactory.onCreateViewHolder(parent, viewType)
    }

    override fun getItemViewType(position: Int): Int {
        return viewHolderFactory.getItemViewType(events[position], position)
    }
}
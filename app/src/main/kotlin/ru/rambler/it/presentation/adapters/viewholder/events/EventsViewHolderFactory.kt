package ru.rambler.it.presentation.adapters.viewholder.events

import android.view.LayoutInflater
import android.view.ViewGroup
import ru.rambler.it.R
import ru.rambler.it.domain.entities.Event
import ru.rambler.it.presentation.adapters.viewholder.ViewHolderFactory

/**
 * Created by a.tkachenko on 09.02.17.
 */
class EventsViewHolderFactory : ViewHolderFactory<Event, AbstractEventsViewHolder> {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AbstractEventsViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.event_list_item, parent, false)
        return SimpleEventsViewHolder(itemView)
    }

    override fun getItemViewType(be: Event, position: Int): Int {
        return R.layout.event_list_item
    }
}
package ru.rambler.it.presentation.adapters.viewholder.events

import android.support.v7.widget.RecyclerView
import android.view.View
import ru.rambler.it.domain.entities.Event

abstract class AbstractEventsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(event: Event)

}
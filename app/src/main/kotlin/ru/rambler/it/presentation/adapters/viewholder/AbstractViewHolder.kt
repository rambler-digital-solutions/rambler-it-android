package ru.rambler.it.presentation.adapters.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class AbstractViewHolder<BE>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    open abstract fun bind(be: BE)

}
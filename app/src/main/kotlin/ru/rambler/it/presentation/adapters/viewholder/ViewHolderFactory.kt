package ru.rambler.it.presentation.adapters.viewholder

import android.view.ViewGroup

interface ViewHolderFactory<BE, VH>{

    fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VH

    fun getItemViewType(be: BE, position: Int): Int

}
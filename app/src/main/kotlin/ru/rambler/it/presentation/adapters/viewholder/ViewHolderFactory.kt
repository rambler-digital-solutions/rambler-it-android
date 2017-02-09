package ru.rambler.it.presentation.adapters.viewholder

import android.view.ViewGroup

/**
 * Created by a.tkachenko on 09.02.17.
 */
interface ViewHolderFactory<BE, VH>{

    fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VH

    fun getItemViewType(be: BE, position: Int): Int

}
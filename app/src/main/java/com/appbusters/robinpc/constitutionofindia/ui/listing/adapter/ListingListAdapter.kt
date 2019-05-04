package com.appbusters.robinpc.constitutionofindia.ui.listing.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.data.model.ReadElement
import com.appbusters.robinpc.constitutionofindia.ui.listing.adapter.holder.ListingHolder

class ListingListAdapter(comparator: DiffUtil.ItemCallback<ReadElement>):
        ListAdapter<ReadElement, ListingHolder>(comparator), ListingHolder.ListItemClickListener {

    private lateinit var listItemClickListener: ListItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingHolder {
        return ListingHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.row_listing, parent, false))
    }

    override fun onBindViewHolder(holder: ListingHolder, position: Int) {
        getItem(position)?.let {
            holder.setReadElement(it)
            holder.setListItemClickListener(this)
        }
    }

    interface ListItemClickListener {
        fun onListItemClicked(readElement: ReadElement)
    }

    fun setListItemClickListener(listItemClickListener: ListItemClickListener) {
        this.listItemClickListener = listItemClickListener
    }

    override fun onListingItemClicked(readElement: ReadElement) {
        listItemClickListener.onListItemClicked(readElement)
    }
}
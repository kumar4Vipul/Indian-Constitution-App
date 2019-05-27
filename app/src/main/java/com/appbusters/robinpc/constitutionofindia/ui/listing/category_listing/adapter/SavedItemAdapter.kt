package com.appbusters.robinpc.constitutionofindia.ui.listing.category_listing.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.data.model.ReadElement
import com.appbusters.robinpc.constitutionofindia.ui.home.fragments.bookmarks_fragment.adapter.holder.SavedItemHolder

class SavedItemAdapter(comparator: DiffUtil.ItemCallback<ReadElement>):
        ListAdapter<ReadElement, SavedItemHolder>(comparator), SavedItemHolder.SavedItemClickListener {

    private lateinit var savedItemClickListener: SavedItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedItemHolder {
        return SavedItemHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.row_all_saved, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SavedItemHolder, position: Int) {
        getItem(position)?.let {
            holder.setSavedItem(it)
            holder.setSavedItemClickListener(this)
        }
    }

    override fun onSavedItemClicked(readElement: ReadElement) {
        savedItemClickListener.onSavedItemClicked(readElement)
    }

    interface SavedItemClickListener {
        fun onSavedItemClicked(readElement: ReadElement)
    }

    fun setSavedItemClickListener(savedItemClickListener: SavedItemClickListener) {
        this.savedItemClickListener = savedItemClickListener
    }
}
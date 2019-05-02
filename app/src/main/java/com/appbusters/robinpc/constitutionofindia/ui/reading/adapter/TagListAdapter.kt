package com.appbusters.robinpc.constitutionofindia.ui.reading.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.data.model.Tag
import com.appbusters.robinpc.constitutionofindia.ui.reading.adapter.holder.TagHolder

class TagListAdapter(comparator: DiffUtil.ItemCallback<Tag>):
        ListAdapter<Tag, TagHolder>(comparator), TagHolder.OnTagClickListener {

    private lateinit var tagClickListener: OnTagClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagHolder {
        return TagHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_tag, parent, false))
    }

    override fun onBindViewHolder(holder: TagHolder, position: Int) {
        getItem(position)?.let {
            holder.setTag(it)
            holder.setTagClickListener(this)
        }
    }

    override fun onTagClicked(tag: Tag) {
        tagClickListener.onTagClicked(tag)
    }

    fun setTagClickListener(tagClickListener: OnTagClickListener) {
        this.tagClickListener = tagClickListener
    }

    interface OnTagClickListener {
        fun onTagClicked(tag: Tag)
    }
}
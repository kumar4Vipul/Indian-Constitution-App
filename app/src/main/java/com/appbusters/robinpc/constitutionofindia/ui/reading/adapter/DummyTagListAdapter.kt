package com.appbusters.robinpc.constitutionofindia.ui.reading.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.data.model.DummyTag
import com.appbusters.robinpc.constitutionofindia.ui.reading.adapter.holder.DummyTagHolder

class DummyTagListAdapter(comparator: DiffUtil.ItemCallback<DummyTag>):
        ListAdapter<DummyTag, DummyTagHolder>(comparator), DummyTagHolder.OnTagClickListener {

    private lateinit var tagClickListener: OnTagClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DummyTagHolder {
        return DummyTagHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_dummy_tag, parent, false))
    }

    override fun onBindViewHolder(holder: DummyTagHolder, position: Int) {
        getItem(position)?.let {
            holder.setTag(it)
            holder.setTagClickListener(this)
        }
    }

    override fun onTagClicked(tag: DummyTag) {
        tagClickListener.onTagClicked(tag)
    }

    fun setTagClickListener(tagClickListener: OnTagClickListener) {
        this.tagClickListener = tagClickListener
    }

    interface OnTagClickListener {
        fun onTagClicked(tag: DummyTag)
    }
}
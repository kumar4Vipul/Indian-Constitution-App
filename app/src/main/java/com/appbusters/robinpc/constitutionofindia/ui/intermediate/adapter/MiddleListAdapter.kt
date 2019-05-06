package com.appbusters.robinpc.constitutionofindia.ui.intermediate.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.data.model.Part
import com.appbusters.robinpc.constitutionofindia.ui.intermediate.adapter.holder.MiddleHolder

class MiddleListAdapter(comparator: DiffUtil.ItemCallback<Part>):
        ListAdapter<Part, MiddleHolder>(comparator), MiddleHolder.PartClickedListener {

    private lateinit var partClickListener: OnPartClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiddleHolder {
        return MiddleHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.row_middle_list, parent, false))
    }

    override fun onBindViewHolder(holder: MiddleHolder, position: Int) {
        getItem(position)?.let {
            holder.setPart(it)
            holder.setPartClickListener(this)
        }
    }

    fun setPartClickListener(partClickListener: OnPartClickListener) {
        this.partClickListener = partClickListener
    }

    override fun onPartClicked(part: Part) {
        partClickListener.onPartClicked(part)
    }

    interface OnPartClickListener {
        fun onPartClicked(part: Part)
    }
}
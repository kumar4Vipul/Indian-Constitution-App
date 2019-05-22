package com.appbusters.robinpc.constitutionofindia.ui.home.home_fragment.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.appbusters.robinpc.constitutionofindia.data.model.Tag
import kotlinx.android.synthetic.main.row_tag.view.*

class TagHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private lateinit var tag: Tag
    private lateinit var tagClickListener: OnTagClickListener

    fun setTag(tag: Tag) {
        this.tag = tag
        setClickListeners()
        renderViews()
    }

    private fun setClickListeners() {
        itemView.setOnClickListener {
            tagClickListener.onTagClicked(this.tag)
        }
    }

    private fun renderViews() {
        itemView.tagTitleTv.text = tag.title
    }

    fun setTagClickListener(tagClickListener: OnTagClickListener) {
        this.tagClickListener = tagClickListener
    }

    interface OnTagClickListener {
        fun onTagClicked(tag: Tag)
    }
}
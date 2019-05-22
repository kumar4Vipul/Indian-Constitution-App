package com.appbusters.robinpc.constitutionofindia.ui.reading.adapter.holder

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.data.model.DummyTag
import com.appbusters.robinpc.constitutionofindia.data.model.Tag
import kotlinx.android.synthetic.main.row_dummy_tag.view.*

class DummyTagHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private lateinit var tag: DummyTag
    private lateinit var tagClickListener: OnTagClickListener

    fun setTag(tag: DummyTag) {
        this.tag = tag
        renderViews()
    }

    private fun renderViews() {
        itemView.tagTitleTv.text = tag.title
        renderTagBackground()
    }

    private fun renderTagBackground() {
        itemView.context?.let {
            when(tag.categoryName) {
                it.getString(R.string.amendments_categories) -> setBackgroundColor(R.color.amendment_color, it)
                it.getString(R.string.schedules_categories) -> setBackgroundColor(R.color.schedules_color, it)
                it.getString(R.string.parts_categories) -> setBackgroundColor(R.color.parts_color, it)
                it.getString(R.string.preamble_categories) -> setBackgroundColor(R.color.preamble_color, it)
            }
        }
    }

    private fun setBackgroundColor(color: Int, context: Context) {
        itemView.backgroundCv.setCardBackgroundColor(ContextCompat.getColor(context, color))
    }

    fun setTagClickListener(tagClickListener: OnTagClickListener) {
        this.tagClickListener = tagClickListener
    }

    interface OnTagClickListener {
        fun onTagClicked(tag: DummyTag)
    }
}
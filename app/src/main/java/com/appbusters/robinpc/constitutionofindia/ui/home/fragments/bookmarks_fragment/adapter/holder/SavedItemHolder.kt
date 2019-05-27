package com.appbusters.robinpc.constitutionofindia.ui.home.fragments.bookmarks_fragment.adapter.holder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.data.model.ReadElement
import com.appbusters.robinpc.constitutionofindia.utils.Constants
import kotlinx.android.synthetic.main.row_all_saved.view.*

class SavedItemHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private lateinit var readElement: ReadElement
    private lateinit var savedItemClickListener: SavedItemClickListener

    fun setSavedItem(readElement: ReadElement) {
        this.readElement = readElement
        setTexts()
        setImage()
        setClickListeners()
    }

    private fun setTexts() {
        itemView.itemNameTv.text = readElement.title
    }

    private fun setImage() {
        itemView.categoryCircleIv.setBackgroundColor(
                ContextCompat.getColor(
                        itemView.context,
                        getCategoryColor(readElement.categoryName!!)
                )
        )
    }

    private fun setClickListeners() {
        itemView.setOnClickListener {
            savedItemClickListener.onSavedItemClicked(readElement)
        }
    }

    private fun getCategoryColor(categoryName: String): Int {
        val color: Int
        when(categoryName) {
            Constants.CATEGORY_SCHEDULES -> color = R.color.schedules_color
            Constants.CATEGORY_AMENDMENTS -> color = R.color.amendment_color
            Constants.CATEGORY_PREAMBLE -> color = R.color.preamble_color
            Constants.CATEGORY_PARTS -> color = R.color.parts_color
            else -> color = R.color.black
        }
        return color
    }

    interface SavedItemClickListener {
        fun onSavedItemClicked(readElement: ReadElement)
    }

    fun setSavedItemClickListener(savedItemClickListener: SavedItemClickListener) {
        this.savedItemClickListener = savedItemClickListener
    }
}
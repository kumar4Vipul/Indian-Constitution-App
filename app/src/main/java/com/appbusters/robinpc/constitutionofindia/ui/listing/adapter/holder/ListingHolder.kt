package com.appbusters.robinpc.constitutionofindia.ui.listing.adapter.holder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.data.model.ReadElement
import com.appbusters.robinpc.constitutionofindia.utils.Constants
import kotlinx.android.synthetic.main.row_listing.view.*

class ListingHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private lateinit var readElement: ReadElement
    private lateinit var listItemClickListener: ListItemClickListener

    fun setReadElement(readElement: ReadElement) {
        this.readElement = readElement
        setTexts()
        setStartLineImage()
        setClickListeners()
    }

    private fun setTexts() {
        itemView.titleTv.text = readElement.title
    }

    private fun setStartLineImage() {
        itemView.startLineIv.setBackgroundColor(
                ContextCompat.getColor(
                        itemView.context,
                        getCategoryColor(readElement.categoryName!!)
                )
        )
    }

    private fun setClickListeners() {
        itemView.setOnClickListener {
            listItemClickListener.onListingItemClicked(readElement)
        }
        itemView.bookmarkIv.setOnClickListener {

        }
    }

    private fun getCategoryColor(categoryName: String): Int {
        val color: Int
        when(categoryName) {
            Constants.CATEGORY_SCHEDULES -> color = R.color.schedules_color
            Constants.CATEGORY_AMENDMENTS -> color = R.color.amendment_color
            Constants.CATEGORY_PARTS -> color = R.color.parts_color
            else -> color = R.color.black
        }
        return color
    }

    interface ListItemClickListener {
        fun onListingItemClicked(readElement: ReadElement)
    }

    fun setListItemClickListener(listItemClickListener: ListItemClickListener) {
        this.listItemClickListener = listItemClickListener
    }
}
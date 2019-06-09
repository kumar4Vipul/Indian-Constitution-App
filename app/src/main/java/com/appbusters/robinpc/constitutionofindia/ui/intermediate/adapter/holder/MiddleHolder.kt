package com.appbusters.robinpc.constitutionofindia.ui.intermediate.adapter.holder

import android.text.Html
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.data.model.Part
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_PARTS
import kotlinx.android.synthetic.main.row_middle_list.view.startLineIv
import kotlinx.android.synthetic.main.row_middle_list.view.titleTv

class MiddleHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private lateinit var part: Part
    private lateinit var partClickedListener: PartClickedListener

    fun setPart(part: Part) {
        this.part = part
        setTexts()
        setStartLineImage()
        setClickListeners()
    }

    private fun setTexts() {
        itemView.titleTv.text = part.title.plus("  (${part.subtitle})")
    }

    private fun setClickListeners() {
        itemView.setOnClickListener {
            partClickedListener.onPartClicked(part)
        }
    }

    private fun setStartLineImage() {
        itemView.startLineIv.setBackgroundColor(
                ContextCompat.getColor(
                        itemView.context,
                        getCategoryColor(CATEGORY_PARTS)
                )
        )
    }

    private fun getCategoryColor(categoryName: String): Int {
        val color: Int
        when(categoryName) {
            CATEGORY_PARTS -> color = R.color.parts_color
            else -> color = R.color.black
        }
        return color
    }

    fun setPartClickListener(partClickedListener: PartClickedListener) {
        this.partClickedListener = partClickedListener
    }

    interface PartClickedListener {
        fun onPartClicked(part: Part)
    }
}
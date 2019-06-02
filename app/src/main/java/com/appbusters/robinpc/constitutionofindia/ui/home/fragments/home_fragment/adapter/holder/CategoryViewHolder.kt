package com.appbusters.robinpc.constitutionofindia.ui.home.fragments.home_fragment.adapter.holder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.data.model.Category
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_AMENDMENTS
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_PARTS
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_PREAMBLE
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_SCHEDULES
import kotlinx.android.synthetic.main.row_category.view.*

class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private lateinit var category: Category
    private lateinit var categoryClickListener: CategoryClickListener

    fun setCategory(category: Category) {

        this.category = category

        itemView.categoryTitleTv.text = category.name
        setParentDrawable()
        itemView.cardView.setCardBackgroundColor(getColorFromRes(category.color))

        itemView.setOnClickListener {
            categoryClickListener.onCategoryClicked(category)
        }
    }

    private fun setParentDrawable() {
        itemView.parentLayout.setBackgroundResource(
                getDrawable()
        )
    }

    private fun getDrawable(): Int {
        return when(category.name) {
            CATEGORY_PREAMBLE -> R.drawable.bg_preamble
            CATEGORY_PARTS -> R.drawable.bg_parts
            CATEGORY_AMENDMENTS -> R.drawable.bg_amendments
            CATEGORY_SCHEDULES -> R.drawable.bg_schedules
            else -> R.drawable.bg_schedules
        }
    }

    private fun getColorFromRes(res: Int): Int {
        return ContextCompat.getColor(itemView.context, res)
    }

    interface CategoryClickListener {
        fun onCategoryClicked(category: Category)
    }

    fun setCategoryClickListener(categoryClickListener: CategoryClickListener) {
        this.categoryClickListener = categoryClickListener
    }
}
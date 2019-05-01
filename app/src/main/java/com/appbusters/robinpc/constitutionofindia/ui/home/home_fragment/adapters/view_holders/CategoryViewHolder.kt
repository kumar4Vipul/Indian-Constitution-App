package com.appbusters.robinpc.constitutionofindia.ui.home.home_fragment.adapters.view_holders

import android.content.res.ColorStateList
import android.graphics.Color
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.data.model.Category
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.row_categories.view.*

class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private lateinit var categoryClickListener: CategoryClickListener

    fun setCategory(category: Category) {
        itemView.categoryTitleTv.text = category.name
        itemView.cardView.setCardBackgroundColor(getColorFromRes(category.color))

        itemView.setOnClickListener {
            categoryClickListener.onCategoryClicked(category)
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
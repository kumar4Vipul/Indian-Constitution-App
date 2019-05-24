package com.appbusters.robinpc.constitutionofindia.ui.home.fragments.home_fragment.adapter.holder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.appbusters.robinpc.constitutionofindia.data.model.Category
import kotlinx.android.synthetic.main.row_category.view.*

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
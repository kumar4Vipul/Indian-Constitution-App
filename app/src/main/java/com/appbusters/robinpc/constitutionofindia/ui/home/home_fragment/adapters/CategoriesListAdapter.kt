package com.appbusters.robinpc.constitutionofindia.ui.home.home_fragment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.data.model.Category
import com.appbusters.robinpc.constitutionofindia.ui.home.home_fragment.adapters.view_holders.CategoryViewHolder

class CategoriesListAdapter(comparator: DiffUtil.ItemCallback<Category>):
        ListAdapter<Category, CategoryViewHolder>(comparator),
        CategoryViewHolder.CategoryClickListener {

    private lateinit var categoryClickListener: CategoryClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.row_categories, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        getItem(position)?.let {
            holder.setCategory(it)
            holder.setCategoryClickListener(this)
        }
    }

    fun setCategoryClickListener(categoryClickListener: CategoryClickListener) {
        this.categoryClickListener = categoryClickListener
    }

    override fun onCategoryClicked(category: Category) {
        categoryClickListener.onCategoryClicked(category)
    }

    interface CategoryClickListener {
        fun onCategoryClicked(category: Category)
    }
}
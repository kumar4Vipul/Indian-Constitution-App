package com.appbusters.robinpc.constitutionofindia.di.module.fragment

import android.content.Context
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.appbusters.robinpc.constitutionofindia.data.model.Category
import com.appbusters.robinpc.constitutionofindia.data.model.Tag
import com.appbusters.robinpc.constitutionofindia.di.scope.PerFragmentScope
import com.appbusters.robinpc.constitutionofindia.ui.home.fragments.home_fragment.adapter.CategoriesListAdapter
import com.appbusters.robinpc.constitutionofindia.ui.home.fragments.home_fragment.adapter.TagListAdapter
import dagger.Module
import dagger.Provides

@Module
class HomeFragmentModule(
        private val categoryClickListener: CategoriesListAdapter.CategoryClickListener,
        private val tagClickListener: TagListAdapter.OnTagClickListener,
        private val categorySpanCount: Int,
        private val tagSpanCount: Int
) {

    @Provides
    @PerFragmentScope
    fun gridLayoutManager(context: Context): GridLayoutManager {
        return GridLayoutManager(
                context,
                categorySpanCount,
                RecyclerView.VERTICAL,
                false
        )
    }

    @Provides
    @PerFragmentScope
    fun staggeredGridLayoutManager(context: Context): StaggeredGridLayoutManager {
        return StaggeredGridLayoutManager(
                tagSpanCount,
                RecyclerView.HORIZONTAL
        )
    }

    @Provides
    @PerFragmentScope
    fun categoriesListAdapter(comparator: DiffUtil.ItemCallback<Category>): CategoriesListAdapter {
        val adapter = CategoriesListAdapter(comparator)
        adapter.setCategoryClickListener(categoryClickListener)
        return adapter
    }

    @Provides
    @PerFragmentScope
    fun tagsListAdapter(comparator: DiffUtil.ItemCallback<Tag>): TagListAdapter {
        val adapter = TagListAdapter(comparator)
        adapter.setTagClickListener(tagClickListener)
        return adapter
    }

    @Provides
    @PerFragmentScope
    fun tagsComparator(): DiffUtil.ItemCallback<Tag> {
        return object : DiffUtil.ItemCallback<Tag>() {
            override fun areItemsTheSame(oldItem: Tag, newItem: Tag): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: Tag, newItem: Tag): Boolean {
                @Suppress("ReplaceCallWithBinaryOperator")
                return oldItem.equals(newItem)
            }
        }
    }

    @Provides
    @PerFragmentScope
    fun categoryComparator(): DiffUtil.ItemCallback<Category> {
        return object : DiffUtil.ItemCallback<Category>() {
            override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
                return oldItem == newItem
            }
        }
    }
}
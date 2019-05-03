package com.appbusters.robinpc.constitutionofindia.di.module.fragment

import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DiffUtil
import com.appbusters.robinpc.constitutionofindia.data.model.Category
import com.appbusters.robinpc.constitutionofindia.di.scope.PerFragmentScope
import com.appbusters.robinpc.constitutionofindia.ui.home.home_fragment.adapter.CategoriesListAdapter
import com.appbusters.robinpc.constitutionofindia.ui.home.home_fragment.adapter.FeaturedPagerAdapter
import dagger.Module
import dagger.Provides

@Module
class HomeFragmentModule(val fragmentManager: FragmentManager) {

    @Provides
    @PerFragmentScope
    fun fragmentPagerAdapter(): FeaturedPagerAdapter {
        return FeaturedPagerAdapter(fragmentManager)
    }

    @Provides
    @PerFragmentScope
    fun categoriesListAdapter(comparator: DiffUtil.ItemCallback<Category>): CategoriesListAdapter {
        return CategoriesListAdapter(comparator)
    }

    @Provides
    @PerFragmentScope
    fun comparator(): DiffUtil.ItemCallback<Category> {
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
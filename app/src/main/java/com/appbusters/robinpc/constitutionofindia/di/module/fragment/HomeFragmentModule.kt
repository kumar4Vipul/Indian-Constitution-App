package com.appbusters.robinpc.constitutionofindia.di.module.fragment

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DiffUtil
import com.appbusters.robinpc.constitutionofindia.data.model.Category
import com.appbusters.robinpc.constitutionofindia.data.model.Tag
import com.appbusters.robinpc.constitutionofindia.di.qualifier.MainDatabaseString
import com.appbusters.robinpc.constitutionofindia.di.scope.PerFragmentScope
import com.appbusters.robinpc.constitutionofindia.ui.home.fragments.home_fragment.adapter.CategoriesListAdapter
import com.appbusters.robinpc.constitutionofindia.ui.home.fragments.home_fragment.adapter.FeaturedPagerAdapter
import com.appbusters.robinpc.constitutionofindia.ui.home.fragments.home_fragment.adapter.TagListAdapter
import com.appbusters.robinpc.constitutionofindia.utils.Constants
import dagger.Module
import dagger.Provides
import java.io.InputStream

@Module
class HomeFragmentModule(private val fragmentManager: FragmentManager, private val context: Context) {

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
    fun tagsListAdapter(comparator: DiffUtil.ItemCallback<Tag>): TagListAdapter {
        return TagListAdapter(comparator)
    }

    @Provides
    @PerFragmentScope
    fun tagsComparator(): DiffUtil.ItemCallback<Tag> {
        return object : DiffUtil.ItemCallback<Tag>() {
            override fun areItemsTheSame(oldItem: Tag, newItem: Tag): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: Tag, newItem: Tag): Boolean {
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

    @Provides
    @PerFragmentScope
    fun mainDatabaseInputStream(@MainDatabaseString databaseFilePath: String): InputStream {
        return context.assets.open(databaseFilePath)
    }

    @Provides
    @MainDatabaseString
    @PerFragmentScope
    fun mainDatabaseFilePath(): String {
        return Constants.MAIN_DB_PATH
    }
}
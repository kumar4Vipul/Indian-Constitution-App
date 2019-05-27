package com.appbusters.robinpc.constitutionofindia.di.module.fragment

import androidx.recyclerview.widget.DiffUtil
import com.appbusters.robinpc.constitutionofindia.data.model.ReadElement
import com.appbusters.robinpc.constitutionofindia.di.scope.PerFragmentScope
import com.appbusters.robinpc.constitutionofindia.ui.listing.category_listing.adapter.SavedItemAdapter
import dagger.Module
import dagger.Provides

@Module
class BookmarkFragmentModule {

    @Provides
    @PerFragmentScope
    fun allSavedAdapter(comparator: DiffUtil.ItemCallback<ReadElement>): SavedItemAdapter {
        return SavedItemAdapter(comparator)
    }

    @Provides
    @PerFragmentScope
    fun comparator(): DiffUtil.ItemCallback<ReadElement> {
        return object : DiffUtil.ItemCallback<ReadElement>() {
            override fun areItemsTheSame(oldItem: ReadElement, newItem: ReadElement): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ReadElement, newItem: ReadElement): Boolean {
                return oldItem.equals(newItem)
            }
        }
    }
}
package com.appbusters.robinpc.constitutionofindia.di.module.activity

import android.content.Context
import androidx.recyclerview.widget.DiffUtil
import com.appbusters.robinpc.constitutionofindia.data.model.ReadElement
import com.appbusters.robinpc.constitutionofindia.di.scope.PerFragmentScope
import com.appbusters.robinpc.constitutionofindia.ui.listing.category_listing.adapter.ListingListAdapter
import dagger.Module
import dagger.Provides

@Module
class SavedCategoryActivityModule(val context: Context) {

    @Provides
    @PerFragmentScope
    fun listingListAdapter(comparator: DiffUtil.ItemCallback<ReadElement>): ListingListAdapter {
        return ListingListAdapter(comparator)
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
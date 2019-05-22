package com.appbusters.robinpc.constitutionofindia.di.module.activity

import android.content.Context
import androidx.recyclerview.widget.DiffUtil
import com.appbusters.robinpc.constitutionofindia.data.model.ReadElement
import com.appbusters.robinpc.constitutionofindia.di.qualifier.MainDatabaseString
import com.appbusters.robinpc.constitutionofindia.di.scope.PerFragmentScope
import com.appbusters.robinpc.constitutionofindia.ui.listing.category_listing.adapter.ListingListAdapter
import com.appbusters.robinpc.constitutionofindia.utils.Constants
import dagger.Module
import dagger.Provides
import java.io.InputStream

@Module
class ListingActivityModule(val context: Context) {

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
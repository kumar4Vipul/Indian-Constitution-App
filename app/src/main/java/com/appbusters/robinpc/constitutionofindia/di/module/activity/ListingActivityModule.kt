package com.appbusters.robinpc.constitutionofindia.di.module.activity

import android.content.Context
import androidx.recyclerview.widget.DiffUtil
import com.appbusters.robinpc.constitutionofindia.data.model.Tag
import com.appbusters.robinpc.constitutionofindia.di.qualifier.MainDatabaseString
import com.appbusters.robinpc.constitutionofindia.di.scope.PerFragmentScope
import com.appbusters.robinpc.constitutionofindia.ui.reading.adapter.TagListAdapter
import com.appbusters.robinpc.constitutionofindia.utils.Constants
import dagger.Module
import dagger.Provides
import java.io.InputStream

@Module
class ListingActivityModule(val context: Context) {

//    @Provides
//    @PerFragmentScope
//    fun tagListAdapter(comparator: DiffUtil.ItemCallback<Tag>): TagListAdapter {
//        return TagListAdapter(comparator)
//    }
//
//    @Provides
//    @PerFragmentScope
//    fun comparator(): DiffUtil.ItemCallback<Tag> {
//        return object : DiffUtil.ItemCallback<Tag>() {
//            override fun areItemsTheSame(oldItem: Tag, newItem: Tag): Boolean {
//                return oldItem.name == newItem.name
//            }
//
//            override fun areContentsTheSame(oldItem: Tag, newItem: Tag): Boolean {
//                return oldItem == newItem
//            }
//        }
//    }

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
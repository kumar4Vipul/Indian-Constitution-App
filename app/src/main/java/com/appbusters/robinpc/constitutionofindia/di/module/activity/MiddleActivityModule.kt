package com.appbusters.robinpc.constitutionofindia.di.module.activity

import android.content.Context
import androidx.recyclerview.widget.DiffUtil
import com.appbusters.robinpc.constitutionofindia.data.model.Part
import com.appbusters.robinpc.constitutionofindia.di.qualifier.MainDatabaseString
import com.appbusters.robinpc.constitutionofindia.di.scope.PerFragmentScope
import com.appbusters.robinpc.constitutionofindia.ui.intermediate.adapter.MiddleListAdapter
import com.appbusters.robinpc.constitutionofindia.utils.Constants
import dagger.Module
import dagger.Provides
import java.io.InputStream

@Module
class MiddleActivityModule(private val context: Context) {

    @Provides
    @PerFragmentScope
    fun middleListAdapter(comparator: DiffUtil.ItemCallback<Part>): MiddleListAdapter {
        return MiddleListAdapter(comparator)
    }

    @Provides
    @PerFragmentScope
    fun comparator(): DiffUtil.ItemCallback<Part> {
        return object : DiffUtil.ItemCallback<Part>() {
            override fun areItemsTheSame(oldItem: Part, newItem: Part): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: Part, newItem: Part): Boolean {
                return oldItem == newItem
            }
        }
    }
}
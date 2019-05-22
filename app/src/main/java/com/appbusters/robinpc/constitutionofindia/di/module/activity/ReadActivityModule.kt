package com.appbusters.robinpc.constitutionofindia.di.module.activity

import androidx.recyclerview.widget.DiffUtil
import com.appbusters.robinpc.constitutionofindia.data.model.DummyTag
import com.appbusters.robinpc.constitutionofindia.di.scope.PerFragmentScope
import com.appbusters.robinpc.constitutionofindia.ui.reading.adapter.DummyTagListAdapter
import dagger.Module
import dagger.Provides

@Module
class ReadActivityModule {

    @Provides
    @PerFragmentScope
    fun tagListAdapter(comparator: DiffUtil.ItemCallback<DummyTag>): DummyTagListAdapter {
        return DummyTagListAdapter(comparator)
    }

    @Provides
    @PerFragmentScope
    fun comparator(): DiffUtil.ItemCallback<DummyTag> {
        return object : DiffUtil.ItemCallback<DummyTag>() {
            override fun areItemsTheSame(oldItem: DummyTag, newItem: DummyTag): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: DummyTag, newItem: DummyTag): Boolean {
                return oldItem.equals(newItem)
            }
        }
    }
}
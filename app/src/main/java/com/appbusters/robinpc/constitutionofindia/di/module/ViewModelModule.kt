package com.appbusters.robinpc.constitutionofindia.di.module

import androidx.lifecycle.ViewModel
import com.appbusters.robinpc.constitutionofindia.di.mapkey.ViewModelKey
import com.appbusters.robinpc.constitutionofindia.ui.home.fragments.home_fragment.HomeFragmentViewModel
import com.appbusters.robinpc.constitutionofindia.ui.intermediate.MiddleActivityViewModel
import com.appbusters.robinpc.constitutionofindia.ui.listing.category_listing.CategoryListingActivityViewModel
import com.appbusters.robinpc.constitutionofindia.ui.listing.tag_children.TagChildrenActivityViewModel
import com.appbusters.robinpc.constitutionofindia.ui.reading.ReadingActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeFragmentViewModel::class)
    abstract fun bindHomeFragmentViewModel(homeFragmentViewModel: HomeFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MiddleActivityViewModel::class)
    abstract fun bindMiddleActivityViewModel(middleActivityViewModel: MiddleActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ReadingActivityViewModel::class)
    abstract fun bindReadingActivityViewModel(readingActivityViewModel: ReadingActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TagChildrenActivityViewModel::class)
    abstract fun bindTagChildrenActivityViewModel(tagChildrenActivityViewModel: TagChildrenActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CategoryListingActivityViewModel::class)
    abstract fun bindCategoryListingActivityViewModel(categoryListingActivityViewModel: CategoryListingActivityViewModel): ViewModel

}
package com.appbusters.robinpc.constitutionofindia.di.component.fragment

import com.appbusters.robinpc.constitutionofindia.di.component.ConstitutionAppComponent
import com.appbusters.robinpc.constitutionofindia.di.module.ViewModelFactoryModule
import com.appbusters.robinpc.constitutionofindia.di.module.ViewModelModule
import com.appbusters.robinpc.constitutionofindia.di.module.fragment.BookmarkFragmentModule
import com.appbusters.robinpc.constitutionofindia.di.scope.PerFragmentScope
import com.appbusters.robinpc.constitutionofindia.ui.home.fragments.bookmarks_fragment.BookmarkFragment
import dagger.Component

@PerFragmentScope
@Component(modules = [BookmarkFragmentModule::class, ViewModelFactoryModule::class, ViewModelModule::class],
        dependencies = [ConstitutionAppComponent::class])
interface BookmarkFragmentComponent {

    fun injectBookmarkFragment(bookmarkFragment: BookmarkFragment)

}
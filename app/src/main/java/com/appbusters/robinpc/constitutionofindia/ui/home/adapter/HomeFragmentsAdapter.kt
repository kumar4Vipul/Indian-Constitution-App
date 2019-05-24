package com.appbusters.robinpc.constitutionofindia.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.appbusters.robinpc.constitutionofindia.ui.home.HomeActivity.Companion.BOOKMARKS_PAGE
import com.appbusters.robinpc.constitutionofindia.ui.home.HomeActivity.Companion.HOME_PAGE
import com.appbusters.robinpc.constitutionofindia.ui.home.fragments.bookmarks_fragment.BookmarkFragment
import com.appbusters.robinpc.constitutionofindia.ui.home.fragments.home_fragment.HomeFragment

class HomeFragmentsAdapter(fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {

    companion object {
        const val PAGE_COUNT = 2
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            HOME_PAGE -> HomeFragment.newInstance()
            BOOKMARKS_PAGE -> BookmarkFragment.newInstance()
            else -> BookmarkFragment.newInstance()
        }
    }

    override fun getCount(): Int {
        return PAGE_COUNT
    }
}
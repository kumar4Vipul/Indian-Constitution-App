package com.appbusters.robinpc.constitutionofindia.ui.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.appbusters.robinpc.constitutionofindia.ui.home.HomeActivity.Companion.BOOKMARKS_PAGE
import com.appbusters.robinpc.constitutionofindia.ui.home.HomeActivity.Companion.HOME_PAGE
import com.appbusters.robinpc.constitutionofindia.ui.home.fragments.bookmarks_fragment.BookmarkFragment
import com.appbusters.robinpc.constitutionofindia.ui.home.fragments.home_fragment.HomeFragment

class HomeFragmentAdapter(fragmentManager: FragmentManager):
        FragmentStatePagerAdapter(fragmentManager),
        HomeFragment.OnLoadCompleteListener, HomeFragment.OnSyncCompleteListener {

    private lateinit var onSyncCompleteListener: OnSyncCompleteListener
    private lateinit var onLoadCompleteListener: OnLoadCompleteListener

    companion object {
        const val PAGE_COUNT = 2
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            HOME_PAGE ->  {
                val fragment = HomeFragment.newInstance()
                fragment.setOnLoadCompleteListener(this)
                fragment.setOnSyncCompleteListener(this)
                return fragment
            }
            BOOKMARKS_PAGE -> return BookmarkFragment.newInstance()
            else -> return BookmarkFragment.newInstance()
        }
    }

    override fun getCount(): Int {
        return PAGE_COUNT
    }

    override fun onLoadComplete() {
        onLoadCompleteListener.onLoadComplete()
    }

    override fun onSyncCompleted() {
        onSyncCompleteListener.onSyncComplete()
    }

    fun setLoadCompleteListener(onLoadCompleteListener: OnLoadCompleteListener) {
        this.onLoadCompleteListener = onLoadCompleteListener
    }

    fun setOnSyncCompleteListener(onSyncCompleteListener: OnSyncCompleteListener) {
        this.onSyncCompleteListener = onSyncCompleteListener
    }

    interface OnLoadCompleteListener {
        fun onLoadComplete()
    }

    interface OnSyncCompleteListener {
        fun onSyncComplete()
    }
}
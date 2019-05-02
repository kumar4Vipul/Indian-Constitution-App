package com.appbusters.robinpc.constitutionofindia.ui.home.home_fragment.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.appbusters.robinpc.constitutionofindia.ui.home.home_fragment.featured_fragment.FeaturedFragment

class FeaturedPagerAdapter(fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {

    companion object {
        const val PAGE_COUNT = 3
    }

    override fun getItem(position: Int): Fragment {
            return FeaturedFragment.newInstance(position)
    }

    override fun getCount(): Int {
        return PAGE_COUNT
    }
}
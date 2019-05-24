package com.appbusters.robinpc.constitutionofindia.ui.home.fragments.bookmarks_fragment

import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseFragment

class BookmarkFragment : BaseFragment() {

    companion object {
        fun newInstance() = BookmarkFragment()
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_bookmark
    }

    override fun setup() {

    }
}

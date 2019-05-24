package com.appbusters.robinpc.constitutionofindia.ui.home.fragments.bookmarks_fragment

import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_bookmark.*

class BookmarkFragment : BaseFragment() {

    private var savedSchedulesCount = 0
    private var savedAmendmentsCount = 0
    private var savedArticlesCount = 0
    private var savedPreambleCount = 0

    companion object {
        fun newInstance() = BookmarkFragment()
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_bookmark
    }

    override fun setup() {
        setClickListeners()
        fetchSavedItemCount()
    }

    private fun setClickListeners() {
        savedSchedulesButton.setOnClickListener {
        }
        savedArticlesButton.setOnClickListener {
        }
        savedAmendmentsButton.setOnClickListener {
        }
        savedPreambleButton.setOnClickListener {
        }
    }

    private fun fetchSavedItemCount() {
        //TODO: fetch saved item count for each category by room and store them in count variables
        setCountForFetchResult()
    }

    private fun setCountForFetchResult() {
        context?.let {
            savedSchedulesCountTv.text = getCountString(savedSchedulesCount)
            savedArticlesCountTv.text = getCountString(savedArticlesCount)
            savedAmendmentsCountTv.text = getCountString(savedAmendmentsCount)
            savedPreambleCountTv.text = getCountString(savedPreambleCount)
        }
    }

    private fun getCountString(count: Int): String {
        val savedString = getString(R.string.saved)
        return count.toString().plus(" ").plus(savedString)
    }
}

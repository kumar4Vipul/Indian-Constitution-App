package com.appbusters.robinpc.constitutionofindia.ui.home.fragments.bookmarks_fragment

import android.app.Activity
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.appbusters.robinpc.constitutionofindia.ConstitutionApp
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.data.model.ReadElement
import com.appbusters.robinpc.constitutionofindia.di.component.fragment.DaggerBookmarkFragmentComponent
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseFragment
import com.appbusters.robinpc.constitutionofindia.ui.listing.category_listing.adapter.SavedItemAdapter
import com.appbusters.robinpc.constitutionofindia.ui.listing.saved_category_listing.SavedCategoryActivity
import com.appbusters.robinpc.constitutionofindia.ui.reading.ReadingActivity
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_AMENDMENTS
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_PARTS
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_PREAMBLE
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_SCHEDULES
import kotlinx.android.synthetic.main.fragment_bookmark.*
import javax.inject.Inject

class BookmarkFragment : BaseFragment(), SavedItemAdapter.SavedItemClickListener {

    private var isViewShown = false
    private var isSavedItemListEmpty = true

    @Inject
    lateinit var savedItemsAdapter: SavedItemAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: BookmarkFragmentViewModel

    companion object {
        const val SAVED_ITEMS_ADAPTER_SPAN_COUNT = 2

        fun newInstance() = BookmarkFragment()
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_bookmark
    }

    override fun setup() {

        if(isViewShown)
            lottieAnimationView.playAnimation()

        setComponent()
        setAllSavedAdapter()
        setClickListeners()
        setObservers()
    }

    private fun setComponent() {
        activity?.let {
            DaggerBookmarkFragmentComponent.builder()
                    .constitutionAppComponent(ConstitutionApp.get(it).constitutionAppComponent())
                    .build().injectBookmarkFragment(this)
        }

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(BookmarkFragmentViewModel::class.java)
    }

    private fun setObservers() {
        viewModel.getSavedAmendmentsCount().observe(this, Observer {
            it?.let {
                savedAmendmentsCountTv.text = getCountString(it)
            }
        })
        viewModel.getSavedArticlesCount().observe(this, Observer {
            it?.let {
                savedArticlesCountTv.text = getCountString(it)
            }
        })
        viewModel.getSavedPreambleCount().observe(this, Observer {
            it?.let {
                savedPreambleCountTv.text = getCountString(it)
            }
        })
        viewModel.getSavedSchedulesCount().observe(this, Observer {
            it?.let {
                savedSchedulesCountTv.text = getCountString(it)
            }
        })
        viewModel.getSavedElements().observe(this, Observer {
            it?.let {
                if(it.isNotEmpty()) {
                    savedItemsAdapter.submitList(it)
                    allSavedItemsRecycler.visibility = View.VISIBLE
                    isSavedItemListEmpty = false
                    noItemsSavedView.visibility = View.GONE
                    lottieAnimationView.pauseAnimation()
                }
                else {
                    isSavedItemListEmpty = true
                    allSavedItemsRecycler.visibility = View.GONE
                    noItemsSavedView.visibility = View.VISIBLE
                    lottieAnimationView.playAnimation()
                }
            } ?: run {
                isSavedItemListEmpty = true
                allSavedItemsRecycler.visibility = View.GONE
                noItemsSavedView.visibility = View.VISIBLE
                lottieAnimationView.playAnimation()
            }
        })
    }

    private fun setClickListeners() {
        savedSchedulesButton.setOnClickListener {
            launchSavedListActivity(CATEGORY_SCHEDULES)
        }
        savedArticlesButton.setOnClickListener {
            launchSavedListActivity(CATEGORY_PARTS)
        }
        savedAmendmentsButton.setOnClickListener {
            launchSavedListActivity(CATEGORY_AMENDMENTS)
        }
        savedPreambleButton.setOnClickListener {
            launchSavedListActivity(CATEGORY_PREAMBLE)
        }
    }

    private fun setAllSavedAdapter() {
        savedItemsAdapter.setSavedItemClickListener(this)

        context?.let {
            allSavedItemsRecycler.layoutManager =
                    GridLayoutManager(it, SAVED_ITEMS_ADAPTER_SPAN_COUNT, RecyclerView.VERTICAL, false)
        }
        allSavedItemsRecycler.adapter = savedItemsAdapter
    }

    private fun getCountString(count: Int): String {
        val savedString = getString(R.string.saved)
        return count.toString().plus(" ").plus(savedString)
    }

    override fun onSavedItemClicked(readElement: ReadElement) {
        context?.let {
            it.startActivity(ReadingActivity.newIntent(it, readElement))
            (it as Activity).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }

    private fun launchSavedListActivity(categoryName: String) {
        context?.let {
            startActivity(SavedCategoryActivity.newIntent(it, categoryName))
            (it as Activity).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)

        view?.let {
            isViewShown = true

            if(isSavedItemListEmpty) {
                if(isVisibleToUser) lottieAnimationView.playAnimation()
                else lottieAnimationView.pauseAnimation()
            }

        } ?: run {
            isViewShown = false
        }
    }
}

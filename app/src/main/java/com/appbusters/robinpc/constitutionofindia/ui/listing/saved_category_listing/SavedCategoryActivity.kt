package com.appbusters.robinpc.constitutionofindia.ui.listing.saved_category_listing

import android.content.Context
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.appbusters.robinpc.constitutionofindia.ConstitutionApp
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.data.model.ReadElement
import com.appbusters.robinpc.constitutionofindia.di.component.activity.DaggerSavedCategoryActivityComponent
import com.appbusters.robinpc.constitutionofindia.di.module.activity.SavedCategoryActivityModule
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseActivity
import com.appbusters.robinpc.constitutionofindia.ui.listing.category_listing.adapter.ListingListAdapter
import com.appbusters.robinpc.constitutionofindia.ui.reading.ReadingActivity
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_category_listing.*
import kotlinx.android.synthetic.main.activity_saved_category.*
import javax.inject.Inject

class SavedCategoryActivity : BaseActivity(), ListingListAdapter.ListItemClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var listingAdapter: ListingListAdapter

    private lateinit var categoryName: String
    private lateinit var viewModel: SavedCategoryActivityViewModel

    companion object {
        fun newIntent(context: Context, categoryName: String): Intent {
            val intent = Intent(context, SavedCategoryActivity::class.java)
            intent.putExtra(EXTRA_CATEGORY, categoryName)
            return intent
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_saved_category
    }

    override fun setup() {
        setStatusBarColor(R.color.reading_status_bar)
        setComponent()
        getIntentData()
        initViews()
        setObservers()
    }

    private fun getIntentData() {
        categoryName = intent.getStringExtra(EXTRA_CATEGORY)
    }

    private fun setComponent() {
        DaggerSavedCategoryActivityComponent.builder()
                .constitutionAppComponent(ConstitutionApp.get(this).constitutionAppComponent())
                .savedCategoryActivityModule(SavedCategoryActivityModule(this))
                .build().injectSavedCategoryActivity(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SavedCategoryActivityViewModel::class.java)
    }

    private fun initViews() {
        headerSavedTv.text = getHeaderString(categoryName)

        setRecycler()
    }

    private fun setRecycler() {
        listingSavedRv.layoutManager = LinearLayoutManager(this)
        listingSavedRv.adapter = listingAdapter
        listingAdapter.setListItemClickListener(this)
    }

    private fun setObservers() {
        viewModel.getCategorySavedElements(categoryName).observe(this, Observer {
            it?.let {
                listingAdapter.submitList(it)
            }
        })
    }

    private fun getHeaderString(categoryName: String): String {
        val savedString = getString(R.string.saved)
        return savedString.plus(" ").plus(categoryName)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    override fun onListItemClicked(readElement: ReadElement) {
        startActivity(ReadingActivity.newIntent(this, readElement))
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }
}

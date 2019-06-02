package com.appbusters.robinpc.constitutionofindia.ui.listing.tag_children

import android.content.Context
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.appbusters.robinpc.constitutionofindia.ConstitutionApp
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.data.model.ReadElement
import com.appbusters.robinpc.constitutionofindia.data.model.Tag
import com.appbusters.robinpc.constitutionofindia.di.component.activity.DaggerTagChildrenActivityComponent
import com.appbusters.robinpc.constitutionofindia.di.module.activity.TagChildrenActivityModule
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseActivity
import com.appbusters.robinpc.constitutionofindia.ui.listing.category_listing.adapter.ListingListAdapter
import com.appbusters.robinpc.constitutionofindia.ui.reading.ReadingActivity
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.EXTRA_TAG
import kotlinx.android.synthetic.main.activity_tag_children.*
import javax.inject.Inject

class TagChildrenActivity : BaseActivity(), ListingListAdapter.ListItemClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var listingAdapter: ListingListAdapter

    private lateinit var displayTag: Tag
    private lateinit var elementIds: List<Int>
    private lateinit var viewModel: TagChildrenActivityViewModel

    companion object {
        fun newIntent(context: Context, tag: Tag): Intent {
            val intent = Intent(context, TagChildrenActivity::class.java)
            intent.putExtra(EXTRA_TAG, tag)
            return intent
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_tag_children
    }

    override fun setup() {
        setStatusBarColor(R.color.tags_children_status_bar)
        getIntentData()
        setComponent()
        renderViewsForTag()
        setObservers()
    }

    private fun getIntentData() {
        displayTag = intent.getParcelableExtra(EXTRA_TAG)
        elementIds = displayTag.readElementIds
    }

    private fun setComponent() {
        DaggerTagChildrenActivityComponent.builder()
                .constitutionAppComponent(ConstitutionApp.get(this).constitutionAppComponent())
                .tagChildrenActivityModule(TagChildrenActivityModule(this))
                .build().injectTagChildrenActivity(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(TagChildrenActivityViewModel::class.java)
    }

    private fun renderViewsForTag() {
        titleTagTv.text = displayTag.elaborateTitle

        setRecycler()
    }

    private fun setObservers() {
        viewModel.getElementsForIds(elementIds).observe(this, Observer {
            it?.let {
                listingAdapter.submitList(it)
            }
        })
    }

    private fun setRecycler() {
        tagChildrenRecycler.adapter = listingAdapter
        tagChildrenRecycler.layoutManager = LinearLayoutManager(this)
        listingAdapter.setListItemClickListener(this)
    }

    override fun onListItemClicked(readElement: ReadElement) {
        startActivity(ReadingActivity.newIntent(this, readElement))
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.no_animation, R.anim.slide_out_right)
    }
}

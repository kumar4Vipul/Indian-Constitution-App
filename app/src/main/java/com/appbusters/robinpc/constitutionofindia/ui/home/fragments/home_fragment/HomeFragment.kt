package com.appbusters.robinpc.constitutionofindia.ui.home.fragments.home_fragment

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.appbusters.robinpc.constitutionofindia.ConstitutionApp

import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.utils.ZoomOutPageTransformer
import com.appbusters.robinpc.constitutionofindia.data.model.Category
import com.appbusters.robinpc.constitutionofindia.data.model.Tag
import com.appbusters.robinpc.constitutionofindia.di.component.fragment.DaggerHomeFragmentComponent
import com.appbusters.robinpc.constitutionofindia.di.module.fragment.HomeFragmentModule
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseFragment
import com.appbusters.robinpc.constitutionofindia.ui.home.fragments.home_fragment.adapter.CategoriesListAdapter
import com.appbusters.robinpc.constitutionofindia.ui.home.fragments.home_fragment.adapter.FeaturedPagerAdapter
import com.appbusters.robinpc.constitutionofindia.ui.home.fragments.home_fragment.adapter.TagListAdapter
import com.appbusters.robinpc.constitutionofindia.ui.intermediate.MiddleActivity
import com.appbusters.robinpc.constitutionofindia.ui.listing.category_listing.CategoryListingActivity
import com.appbusters.robinpc.constitutionofindia.ui.listing.tag_children.TagChildrenActivity
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.AMENDMENTS_END_INDEX
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.AMENDMENTS_START_INDEX
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_AMENDMENTS
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_PARTS
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_PREAMBLE
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_SCHEDULES
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.NUMBER_OF_ELEMENTS
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.NUMBER_OF_PARTS
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.NUMBER_OF_TAGS
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.PREAMBLE_INDEX
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.SCHEDULES_END_INDEX
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.SCHEDULES_START_INDEX
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : BaseFragment(),
        CategoriesListAdapter.CategoryClickListener,
        TagListAdapter.OnTagClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var categoriesAdapter: CategoriesListAdapter

    @Inject
    lateinit var featuredPagerAdapter: FeaturedPagerAdapter

    @Inject
    lateinit var tagsAdapter: TagListAdapter

    private lateinit var onLoadCompleteListener: OnLoadCompleteListener
    private lateinit var viewModel: HomeFragmentViewModel

    override fun getLayoutResId(): Int {
        return R.layout.fragment_home
    }

    companion object {
        const val CATEGORY_SPAN_COUNT = 2
        const val TAG_SPAN_COUNT = 4

        fun newInstance() = HomeFragment()
    }

    override fun setup() {
        setComponent()
        setObservers()
        setFeaturedPagerAdapter()
        setCategoriesAdapter()
        setTagsAdapter()
        fetchData()
        setClickListeners()
    }

    private fun setComponent() {
        activity?.let {
            DaggerHomeFragmentComponent.builder()
                    .constitutionAppComponent(ConstitutionApp.get(it).constitutionAppComponent())
                    .homeFragmentModule(HomeFragmentModule(childFragmentManager, it.baseContext))
                    .build().injectHomeFragment(this)
        }

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeFragmentViewModel::class.java)
    }

    private fun setClickListeners() {
    }

    private fun setObservers() {

        viewModel.getAllTags().observe(this, Observer {

            if(!it.isNullOrEmpty()) {
                if(it.size == NUMBER_OF_TAGS) {

                    tagsAdapter.submitList(viewModel.getSubmitTagList(it))

                    setPartsObserver()
                }
            }
            else
                viewModel.loadTagsFromJson()
        })

        viewModel.categoriesListLiveData.observe(this, Observer {
            it?.let {
                categoriesAdapter.submitList(it)
            }
        })
    }

    private fun setPartsObserver() {

        viewModel.getAllParts().observe(this, Observer {
            if(it.isNullOrEmpty()) {
                viewModel.loadPartsFromJson()
            }
            else {
                if(it.size != NUMBER_OF_PARTS) viewModel.loadPartsFromJson()
                else setElementsObserver()
            }
        })

        setElementsObserver()
    }

    private fun setElementsObserver() {
        viewModel.getAllElements().observe(this, Observer {
            if(it.isNullOrEmpty())
                viewModel.loadElementsFromJson()
            else {
                if(it.size != NUMBER_OF_ELEMENTS) viewModel.loadElementsFromJson()
                else onLoadCompleteListener.onLoadComplete()
            }
        })
    }

    private fun fetchData() {
        viewModel.inflateCategoriesList()
    }

    private fun setFeaturedPagerAdapter() {
        featuredViewPager.adapter = featuredPagerAdapter
        featuredViewPager.setPageTransformer(false, ZoomOutPageTransformer())
        dotPagerIndicator.setViewPager(featuredViewPager)
    }

    private fun setCategoriesAdapter() {
        categoriesAdapter.setCategoryClickListener(this)
        categoriesRecycler.adapter = categoriesAdapter
        categoriesRecycler.layoutManager = GridLayoutManager(context, CATEGORY_SPAN_COUNT, RecyclerView.VERTICAL, false)
    }

    private fun setTagsAdapter() {
        tagsRecycler.adapter = tagsAdapter
        tagsAdapter.setTagClickListener(this)
        tagsRecycler.layoutManager = StaggeredGridLayoutManager(TAG_SPAN_COUNT, RecyclerView.HORIZONTAL)
    }

    override fun onCategoryClicked(category: Category) {
        context?.let {

            var intent: Intent? = null

            when(category.name) {
                CATEGORY_PARTS ->
                    intent = MiddleActivity.newIntent(it, category.name)
                CATEGORY_PREAMBLE ->
                    intent = CategoryListingActivity.newIntent(it, category.name, category.name, PREAMBLE_INDEX, PREAMBLE_INDEX)
                CATEGORY_SCHEDULES ->
                    intent = CategoryListingActivity.newIntent(it, category.name, category.name, SCHEDULES_START_INDEX, SCHEDULES_END_INDEX)
                CATEGORY_AMENDMENTS ->
                    intent = CategoryListingActivity.newIntent(it, category.name, category.name, AMENDMENTS_START_INDEX, AMENDMENTS_END_INDEX)
            }

            startActivity(intent)
            (it as Activity).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }

    override fun onTagClicked(tag: Tag) {
        context?.let {
            startActivity(TagChildrenActivity.newIntent(it, tag))
            (it as Activity).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }

    fun setOnLoadCompleteListener(onLoadCompleteListener: OnLoadCompleteListener) {
        this.onLoadCompleteListener = onLoadCompleteListener
    }

    interface OnLoadCompleteListener {
        fun onLoadComplete()
    }
}

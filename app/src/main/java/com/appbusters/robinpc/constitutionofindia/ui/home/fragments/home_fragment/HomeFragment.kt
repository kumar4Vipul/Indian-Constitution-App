package com.appbusters.robinpc.constitutionofindia.ui.home.fragments.home_fragment

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.data.model.Category
import com.appbusters.robinpc.constitutionofindia.data.model.Tag
import com.appbusters.robinpc.constitutionofindia.di.component.fragment.DaggerHomeFragmentComponent
import com.appbusters.robinpc.constitutionofindia.di.module.fragment.HomeFragmentModule
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseFragment
import com.appbusters.robinpc.constitutionofindia.ui.home.fragments.home_fragment.adapter.CategoriesListAdapter
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
    lateinit var gridLayoutManager: GridLayoutManager

    @Inject
    lateinit var staggeredGridLayoutManager: StaggeredGridLayoutManager

    @Inject
    lateinit var categoriesAdapter: CategoriesListAdapter

    @Inject
    lateinit var tagsAdapter: TagListAdapter

    private lateinit var viewModel: HomeFragmentViewModel
    private lateinit var onSyncCompleteListener: OnSyncCompleteListener
    private lateinit var onLoadCompleteListener: OnLoadCompleteListener

    companion object {
        const val TAG_SPAN_COUNT = 4
        const val CATEGORY_SPAN_COUNT = 2

        fun newInstance() = HomeFragment()
    }

    override fun setup() {
        setComponent()
        setObservers()
        setCategoriesRecycler()
        setTagsAdapter()
        fetchData()
    }

    private fun setObservers() {
        setCategoriesListObserver()
        setTagsObserver()
    }

    private fun setCategoriesListObserver() {
        if(::viewModel.isInitialized)
            viewModel.categoriesListLiveData.observe(this, Observer {
                it?.let {
                    categoriesAdapter.submitList(it)
                }
            })
    }

    private fun setTagsObserver() {
        if(::viewModel.isInitialized)
            viewModel.getAllTags().observe(this, Observer {

                if(!it.isNullOrEmpty()) {
                    if(it.size == NUMBER_OF_TAGS) {

                        tagsAdapter.submitList(viewModel.getSubmitTagList(it))

                        if(::onLoadCompleteListener.isInitialized)
                            onLoadCompleteListener.onLoadComplete()

                        setPartsObserver()
                    }
                }
                else
                    viewModel.loadTagsFromJson()
            })
    }

    private fun setPartsObserver() {
        if(::viewModel.isInitialized)
            viewModel.getAllParts().observe(this, Observer {
                if(it.isNullOrEmpty()) {
                    viewModel.loadPartsFromJson()
                }
                else {
                    if(it.size != NUMBER_OF_PARTS) viewModel.loadPartsFromJson()
                    else setElementsObserver()
                }
            })
    }

    private fun setElementsObserver() {
        if(::viewModel.isInitialized)
            viewModel.getAllElements().observe(this, Observer {
                if(it.isNullOrEmpty())
                    viewModel.loadElementsFromJson()
                else {
                    if(it.size != NUMBER_OF_ELEMENTS)
                        viewModel.loadElementsFromJson()
                    else
                        onSyncCompleteListener.onSyncCompleted()
                }
            })
    }

    private fun fetchData() {
        if(::viewModel.isInitialized)
            viewModel.inflateCategoriesList()
    }

    private fun setCategoriesRecycler() {
        categoriesRecycler.adapter = categoriesAdapter
        categoriesRecycler.layoutManager = gridLayoutManager
    }

    private fun setTagsAdapter() {
        tagsRecycler.adapter = tagsAdapter
        tagsRecycler.layoutManager = staggeredGridLayoutManager
    }

    override fun onCategoryClicked(category: Category) {
        val categoryName = category.name
        var start: Int = PREAMBLE_INDEX
        var end: Int = PREAMBLE_INDEX

        when(categoryName) {
            CATEGORY_PARTS -> {
                openMiddleActivity(categoryName)
                return
            }
            CATEGORY_PREAMBLE -> {
                start = PREAMBLE_INDEX
                end = PREAMBLE_INDEX
            }
            CATEGORY_SCHEDULES -> {
                start = SCHEDULES_START_INDEX
                end = SCHEDULES_END_INDEX
            }
            CATEGORY_AMENDMENTS -> {
                start = AMENDMENTS_START_INDEX
                end = AMENDMENTS_END_INDEX
            }
        }

        openCategoryListActivity(categoryName, start, end)
    }

    private fun openMiddleActivity(categoryName: String) {
        context?.let {
            startActivity(MiddleActivity.newIntent(it, categoryName))
            animateActivityTransition(R.anim.slide_in_right, R.anim.no_animation)
        }
    }

    private fun openCategoryListActivity(categoryName: String, start: Int, end: Int) {
        context?.let {
            startActivity(
                    CategoryListingActivity.newIntent(it, categoryName, categoryName, start, end)
            )
            animateActivityTransition(R.anim.slide_in_right, R.anim.no_animation)
        }
    }

    override fun onTagClicked(tag: Tag) {
        context?.let {
            startActivity(TagChildrenActivity.newIntent(it, tag))
            animateActivityTransition(R.anim.slide_in_right, R.anim.no_animation)
        }
    }

    private fun setComponent() {
        activity?.let {
            val component = DaggerHomeFragmentComponent.builder()
                    .constitutionAppComponent(getAppComponent(it))
                    .homeFragmentModule(getModule())
                    .build()

            component.injectHomeFragment(this)
        }

        viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(HomeFragmentViewModel::class.java)
    }

    private fun getModule(): HomeFragmentModule {
        return HomeFragmentModule(
                this,
                this,
                CATEGORY_SPAN_COUNT,
                TAG_SPAN_COUNT
        )
    }

    fun setOnLoadCompleteListener(onLoadCompleteListener: OnLoadCompleteListener) {
        this.onLoadCompleteListener = onLoadCompleteListener
    }

    fun setOnSyncCompleteListener(onSyncCompleteListener: OnSyncCompleteListener) {
        this.onSyncCompleteListener = onSyncCompleteListener
    }

    interface OnLoadCompleteListener {
        fun onLoadComplete()
    }

    interface OnSyncCompleteListener {
        fun onSyncCompleted()
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_home
    }
}

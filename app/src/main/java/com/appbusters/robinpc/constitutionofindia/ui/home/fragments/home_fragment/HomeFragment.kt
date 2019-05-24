package com.appbusters.robinpc.constitutionofindia.ui.home.fragments.home_fragment

import android.app.Activity
import android.content.Intent
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
import com.appbusters.robinpc.constitutionofindia.ui.listing.tag_listing.TagChildrenActivity
import com.appbusters.robinpc.constitutionofindia.utils.Constants
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.AMENDMENTS_END_INDEX
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.AMENDMENTS_START_INDEX
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_AMENDMENTS
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_PARTS
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_PREAMBLE
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_SCHEDULES
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_STATE
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.PREAMBLE_INDEX
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.SCHEDULES_END_INDEX
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.SCHEDULES_START_INDEX
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_home.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset
import javax.inject.Inject

class HomeFragment : BaseFragment(),
        CategoriesListAdapter.CategoryClickListener,
        TagListAdapter.OnTagClickListener {

    @Inject
    lateinit var gson: Gson

    @Inject
    lateinit var databaseInputStream: InputStream

    @Inject
    lateinit var categoriesAdapter: CategoriesListAdapter

    @Inject
    lateinit var featuredPagerAdapter: FeaturedPagerAdapter

    @Inject
    lateinit var tagsAdapter: TagListAdapter

    private var tagsList: MutableList<Tag> = ArrayList()

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
        setClickListeners()
        setFeaturedPagerAdapter()
        setCategoriesAdapter()
        setTagsAdapter()
    }

    private fun setComponent() {
        activity?.let {
            DaggerHomeFragmentComponent.builder()
                    .constitutionAppComponent(ConstitutionApp.get(it).constitutionAppComponent())
                    .homeFragmentModule(HomeFragmentModule(childFragmentManager, it.baseContext))
                    .build().injectHomeFragment(this)
        }
    }

    private fun setClickListeners() {
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
        categoriesAdapter.submitList(getCategoriesList())
    }

    private fun getCategoriesList(): MutableList<Category> {
        val categoriesList = ArrayList<Category>()
        categoriesList.add(Category(R.color.schedules_color, CATEGORY_SCHEDULES))
        categoriesList.add(Category(R.color.parts_color, CATEGORY_PARTS))
        categoriesList.add(Category(R.color.amendment_color, CATEGORY_AMENDMENTS))
        categoriesList.add(Category(R.color.preamble_color, CATEGORY_PREAMBLE))
        return categoriesList
    }

    private fun setTagsAdapter() {
        loadTags()
        tagsRecycler.adapter = tagsAdapter
        tagsAdapter.setTagClickListener(this)
        tagsRecycler.layoutManager = StaggeredGridLayoutManager(TAG_SPAN_COUNT, RecyclerView.HORIZONTAL)
        tagsAdapter.submitList(tagsList)
    }

    private fun loadTags() {
        try {
            inflateTagsList(getJsonTagsArray())
        }
        catch (e: IOException) {
            //TODO: be very very sorry to the user. apologize like hell.
        }
    }

    private fun inflateTagsList(tags: JSONArray) {
        var  tagItem: Tag
        for(tagNumber: Int in 0 until tags.length()) {
            tagItem = gson.fromJson(tags.getJSONObject(tagNumber).toString(), Tag::class.java)

            if(!tagItem.categoryName.equals(CATEGORY_STATE))
                tagsList.add(tagItem)
        }
    }

    private fun getJsonTagsArray(): JSONArray {
        val json: String?
        val buffer = ByteArray(databaseInputStream.available())
        databaseInputStream.read(buffer)
        databaseInputStream.close()
        json = String(buffer, Charset.forName(Constants.CHARSET_UTF_8))

        val jsonObject = JSONObject(json)
        return jsonObject.getJSONArray(Constants.JSON_TAGS)
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
}
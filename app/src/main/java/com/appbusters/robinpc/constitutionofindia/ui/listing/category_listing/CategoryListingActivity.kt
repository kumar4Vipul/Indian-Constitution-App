package com.appbusters.robinpc.constitutionofindia.ui.listing.category_listing

import android.content.Context
import android.content.Intent
import com.appbusters.robinpc.constitutionofindia.ConstitutionApp
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.data.model.ReadElement
import com.appbusters.robinpc.constitutionofindia.di.component.activity.DaggerListingActivityComponent
import com.appbusters.robinpc.constitutionofindia.di.module.activity.ListingActivityModule
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseActivity
import com.appbusters.robinpc.constitutionofindia.ui.listing.category_listing.adapter.ListingListAdapter
import com.appbusters.robinpc.constitutionofindia.ui.reading.ReadingActivity
import com.appbusters.robinpc.constitutionofindia.utils.Constants
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.DEFAULT_VALUE_INT
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.EXTRA_CATEGORY
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.EXTRA_END_INDEX
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.EXTRA_START_INDEX
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.EXTRA_TITLE
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.JSON_READ_ELEMENTS
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_category_listing.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset
import javax.inject.Inject

class CategoryListingActivity : BaseActivity(), ListingListAdapter.ListItemClickListener {

    @Inject
    lateinit var listingAdapter: ListingListAdapter

    @Inject
    lateinit var gson: Gson

    @Inject
    lateinit var databaseInputStream: InputStream

    var startIndex: Int = 0
    var endIndex: Int = 0
    lateinit var titleName: String
    private var elementsList: MutableList<ReadElement> = ArrayList()

    companion object {
        fun newIntent(context: Context, categoryName: String, title: String, start: Int, end: Int): Intent {
            val intent = Intent(context, CategoryListingActivity::class.java)
            intent.putExtra(EXTRA_CATEGORY, categoryName)
            intent.putExtra(EXTRA_START_INDEX, start)
            intent.putExtra(EXTRA_END_INDEX, end)
            intent.putExtra(EXTRA_TITLE, title)
            return intent
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_category_listing
    }

    override fun setup() {
        setStatusBarColor(R.color.reading_status_bar)
        setComponent()
        getIntentData()
        loadReadElements()
        renderViewsForData()
    }

    private fun setComponent() {
        DaggerListingActivityComponent.builder()
                .constitutionAppComponent(ConstitutionApp.get(this).constitutionAppComponent())
                .listingActivityModule(ListingActivityModule(this))
                .build().injectListingActivity(this)
    }

    private fun getIntentData() {
        startIndex = intent.getIntExtra(EXTRA_START_INDEX, DEFAULT_VALUE_INT)
        endIndex = intent.getIntExtra(EXTRA_END_INDEX, DEFAULT_VALUE_INT)
        titleName = intent.getStringExtra(EXTRA_TITLE)
    }

    private fun loadReadElements() {

        try {
            inflateElementsList(getJsonElementsArray(), startIndex, endIndex)
        }
        catch (e: IOException) {
            //TODO: be very very sorry to the user. apologize like hell.
        }
    }

    private fun inflateElementsList(readElements: JSONArray, start: Int, end: Int) {
        for(elementId: Int in start..end)
            elementsList.add(
                    gson.fromJson(
                            readElements.getJSONObject(elementId).toString(),
                            ReadElement::class.java)
            )
    }

    private fun getJsonElementsArray(): JSONArray {
        val json: String?
        val buffer = ByteArray(databaseInputStream.available())
        databaseInputStream.read(buffer)
        databaseInputStream.close()
        json = String(buffer, Charset.forName(Constants.CHARSET_UTF_8))

        val jsonObject = JSONObject(json)
        return jsonObject.getJSONArray(JSON_READ_ELEMENTS)
    }

    private fun renderViewsForData() {
        headerListingTv.text = titleName

        setRecycler()
    }

    private fun setRecycler() {
        listingRv.adapter = listingAdapter
        listingAdapter.submitList(elementsList)
        listingAdapter.setListItemClickListener(this)
    }

    override fun onListItemClicked(readElement: ReadElement) {
        startActivity(ReadingActivity.newIntent(this, readElement))
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}


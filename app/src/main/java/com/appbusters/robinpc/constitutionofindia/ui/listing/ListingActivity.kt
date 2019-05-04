package com.appbusters.robinpc.constitutionofindia.ui.listing

import android.content.Context
import android.content.Intent
import com.appbusters.robinpc.constitutionofindia.ConstitutionApp
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.data.model.ReadElement
import com.appbusters.robinpc.constitutionofindia.di.component.activity.DaggerListingActivityComponent
import com.appbusters.robinpc.constitutionofindia.di.module.activity.ListingActivityModule
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseActivity
import com.appbusters.robinpc.constitutionofindia.utils.Constants
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.AMENDMENTS_END_INDEX
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.AMENDMENTS_START_INDEX
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_AMENDMENTS
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_SCHEDULES
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.EXTRA_CATEGORY
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.JSON_READ_ELEMENTS
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.SCHEDULES_END_INDEX
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.SCHEDULES_START_INDEX
import com.google.gson.Gson
import com.google.gson.JsonArray
import kotlinx.android.synthetic.main.activity_listing.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset
import javax.inject.Inject

class ListingActivity : BaseActivity() {

    @Inject
    lateinit var gson: Gson

    @Inject
    lateinit var databaseInputStream: InputStream

    lateinit var categoryName: String
    private var elementsList: MutableList<ReadElement> = ArrayList()

    companion object {
        fun newIntent(context: Context, categoryName: String): Intent {
            val intent = Intent(context, ListingActivity::class.java)
            intent.putExtra(EXTRA_CATEGORY, categoryName)
            return intent
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_listing
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
        categoryName = intent.getStringExtra(EXTRA_CATEGORY)
    }

    private fun loadReadElements() {
        val rangePair: Pair<Int, Int> = getElementsRange(categoryName)

        try {
            inflateElementsList(getJsonElementsArray(), rangePair.first, rangePair.second)
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

    private fun getElementsRange(categoryName: String): Pair<Int, Int> {
        val startIndex: Int
        val endIndex: Int
        when(categoryName) {
            CATEGORY_AMENDMENTS -> {
                startIndex = AMENDMENTS_START_INDEX
                endIndex = AMENDMENTS_END_INDEX
            }
            CATEGORY_SCHEDULES -> {
                startIndex = SCHEDULES_START_INDEX
                endIndex = SCHEDULES_END_INDEX
            }
            else -> {
                startIndex = 0
                endIndex = 0
            }
        }
        return Pair(startIndex, endIndex)
    }

    private fun renderViewsForData() {
        headerListingTv.text = categoryName
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}


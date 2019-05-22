package com.appbusters.robinpc.constitutionofindia.ui.intermediate

import android.content.Context
import android.content.Intent
import com.appbusters.robinpc.constitutionofindia.ConstitutionApp
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.data.model.Part
import com.appbusters.robinpc.constitutionofindia.di.component.activity.DaggerMiddleActivityComponent
import com.appbusters.robinpc.constitutionofindia.di.module.activity.MiddleActivityModule
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseActivity
import com.appbusters.robinpc.constitutionofindia.ui.intermediate.adapter.MiddleListAdapter
import com.appbusters.robinpc.constitutionofindia.ui.listing.category_listing.CategoryListingActivity
import com.appbusters.robinpc.constitutionofindia.utils.Constants
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.EXTRA_CATEGORY
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_middle.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset
import javax.inject.Inject

class MiddleActivity : BaseActivity(), MiddleListAdapter.OnPartClickListener {

    @Inject
    lateinit var gson: Gson

    @Inject
    lateinit var middleAdapter: MiddleListAdapter

    @Inject
    lateinit var databaseInputStream: InputStream

    private lateinit var categoryName: String
    private var partsList: MutableList<Part> = ArrayList()

    companion object {
        fun newIntent(context: Context, categoryName: String): Intent {
            val intent = Intent(context, MiddleActivity::class.java)
            intent.putExtra(EXTRA_CATEGORY, categoryName)
            return intent
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_middle
    }

    override fun setup() {
        setStatusBarColor(R.color.intermediate_status_bar)
        setComponent()
        getIntentData()
        loadReadElements()
        renderViewsForData()
    }

    private fun setComponent() {
        DaggerMiddleActivityComponent.builder()
                .constitutionAppComponent(ConstitutionApp.get(this).constitutionAppComponent())
                .middleActivityModule(MiddleActivityModule(this))
                .build().injectMiddleActivity(this)
    }


    private fun loadReadElements() {
        try {
            inflateElementsList(getJsonElementsArray())
        }
        catch (e: IOException) {
            //TODO: be very very sorry to the user. apologize like hell.
        }
    }

    private fun inflateElementsList(parts: JSONArray) {
        for(elementId: Int in 0 until parts.length())
            partsList.add(
                    gson.fromJson(
                            parts.getJSONObject(elementId).toString(),
                            Part::class.java)
            )
    }

    private fun getJsonElementsArray(): JSONArray {
        val json: String?
        val buffer = ByteArray(databaseInputStream.available())
        databaseInputStream.read(buffer)
        databaseInputStream.close()
        json = String(buffer, Charset.forName(Constants.CHARSET_UTF_8))

        val jsonObject = JSONObject(json)
        return jsonObject.getJSONArray(Constants.JSON_PARTS)
    }

    private fun getIntentData() {
        categoryName = intent.getStringExtra(EXTRA_CATEGORY)
    }

    private fun renderViewsForData() {
        headerMiddleTv.text = categoryName
        setRecycler()
    }

    private fun setRecycler() {
        middleRv.adapter = middleAdapter
        middleAdapter.submitList(partsList)
        middleAdapter.setPartClickListener(this)
    }

    override fun onPartClicked(part: Part) {
        startActivity(CategoryListingActivity.newIntent(this, categoryName, part.title, part.startIndex, part.endIndex))
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}

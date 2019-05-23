package com.appbusters.robinpc.constitutionofindia.ui.listing.tag_listing

import android.content.Context
import android.content.Intent
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
import com.appbusters.robinpc.constitutionofindia.utils.Constants
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.EXTRA_TAG
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_tag_children.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset
import javax.inject.Inject

class TagChildrenActivity : BaseActivity(), ListingListAdapter.ListItemClickListener {

    @Inject
    lateinit var listingAdapter: ListingListAdapter

    @Inject
    lateinit var gson: Gson

    @Inject
    lateinit var databaseInputStream: InputStream

    private lateinit var displayTag: Tag
    private lateinit var elementIds: List<Int>
    private var elementsList: MutableList<ReadElement> = ArrayList()

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
        setStatusBarColor(R.color.title_gradient_top)
        getIntentData()
        setComponent()
        loadReadElements()
        renderViewsForTag()
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
    }

    private fun loadReadElements() {

        try {
            inflateElementsList(getJsonElementsArray())
        }
        catch (e: IOException) {
            //TODO: be very very sorry to the user. apologize like hell.
        }
    }

    private fun inflateElementsList(readElements: JSONArray) {
        for(index: Int in 0 until elementIds.size)
            elementsList.add(
                    gson.fromJson(
                            readElements.getJSONObject(elementIds[index]).toString(),
                            ReadElement::class.java
                    )
            )
    }

    private fun getJsonElementsArray(): JSONArray {
        val json: String?
        val buffer = ByteArray(databaseInputStream.available())
        databaseInputStream.read(buffer)
        databaseInputStream.close()
        json = String(buffer, Charset.forName(Constants.CHARSET_UTF_8))

        val jsonObject = JSONObject(json)
        return jsonObject.getJSONArray(Constants.JSON_READ_ELEMENTS)
    }

    private fun renderViewsForTag() {
        titleTagTv.text = displayTag.elaborateTitle

        setRecycler()
    }

    private fun setRecycler() {
        tagChildrenRecycler.adapter = listingAdapter
        tagChildrenRecycler.layoutManager = LinearLayoutManager(this)
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

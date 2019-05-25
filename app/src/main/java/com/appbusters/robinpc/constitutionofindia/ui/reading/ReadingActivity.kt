package com.appbusters.robinpc.constitutionofindia.ui.reading

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.text.Html
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.appbusters.robinpc.constitutionofindia.ConstitutionApp
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.data.model.DummyTag
import com.appbusters.robinpc.constitutionofindia.data.model.ReadElement
import com.appbusters.robinpc.constitutionofindia.di.component.activity.DaggerReadActivityComponent
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseActivity
import com.appbusters.robinpc.constitutionofindia.ui.reading.adapter.DummyTagListAdapter
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_AMENDMENTS
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_PARTS
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_PREAMBLE
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CATEGORY_SCHEDULES
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.EXTRA_READ_ELEMENT
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_reading.*
import javax.inject.Inject

class ReadingActivity : BaseActivity() {

    @Inject
    lateinit var gson: Gson

    @Inject
    lateinit var dummyTagsAdapter: DummyTagListAdapter

    private lateinit var readElement: ReadElement

    private var categoryColor: Int = 0
    private var isSaved: Boolean = false

    companion object {

        fun newIntent(context: Context, readElement: ReadElement): Intent {
            val intent = Intent(context, ReadingActivity::class.java)
            intent.putExtra(EXTRA_READ_ELEMENT, readElement)
            return intent
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_reading
    }

    override fun setup() {
        setStatusBarColor(R.color.reading_status_bar)
        getIntentData()
        setComponent()
        setTagsRecycler()
        renderInitial()
        setClickListeners()
    }

    private fun setComponent() {
        DaggerReadActivityComponent.builder()
                .constitutionAppComponent(ConstitutionApp.get(this).constitutionAppComponent())
                .build().injectReadingActivity(this)
    }

    private fun getIntentData() {
        readElement = intent.getParcelableExtra(EXTRA_READ_ELEMENT)
    }

    private fun renderInitial() {
        findCategoryColor()

        bottomLayoutLineIv.background = ContextCompat.getDrawable(this, categoryColor)
        bottomSaveStatusView.background = ContextCompat.getDrawable(this, categoryColor)

        renderReadElement()
    }

    private fun getShareString(title: String): String {
        val savedString = getString(R.string.share)
        return savedString.plus(" ").plus(title).plus(" :")
    }

    private fun findCategoryColor() {
        when(readElement.categoryName) {
            CATEGORY_PARTS -> categoryColor = R.color.parts_color
            CATEGORY_AMENDMENTS -> categoryColor = R.color.amendment_color
            CATEGORY_SCHEDULES -> categoryColor = R.color.schedules_color
            CATEGORY_PREAMBLE -> categoryColor = R.color.preamble_color
        }
    }

    @Suppress("DEPRECATION")
    private fun renderReadElement() {
        titleTv.text = readElement.title

        if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.N)
            contentTv.text = Html.fromHtml(readElement.content)
        else
            contentTv.text = Html.fromHtml(readElement.content, Html.FROM_HTML_MODE_COMPACT)

        dummyTagsAdapter.submitList(
                getTagsFromStrings(readElement.tags!!, readElement.categoryName!!)
        )
    }

    private fun getTagsFromStrings(stringTags: List<String>, categoryName: String): MutableList<DummyTag> {
        val tagsList: MutableList<DummyTag> = ArrayList()
        for(tag in stringTags) tagsList.add(DummyTag(tag, categoryName))
        return tagsList
    }

    private fun setTagsRecycler() {
        tagsRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        tagsRv.adapter = dummyTagsAdapter
    }

    private fun setClickListeners() {
        bottomSaveStatusView.setOnClickListener {
            //TODO: save if unsaved, unsave if saved
            if(isSaved) {
                saveStatusIv.setImageDrawable(getDrawableFromId(R.drawable.ic_bookmark))
                saveStatusTv.text = getStringFromId(R.string.save)
            }
            else {
                saveStatusIv.setImageDrawable(getDrawableFromId(R.drawable.ic_bookmark_filled))
                saveStatusTv.text = getStringFromId(R.string.saved)
            }
            isSaved = !isSaved
        }
    }

    private fun getStringFromId(id: Int): String {
        return resources.getString(id)
    }

    private fun getDrawableFromId(id: Int): Drawable {
        return ContextCompat.getDrawable(this, id)!!
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}
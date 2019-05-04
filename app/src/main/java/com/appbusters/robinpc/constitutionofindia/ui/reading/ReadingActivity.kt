package com.appbusters.robinpc.constitutionofindia.ui.reading

import android.content.Context
import android.content.Intent
import android.text.Html
import androidx.recyclerview.widget.LinearLayoutManager
import com.appbusters.robinpc.constitutionofindia.ConstitutionApp
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.DEFAULT_VALUE_INT
import com.appbusters.robinpc.constitutionofindia.data.model.ReadElement
import com.appbusters.robinpc.constitutionofindia.data.model.Tag
import com.appbusters.robinpc.constitutionofindia.di.component.activity.DaggerReadActivityComponent
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseActivity
import com.appbusters.robinpc.constitutionofindia.ui.reading.adapter.TagListAdapter
import com.appbusters.robinpc.constitutionofindia.utils.Constants
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.EXTRA_READ_ELEMENT
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_reading.*
import javax.inject.Inject

class ReadingActivity : BaseActivity() {

    @Inject
    lateinit var gson: Gson

    @Inject
    lateinit var tagsAdapter: TagListAdapter

    private var readElement: ReadElement? = null

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
        loadReadElement()
        setTagsRecycler()
        renderReadElement()
    }

    private fun setComponent() {
        DaggerReadActivityComponent.builder()
                .constitutionAppComponent(ConstitutionApp.get(this).constitutionAppComponent())
                .build().injectReadingActivity(this)
    }

    private fun getIntentData() {
        readElement = intent.getParcelableExtra(EXTRA_READ_ELEMENT)
    }

    @Suppress("DEPRECATION")
    private fun renderReadElement() {
        readElement?.let {
            titleTv.text = it.title

            if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.N)
                contentTv.text = Html.fromHtml(it.content)
            else
                contentTv.text = Html.fromHtml(it.content, Html.FROM_HTML_MODE_COMPACT)

            tagsAdapter.submitList(
                    getTagsFromStrings(it.tags!!, it.categoryName!!)
            )
        }
    }

    private fun getTagsFromStrings(stringTags: List<String>, categoryName: String): MutableList<Tag> {
        val tagsList: MutableList<Tag> = ArrayList()
        for(tag in stringTags) tagsList.add(Tag(tag, categoryName))
        return tagsList
    }

    private fun setTagsRecycler() {
        tagsRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        tagsRv.adapter = tagsAdapter
    }

    private fun loadReadElement() {
        //TODO: fetch read element from preferences or from serializable/parcelable
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}
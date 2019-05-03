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
import com.appbusters.robinpc.constitutionofindia.di.module.activity.ReadActivityModule
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseActivity
import com.appbusters.robinpc.constitutionofindia.ui.reading.adapter.TagListAdapter
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.CHARSET_UTF_8
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_reading.*
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset
import javax.inject.Inject

class ReadingActivity : BaseActivity() {

    @Inject
    lateinit var tagsAdapter: TagListAdapter

    @Inject
    lateinit var databaseInputStream: InputStream

    private var readElementId: Int = -1
    private var readElement: ReadElement? = null

    companion object {
        private const val READ_ELEMENT_ID = "READ_ELEMENT_ID"

        fun newIntent(context: Context, readElementId: Int): Intent {
            val intent = Intent(context, ReadingActivity::class.java)
            intent.putExtra(READ_ELEMENT_ID, readElementId)
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
                .readActivityModule(ReadActivityModule(this))
                .build().injectReadingActivity(this)
    }

    private fun getIntentData() {
        readElementId = intent.getIntExtra(READ_ELEMENT_ID, DEFAULT_VALUE_INT)
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
                    getTagsFromStrings(it.tags, it.categoryName)
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
        val json: String?
        try {
            val size = databaseInputStream.available()
            val buffer = ByteArray(size)
            databaseInputStream.read(buffer)
            databaseInputStream.close()
            json = String(buffer, Charset.forName(CHARSET_UTF_8))

            val jsonObject = JSONObject(json)
            val readElementsObjects = jsonObject.getJSONArray("read_elements")
            val readElementZero = readElementsObjects.getJSONObject(readElementId)
            readElement = Gson().fromJson(readElementZero.toString(), ReadElement::class.java)
        }
        catch (e: IOException) {
            //TODO: be very very sorry to the user. apologize like hell.
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}
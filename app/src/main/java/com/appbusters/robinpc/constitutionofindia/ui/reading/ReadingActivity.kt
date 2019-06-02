package com.appbusters.robinpc.constitutionofindia.ui.reading

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.text.Html
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
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
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.EXTRA_WAS_LAUNCHED_FROM_HOME
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.SAVED_STATUS
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_reading.*
import javax.inject.Inject
import android.content.ActivityNotFoundException
import android.net.Uri
import es.dmoral.toasty.Toasty
import java.lang.StringBuilder

class ReadingActivity : BaseActivity() {

    @Inject
    lateinit var gson: Gson

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var dummyTagsAdapter: DummyTagListAdapter

    private lateinit var readElement: ReadElement
    private lateinit var viewModel: ReadingActivityViewModel

    private var isSaved: Boolean = false
    private var wasLaunchedFromHome = false

    private var categoryColor: Int = 0

    companion object {

        fun newIntent(context: Context, readElement: ReadElement, wasLaunchedFromHome: Boolean = false): Intent {
            val intent = Intent(context, ReadingActivity::class.java)
            intent.putExtra(EXTRA_READ_ELEMENT, readElement)
            intent.putExtra(EXTRA_WAS_LAUNCHED_FROM_HOME, wasLaunchedFromHome)
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
        setObservers()
        setTagsRecycler()
        renderInitial()
        setClickListeners()
    }

    private fun setComponent() {
        DaggerReadActivityComponent.builder()
                .constitutionAppComponent(ConstitutionApp.get(this).constitutionAppComponent())
                .build().injectReadingActivity(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ReadingActivityViewModel::class.java)
    }

    private fun getIntentData() {
        readElement = intent.getParcelableExtra(EXTRA_READ_ELEMENT)
        wasLaunchedFromHome = intent.getBooleanExtra(EXTRA_WAS_LAUNCHED_FROM_HOME, false)
    }

    private fun renderInitial() {
        findCategoryColor()

        bottomSaveStatusView.background = ContextCompat.getDrawable(this, categoryColor)

        renderReadElement()
    }

    private fun setObservers() {
        viewModel.isElementSaved(readElement.id).observe(this, Observer {
            it?.let {
                this.isSaved = it == SAVED_STATUS
                renderSaveStatus(isSaved)
            }
        })
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
            if(isSaved) unsaveElementFromDb()
            else saveElementToDb()
        }

        bottomRateView.setOnClickListener {
            rateApp()
        }

        bottomWhatsAppView.setOnClickListener {
            shareContentOnWhatsApp()
        }

        bottomShareView.setOnClickListener {
            shareContent()
        }
    }

    private fun shareContentOnWhatsApp() {
        Toasty.normal(this, getSharingToastMessage()).show()

        val whatsappIntent = Intent(Intent.ACTION_SEND)
        whatsappIntent.type = getString(R.string.plain_text_share_type)
        whatsappIntent.setPackage(getString(R.string.whatsapp_package))
        whatsappIntent.putExtra(Intent.EXTRA_TEXT, getShareString())
        try {
            startActivity(whatsappIntent)
        } catch (e: ActivityNotFoundException) {
            shareContent()
        }
    }

    private fun rateApp() {
        Toasty.normal(this, getString(R.string.rate_app_play_store)).show()

        val packageString = "/details?id=$packageName"
        val uri = Uri.parse("market:/$packageString")
        val goToMarket = Intent(Intent.ACTION_VIEW, uri)

        goToMarket.addFlags(
                Intent.FLAG_ACTIVITY_NO_HISTORY or
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK
        )

        try {
            startActivity(goToMarket)
        } catch (e: ActivityNotFoundException) {
            startActivity(Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps$packageString")))
        }
    }

    private fun getAppLink(): String {
        return "http://play.google.com/store/apps/details?id=$packageName"
    }

    private fun saveElementToDb() {
        viewModel.markElementAsSaved(readElement.id)
        renderSaveStatus(true)
        showCategoryToast(getSavedString())
//        Toasty.info(this, getSavedString(), Toast.LENGTH_SHORT, true).show()
    }

    private fun unsaveElementFromDb() {
        viewModel.markElementAsUnsaved(readElement.id)
        renderSaveStatus(false)
        showCategoryToast(getRemovedString())
//        Toasty.info(this, getRemovedString(), Toast.LENGTH_SHORT, true).show()
    }

    private fun getSavedString(): String {
        return "${getSimpleString()} ${getString(R.string.was_saved)}"
    }

    private fun getRemovedString(): String {
        return "${getSimpleString()} ${getString(R.string.was_removed)}"
    }

    private fun getSimpleString(): String {
        val titleString: String = readElement.title!!
        val builder = StringBuilder()
        builder.append(titleString[0])
        for(i in 1 until titleString.length)
            builder.append(titleString[i].toLowerCase())
        return builder.toString()
    }

    @Suppress("DEPRECATION")
    private fun getShareString(): String {
        Toasty.normal(this, getSharingToastMessage()).show()

        val builder = StringBuilder("*${readElement.title!!}*\n\n")
        builder.append(getMessageAppLink()).append("\n\n")

        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.N)
            builder.append(Html.fromHtml(readElement.content))
        else
            builder.append(Html.fromHtml(readElement.content, Html.FROM_HTML_MODE_LEGACY))

        return builder.toString()
    }

    private fun getSharingToastMessage(): String {
        return "${getString(R.string.sharing)} ${getSimpleString()}"
    }

    private fun getMessageAppLink(): String {
        return "${getString(R.string.get_constitution_app)} ${getAppLink()}"
    }

    private fun shareContent() {
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = getString(R.string.plain_text_share_type)
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, getShareSubject())
        sharingIntent.putExtra(Intent.EXTRA_TEXT, getShareString())
        startActivity(Intent.createChooser(sharingIntent, getChooserHeading()))
    }

    private fun getShareSubject(): String {
        val builder = StringBuilder()
        builder.append(getString(R.string.i_am_sharing))
                .append(" ").append(getSimpleString())
                .append(" ").append(getString(R.string.with_you))
        return builder.toString()
    }

    private fun getChooserHeading(): String {
        return "${getString(R.string.share_small)} ${getSimpleString()}"
    }

    private fun renderSaveStatus(isSaved: Boolean) {
        if(isSaved) {
            saveStatusIv.setImageDrawable(getDrawableFromId(R.drawable.ic_bookmark_filled))
            saveStatusTv.text = getStringFromId(R.string.saved)
        }
        else {
            saveStatusIv.setImageDrawable(getDrawableFromId(R.drawable.ic_bookmark))
            saveStatusTv.text = getStringFromId(R.string.save)
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
        if(wasLaunchedFromHome)
            overridePendingTransition(R.anim.no_animation, R.anim.slide_out_right)
        else
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    private fun showCategoryToast(message: String) {
        Toasty.custom(
                this, message, R.drawable.ic_bookmark,
                categoryColor, Toasty.LENGTH_SHORT, false, true
        ).show();
    }
}
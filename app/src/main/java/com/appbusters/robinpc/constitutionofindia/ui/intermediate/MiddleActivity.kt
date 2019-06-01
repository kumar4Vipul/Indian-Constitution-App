package com.appbusters.robinpc.constitutionofindia.ui.intermediate

import android.content.Context
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
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
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var middleAdapter: MiddleListAdapter

    private lateinit var categoryName: String
    private lateinit var viewModel: MiddleActivityViewModel

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
        renderViewsForData()
        setObservers()
    }

    private fun setComponent() {
        DaggerMiddleActivityComponent.builder()
                .constitutionAppComponent(ConstitutionApp.get(this).constitutionAppComponent())
                .middleActivityModule(MiddleActivityModule(this))
                .build().injectMiddleActivity(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MiddleActivityViewModel::class.java)
    }

    private fun setObservers() {
        viewModel.getAllParts().observe(this, Observer {
            it?.let {
                middleAdapter.submitList(it)
            }
        })
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
        middleAdapter.setPartClickListener(this)
    }

    override fun onPartClicked(part: Part) {
        startActivity(CategoryListingActivity.newIntent(this, categoryName, part.title, part.startIndex, part.endIndex))
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.no_animation, R.anim.slide_out_right)
    }
}

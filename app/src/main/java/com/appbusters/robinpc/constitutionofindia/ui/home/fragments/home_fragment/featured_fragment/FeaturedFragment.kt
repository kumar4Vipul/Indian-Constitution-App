package com.appbusters.robinpc.constitutionofindia.ui.home.fragments.home_fragment.featured_fragment

import android.app.Activity
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.appbusters.robinpc.constitutionofindia.ConstitutionApp
import com.appbusters.robinpc.constitutionofindia.data.model.BookLink
import com.appbusters.robinpc.constitutionofindia.di.component.fragment.DaggerFeaturedFragmentComponent
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.EXTRA_INDEX
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseFragment
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.COUNT_DAYS
import kotlinx.android.synthetic.main.fragment_featured.*
import java.util.*
import javax.inject.Inject
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.Toast
import com.appbusters.robinpc.constitutionofindia.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import es.dmoral.toasty.Toasty
import java.lang.NumberFormatException


class FeaturedFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private  var pageIndex = -1
    private var dayNumber: Int = -1
    private var accentColor: Int = -1

    private lateinit var bookLink: BookLink
    private lateinit var calendar: Calendar
    private lateinit var viewModel: FeaturedFragmentViewModel

    companion object {
        fun newInstance(index: Int): FeaturedFragment {
            val fragment = FeaturedFragment()
            val bundle = Bundle()
            bundle.putInt(EXTRA_INDEX, index)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_featured
    }

    override fun setup() {
        calendar = Calendar.getInstance()

        setComponent()
        getArgumentValues()
        setObservers()
        setClickListeners()
    }

    private fun setComponent() {
        activity?.let {
            DaggerFeaturedFragmentComponent.builder()
                    .constitutionAppComponent(ConstitutionApp.get(it).constitutionAppComponent())
                    .build().injectFeaturedFragment(this)
        }

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(FeaturedFragmentViewModel::class.java)
    }

    private fun getArgumentValues() {
        dayNumber = calendar.get(Calendar.DAY_OF_YEAR)
        pageIndex = arguments!!.getInt(EXTRA_INDEX)
    }

    private fun setObservers() {
        viewModel.getBookById(getDayIdForPage()).observe(this, androidx.lifecycle.Observer {
            it?.let {
                this.bookLink = it
                renderViews()
            }
        })
    }

    private fun getDayIdForPage(): Int {
        return dayNumber  + (pageIndex - COUNT_DAYS + 1)
    }

    private fun renderViews() {
        fillAccentColor()

        bookTitleTv.text = bookLink.bookTitle
        bookAuthorTv.text = bookLink.authorName
        bookShortDescriptionTv.text = bookLink.shortDescription

        viewBookCard.setCardBackgroundColor(accentColor)
        bookAuthorTv.setTextColor(accentColor)

        loadCover()
        setBackground()
    }

    private fun fillAccentColor() {
        try {
            accentColor = Color.parseColor(bookLink.accentColor)
        } catch (e: NumberFormatException) {
            context?.let {
                accentColor = ContextCompat.getColor(it, R.color.black)
            } ?: run {
                Color.parseColor(
                        getString(R.string.color_black)
                )
            }
        }
    }

    private fun setBackground() {
        mainBackgroundView.background = getMainDrawable()
    }

    private fun getMainDrawable(): Drawable {
        val background: GradientDrawable = GradientDrawable()
        background.shape = GradientDrawable.RECTANGLE
        background.cornerRadius = 10f
        background.setStroke(10, accentColor)
        return background
    }

    private fun loadCover() {
        Glide.with(this)
                .load(bookLink.coverUrl)
                .centerCrop()
                .into(coverIv)
    }

    private fun setClickListeners() {
        fullPage.setOnClickListener {
            openAffiliateLink()
        }
    }

    private fun openAffiliateLink() {
        context?.let {
            Toasty.normal(it, getString(R.string.opening_book_link), Toast.LENGTH_SHORT).show()

            val affiliateUrl = bookLink.affiliateLink
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(affiliateUrl)
            it.startActivity(intent)
            (it as Activity).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }
}

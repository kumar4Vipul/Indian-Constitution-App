package com.appbusters.robinpc.constitutionofindia.ui.home.home_fragment.featured_fragment

import android.app.Activity
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.appbusters.robinpc.constitutionofindia.R
import com.appbusters.robinpc.constitutionofindia.utils.Constants
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.EXTRA_INDEX
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.FEATURED_PREAMBLE_INDEX
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.FEATURED_SAVED_BY_YOU_INDEX
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.FEATURED_YOUR_PROGRESS_INDEX
import com.appbusters.robinpc.constitutionofindia.ui.base.BaseFragment
import com.appbusters.robinpc.constitutionofindia.ui.reading.ReadingActivity
import com.appbusters.robinpc.constitutionofindia.utils.Constants.Companion.PREAMBLE_ID
import kotlinx.android.synthetic.main.fragment_featured.*

class FeaturedFragment : BaseFragment() {

    private  var pageIndex = -1

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
        getArgumentValues()
        renderViews()
        setClickListeners()
    }

    private fun getArgumentValues() {
        pageIndex = arguments!!.getInt(EXTRA_INDEX)
    }

    private fun renderViews() {
        when(pageIndex) {
            FEATURED_PREAMBLE_INDEX -> {
                featureTitleTv.text = getString(R.string.preamble_featured)
                backgroundView.background = getDrawable(R.color.preamble_start, R.color.preamble_end)
            }
            FEATURED_YOUR_PROGRESS_INDEX -> {
                featureTitleTv.text = getString(R.string.your_progress_featured)
                backgroundView.background = getDrawable(R.color.your_progress_start, R.color.your_progress_end)
            }
            FEATURED_SAVED_BY_YOU_INDEX -> {
                featureTitleTv.text = getString(R.string.saved_by_you_featured)
                backgroundView.background = getDrawable(R.color.saved_by_you_start, R.color.saved_by_you_end)
            }
        }
    }

    private fun getDrawable(resStartColor: Int, resEndColor: Int): GradientDrawable {
        return GradientDrawable(GradientDrawable.Orientation.TL_BR, intArrayOf(
                getColorFromRes(resStartColor),
                getColorFromRes(resEndColor)
        ))
    }

    private fun getColorFromRes(res: Int): Int {
        context?.let {
            return ContextCompat.getColor(it, res)
        }
        return res
    }

    private fun setClickListeners() {
        fullPage.setOnClickListener {
            when(pageIndex) {
                FEATURED_PREAMBLE_INDEX -> {
                    context?.let {
                        startActivity(ReadingActivity.newIntent(it, PREAMBLE_ID))
                        (it as Activity).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    }
                }
            }
        }
    }
}

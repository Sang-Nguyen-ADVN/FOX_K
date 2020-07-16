package com.ihaha.sunny.ui.view.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.onboarding_view.view.*
import com.ihaha.sunny.ui.R
import com.ihaha.sunny.ui.extensions.hide
import com.ihaha.sunny.ui.extensions.show
import com.ihaha.sunny.ui.view.adapter.OnBoardingPagerAdapter
import com.ihaha.sunny.ui.view.anim.setParallaxTransformation
import com.ihaha.sunny.ui.view.domain.OnBoardingPrefManager
import com.ihaha.sunny.ui.view.entity.OnBoardingPage
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class OnBoardingView @JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0, defStyleRes: Int = 0) :
    FrameLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val numberOfPages by lazy { OnBoardingPage.values().size }
    private val prefManager: OnBoardingPrefManager
    private var onClickNavigationToMain: OnClickNavigationToMain? = null

    fun setOnclickNavigationToMain(onClickNavigationToMain: OnClickNavigationToMain?){
        this.onClickNavigationToMain = onClickNavigationToMain
    }

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.onboarding_view, this, true)
        setUpSlider(view)
        addingButtonsClickListeners()
        prefManager = OnBoardingPrefManager(view.context)
    }

    private fun setUpSlider(view: View) {
        with(slider) {
            adapter = OnBoardingPagerAdapter()
            setPageTransformer { page, position ->
                setParallaxTransformation(page, position)
            }

            addSlideChangeListener()

            val wormDotsIndicator = view.findViewById<WormDotsIndicator>(R.id.page_indicator)
            wormDotsIndicator.setViewPager2(this)
        }
    }


    private fun addSlideChangeListener() {

        slider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
//                if (numberOfPages > 1) {
//                    val newProgress = (position + positionOffset) / (numberOfPages - 1)
//                    onboardingRoot.progress = newProgress
//                    showView()
//                }
                if(position >= numberOfPages - 1){
                    hideView()
                }else{
                    showView()
                }
            }
        })
    }

    private fun showView(){
        view_bottom.show()
        nextBtn.show()
        skipBtn.show()
        page_indicator.show()
        startBtn.hide()
    }

    private fun hideView(){
        view_bottom.hide()
        nextBtn.hide()
        skipBtn.hide()
        page_indicator.hide()
        startBtn.show()
    }

    private fun addingButtonsClickListeners() {
        nextBtn.setOnClickListener { navigateToNextSlide() }
        skipBtn.setOnClickListener {
            setFirstTimeLaunchToFalse()
        }
        startBtn.setOnClickListener {
            setFirstTimeLaunchToFalse()
        }
    }

    private fun setFirstTimeLaunchToFalse() {
        prefManager.isFirstTimeLaunch = false
        navigateToMainACtivity()
    }

    private fun navigateToNextSlide() {
        val nextSlidePos: Int = slider?.currentItem?.plus(1) ?: 0
        slider?.setCurrentItem(nextSlidePos, true)
    }

    private fun navigateToMainACtivity() {
        onClickNavigationToMain?.onClickNavigation()
    }
}

interface OnClickNavigationToMain{
    fun onClickNavigation()
}
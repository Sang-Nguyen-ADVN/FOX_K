package com.ihaha.sunny.ui.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.onboarding_page_item.view.*
import com.ihaha.sunny.ui.R
import com.ihaha.sunny.ui.view.entity.OnBoardingPage

class OnBoardingPagerAdapter(private val onBoardingPageList:Array<OnBoardingPage> = OnBoardingPage.values())
    : RecyclerView.Adapter<PagerViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): PagerViewHolder {
        return LayoutInflater.from(parent.context).inflate(
            PagerViewHolder.LAYOUT, parent, false
        ).let { PagerViewHolder(it) }
    }

    override fun getItemCount() = onBoardingPageList.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(onBoardingPageList[position])
    }
}

class PagerViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
    fun bind(onBoardingPage: OnBoardingPage) {
       val res = root.context.resources
        root.titleTv?.text = res.getString(onBoardingPage.titleResource)
        root.subTitleTv?.text = res.getString(onBoardingPage.subTitleResource)
        root.descTV?.text = res.getString(onBoardingPage.descriptionResource)
        root.img.setImageResource(onBoardingPage.logoResource)
    }

    companion object {
        @LayoutRes
        val LAYOUT = R.layout.onboarding_page_item
    }
}
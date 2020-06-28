package com.ihaha.sunny.fox.home.trending

import androidx.fragment.app.activityViewModels
import com.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import com.ihaha.sunny.fox.home.R
import com.ihaha.sunny.fox.home.databinding.FragmentTrendingBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview


/**
 * Create by Sunny date: 25-04-2020
 * Version: 1.0.0
 */

@FlowPreview
@ExperimentalCoroutinesApi
class TrendingFragment : BaseBindingFragment<FragmentTrendingBinding, TrendingViewModel>() {

    //region override

    override val viewModel: TrendingViewModel by activityViewModels()

    override val layoutId: Int = R.layout.fragment_trending

    //endregion

    companion object{
        fun newInstances() = TrendingFragment()
    }



}
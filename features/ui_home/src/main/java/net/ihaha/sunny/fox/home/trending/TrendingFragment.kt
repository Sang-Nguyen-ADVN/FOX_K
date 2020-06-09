package net.ihaha.sunny.fox.home.trending

import androidx.fragment.app.activityViewModels
import net.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import net.ihaha.sunny.fox.home.R
import net.ihaha.sunny.fox.home.databinding.FragmentTrendingBinding


/**
 * Create by Sunny date: 25-04-2020
 * Version: 1.0.0
 */

class TrendingFragment : BaseBindingFragment<FragmentTrendingBinding, TrendingViewModel>() {

    //region override

    override val viewModel: TrendingViewModel by activityViewModels()

    override val layoutId: Int = R.layout.fragment_trending

    //endregion

    companion object{
        fun newInstances() = TrendingFragment()
    }



}
package com.ihaha.sunny.fox.home.series

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import com.ihaha.sunny.fox.home.R
import com.ihaha.sunny.fox.home.databinding.FragmentSeriesBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview


/**
 * Create by Sunny date: 25-04-2020
 * Version: 1.0.0
 */

@FlowPreview
@ExperimentalCoroutinesApi
class SeriesFragment : BaseBindingFragment<FragmentSeriesBinding, SeriesViewModel>() {

    //region override

    override val viewModel: SeriesViewModel by activityViewModels()

    override val layoutId: Int = R.layout.fragment_series

    //endregion

    companion object{
        fun newInstances() = SeriesFragment()
    }
}
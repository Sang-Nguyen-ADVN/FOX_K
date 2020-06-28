package com.ihaha.sunny.fox.home.newest

import androidx.fragment.app.activityViewModels
import com.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import com.ihaha.sunny.fox.home.R
import com.ihaha.sunny.fox.home.databinding.FragmentNewestBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview


/**
 * Create by Sunny date: 25-04-2020
 * Version: 1.0.0
 */

@FlowPreview
@ExperimentalCoroutinesApi
class NewestFragment : BaseBindingFragment<FragmentNewestBinding, NewestViewModel>() {

    //region override

    override val viewModel: NewestViewModel by activityViewModels()

    override val layoutId: Int = R.layout.fragment_newest

    //endregion

    companion object{
        fun newInstances() = NewestFragment()
    }


}
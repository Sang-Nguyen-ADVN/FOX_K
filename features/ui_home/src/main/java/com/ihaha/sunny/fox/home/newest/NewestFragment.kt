package com.ihaha.sunny.fox.home.newest

import androidx.fragment.app.activityViewModels
import com.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import com.ihaha.sunny.fox.home.R
import com.ihaha.sunny.fox.home.databinding.FragmentNewestBinding


/**
 * Create by Sunny date: 25-04-2020
 * Version: 1.0.0
 */

class NewestFragment : BaseBindingFragment<FragmentNewestBinding, NewestViewModel>() {

    //region override

    override val viewModel: NewestViewModel by activityViewModels()

    override val layoutId: Int = R.layout.fragment_newest

    //endregion

    companion object{
        fun newInstances() = NewestFragment()
    }


}
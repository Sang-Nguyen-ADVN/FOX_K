package com.ihaha.sunny.fox.home.editors_choice

import androidx.fragment.app.activityViewModels
import com.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import com.ihaha.sunny.fox.home.R
import com.ihaha.sunny.fox.home.databinding.FragmentEditorsChoiceBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

/**
 * Create by Sunny date: 25-04-2020
 * Version: 1.0.0
 */

@FlowPreview
@ExperimentalCoroutinesApi
class EditorsChoiceFragment : BaseBindingFragment<FragmentEditorsChoiceBinding, EditorsChoiceViewModel>() {

    //region override

    override val viewModel: EditorsChoiceViewModel by activityViewModels()

    override val layoutId: Int = R.layout.fragment_editors_choice

    //endregion

    companion object{
        fun newInstances() = EditorsChoiceFragment()
    }


}
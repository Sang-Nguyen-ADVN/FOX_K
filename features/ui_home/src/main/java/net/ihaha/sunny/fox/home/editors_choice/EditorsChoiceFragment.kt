package net.ihaha.sunny.fox.home.editors_choice

import androidx.fragment.app.activityViewModels
import net.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import net.ihaha.sunny.fox.home.R
import net.ihaha.sunny.fox.home.databinding.FragmentEditorsChoiceBinding

/**
 * Create by Sunny date: 25-04-2020
 * Version: 1.0.0
 */

class EditorsChoiceFragment : BaseBindingFragment<FragmentEditorsChoiceBinding, EditorsChoiceViewModel>() {

    //region override

    override val viewModel: EditorsChoiceViewModel by activityViewModels()

    override val layoutId: Int = R.layout.fragment_editors_choice

    //endregion

    companion object{
        fun newInstances() = EditorsChoiceFragment()
    }


}
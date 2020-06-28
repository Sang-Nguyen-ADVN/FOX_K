package com.ihaha.sunny.fox.organizations

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import com.ihaha.sunny.fox.organizations.databinding.FragmentOriganizationsBinding
import com.ihaha.sunny.fox.organizations.di.injectFeature
import com.ihaha.sunny.fox.organizations.di.removeFeature
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview


/**
 * Create by Sunny date: 25-04-2020
 * Version: 1.0.0
 */

@FlowPreview
@ExperimentalCoroutinesApi
class OriganizationsFragment : BaseBindingFragment<FragmentOriganizationsBinding, OriganizationsViewModel>() {

    //region override

    override val viewModel: OriganizationsViewModel by activityViewModels()

    override val layoutId: Int = R.layout.fragment_origanizations

    //endregion

    companion object{
        fun newInstances() = OriganizationsFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFeature()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        initComponents()
//        initEventListener()
    }

    override fun onDestroy() {
        super.onDestroy()
        removeFeature()
    }
}
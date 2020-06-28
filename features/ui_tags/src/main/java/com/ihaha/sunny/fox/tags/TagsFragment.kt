package com.ihaha.sunny.fox.tags

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import com.ihaha.sunny.fox.tags.databinding.FragmentTagsBinding
import com.ihaha.sunny.fox.tags.di.injectFeature
import com.ihaha.sunny.fox.tags.di.removeFeature
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview


/**
 * Create by Sunny date: 25-04-2020
 * Version: 1.0.0
 */

@FlowPreview
@ExperimentalCoroutinesApi
class TagsFragment : BaseBindingFragment<FragmentTagsBinding, TagsViewModel>() {

    //region override

    override val viewModel: TagsViewModel by activityViewModels()

    override val layoutId: Int = R.layout.fragment_tags

    //endregion

    companion object{
        fun newInstances() = TagsFragment()
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
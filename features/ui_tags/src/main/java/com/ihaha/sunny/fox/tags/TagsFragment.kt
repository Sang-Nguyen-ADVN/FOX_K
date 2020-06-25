package com.ihaha.sunny.fox.tags

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import com.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import com.ihaha.sunny.fox.tags.databinding.FragmentTagsBinding
import com.ihaha.sunny.fox.tags.di.injectFeature
import com.ihaha.sunny.fox.tags.di.removeFeature


/**
 * Create by Sunny date: 25-04-2020
 * Version: 1.0.0
 */

class TagsFragment : BaseBindingFragment<FragmentTagsBinding, TagsViewModel>() {

    //region override

    override val viewModel: TagsViewModel by activityViewModels()

    override val layoutId: Int = R.layout.fragment_tags

    //endregion

    companion object{
        fun newInstances() = TagsFragment()
    }

    override fun initOnCreate(savedInstanceState: Bundle?) {
        super.initOnCreate(savedInstanceState)
        injectFeature()
    }

    override fun onDestroy() {
        super.onDestroy()
        removeFeature()
    }
}
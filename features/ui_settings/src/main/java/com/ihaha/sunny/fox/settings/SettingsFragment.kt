package com.ihaha.sunny.fox.settings

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import com.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import com.ihaha.sunny.fox.settings.databinding.FragmentSettingsBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * Create by Sunny date: 25-04-2020
 * Version: 1.0.0
 */

@FlowPreview
@ExperimentalCoroutinesApi
class SettingsFragment : BaseBindingFragment<FragmentSettingsBinding, SettingsViewModel>() {

    //region override

    override val viewModel: SettingsViewModel by activityViewModels()

    override val layoutId: Int = R.layout.fragment_settings

    //endregion

    companion object{
        fun newInstances() = SettingsFragment()
    }

}
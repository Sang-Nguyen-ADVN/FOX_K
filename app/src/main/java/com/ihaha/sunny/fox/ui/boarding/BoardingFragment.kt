package com.ihaha.sunny.fox.ui.boarding

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.launch
import com.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import com.ihaha.sunny.fox.Constants
import com.ihaha.sunny.fox.R
import com.ihaha.sunny.fox.databinding.FragmentBoardingBinding
import com.ihaha.sunny.fox.ui.callback.OnListenerNavigationToMainActivity
import com.ihaha.sunny.ui.view.ui.OnClickNavigationToMain
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.viewmodel.ext.android.viewModel

@FlowPreview
@ExperimentalCoroutinesApi
class BoardingFragment : BaseBindingFragment<FragmentBoardingBinding, BoardingViewModel>() {

    //region variable

    private var onClickNavigationToMain: OnClickNavigationToMain? = null
    private var onListenerNavigationToMainActivity: OnListenerNavigationToMainActivity? = null

    //endregion

    //region constructor

    companion object {
        fun newInstances() = BoardingFragment()
    }

    //endregion

    //region override
    override val viewModel: BoardingViewModel by viewModel()

    override val layoutId: Int = R.layout.fragment_boarding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        when (context) {
            is OnListenerNavigationToMainActivity -> onListenerNavigationToMainActivity = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponents()
        initEventListener()
    }

    private fun initComponents() {

    }

    private fun initEventListener() {
        onClickNavigationToMain = object :
            OnClickNavigationToMain {
            override fun onClickNavigation() {
                viewModel.saveKeyOnBoarding()
                onListenerNavigationToMainActivity?.onNavigation(Constants.ACTIVITY_LOGIN)
            }
        }
        viewBinding.onBroadingView.setOnclickNavigationToMain(onClickNavigationToMain)
    }


    //endregion
}
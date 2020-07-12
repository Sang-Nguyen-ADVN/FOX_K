package com.ihaha.sunny.fox.ui.splash

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import com.ihaha.sunny.fox.Constants
import com.ihaha.sunny.fox.R
import com.ihaha.sunny.fox.databinding.FragmentSplashBinding
import com.ihaha.sunny.fox.ui.callback.OnListenerNavigationToMainActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.viewmodel.ext.android.viewModel

@FlowPreview
@ExperimentalCoroutinesApi
class SplashFragment : BaseBindingFragment<FragmentSplashBinding, SplashViewModel>() {

    //region variable

    private var onListenerNavigationToMainActivity: OnListenerNavigationToMainActivity? = null

    private var isAuth : Boolean = false

    //endregion

    //region constructor

    companion object {
        fun newInstances() = SplashFragment()
    }

    //endregion

    //region override

    override val viewModel: SplashViewModel by viewModel()

    override val layoutId: Int = R.layout.fragment_splash

    override fun onAttach(context: Context) {
        super.onAttach(context)
        when (context) {
            is OnListenerNavigationToMainActivity -> onListenerNavigationToMainActivity = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        getData()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSubscribeRegister()
        initComponents()
        initEventListener()
    }

    override fun onResume() {
        super.onResume()
        viewBinding.mlContainer.transitionToEnd()
    }

    private fun getData(){
        isAuth = arguments?.getBoolean("isAuth") ?: false
    }

    private fun initComponents() {

    }

    private fun initEventListener() {
        if (viewModel.isCurrentBoarding()) {
            if(isAuth) {
                onListenerNavigationToMainActivity?.onNavigation(Constants.ACTIVITY_MAIN)
            }else{
                onListenerNavigationToMainActivity?.onNavigation(Constants.ACTIVITY_LOGIN)
            }
        } else {
            launch {
                delay(2000)
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToBoardingFragment())
            }
        }
    }

    private fun initSubscribeRegister() {

    }


    //endregion
}
package com.ihaha.sunny.fox.ui.splash

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import com.ihaha.sunny.fox.R
import com.ihaha.sunny.fox.databinding.FragmentSplashBinding
import com.ihaha.sunny.fox.ui.callback.OnListenerNavigationToMainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSubscribeRegister()
        initComponents()
        initEventListener()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        isAuth = arguments?.getBoolean("isAuth")!!
    }

    private fun initComponents() {

    }

    private fun initEventListener() {
        if (viewModel.isCurrentBoarding()) {
            if(isAuth) {
                onListenerNavigationToMainActivity?.onNavigation()
            }else{
                findNavController().navigate(R.id.action_splashFragment_to_SignInFragment)
            }
        } else {
            launch {
                delay(2000)
                findNavController().navigate(R.id.action_splashFragment_to_boardingFragment)
            }

        }
    }

    private fun initSubscribeRegister() {

    }


    //endregion
}
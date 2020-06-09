package net.ihaha.sunny.fox.ui.splash

import android.os.Bundle
import android.os.Handler
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import net.ihaha.sunny.fox.R
import net.ihaha.sunny.fox.databinding.FragmentSplashBinding
import net.ihaha.sunny.fox.ui.callback.OnListenerNavigationToMainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : BaseBindingFragment<FragmentSplashBinding, SplashViewModel>() {

    //region variable

    private var onListenerNavigationToMainActivity: OnListenerNavigationToMainActivity? = null

    //endregion

    //region constructor

    companion object {
        fun newInstances() = SplashFragment()
    }

    //endregion

    //region override

    override val viewModel: SplashViewModel by viewModel()

    override val layoutId: Int = R.layout.fragment_splash

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        when(context){
//            is OnListenerNavigationToMainActivity -> onListenerNavigationToMainActivity = context
//        }
//    }

    override fun initOnViewCreate(savedInstanceState: Bundle?) {
        super.initOnViewCreate(savedInstanceState)
        initComponents()
        initEventListener()
    }

    private fun initComponents() {

    }

    private fun initEventListener() {
        if (viewModel.isCheckOnBoarding()) {
//            onListenerNavigationToMainActivity?.onNavigation()
            launch {
                delay(2000)
                findNavController().navigate(R.id.action_splashFragment_to_signInFragment)
            }
        } else {
            launch {
                delay(2000)
                findNavController().navigate(R.id.action_splashFragment_to_boardingFragment)
            }

        }
    }


    //endregion
}
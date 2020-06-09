package net.ihaha.sunny.fox.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import net.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import net.ihaha.sunny.fox.login.databinding.FragmentSignInBinding
import net.ihaha.sunny.fox.login.di.injectFeature
import net.ihaha.sunny.fox.login.di.removeFeature
import net.ihaha.sunny.fox.ui.callback.OnListenerNavigationToMainActivity
import net.ihaha.sunny.fox.ui.main.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInFragment : BaseBindingFragment<FragmentSignInBinding, SignInViewModel>(){

    //region variable

    private var onListenerNavigationToMainActivity: OnListenerNavigationToMainActivity? = null

    //endregion

    //region override

    override val viewModel: SignInViewModel by viewModel()

    override val layoutId: Int = R.layout.fragment_sign_in

    override fun onAttach(context: Context) {
        super.onAttach(context)
        when(context){
            is OnListenerNavigationToMainActivity -> onListenerNavigationToMainActivity = context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectFeature()
    }

    override fun initLayout() {
        super.initLayout()
        initComponents()
        initEventListeners()
    }


    override fun onDestroy() {
        super.onDestroy()
        removeFeature()
    }

    //endregion

    //region method
    private fun initComponents(){

    }

    private fun initEventListeners(){
        viewBinding.btnSignIn.setOnClickListener {
            onListenerNavigationToMainActivity?.onNavigation()
        }
        viewBinding.tvForgetPassword.setOnClickListener {
            it.findNavController().navigate(R.id.action_signInFragment_to_resetPasswordFragment)
        }
        viewBinding.tvSignUp.setOnClickListener {
            it.findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }
    }
    //endregion
}
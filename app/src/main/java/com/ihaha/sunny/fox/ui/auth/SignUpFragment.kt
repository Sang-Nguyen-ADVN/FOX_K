package com.ihaha.sunny.fox.ui.auth

import android.content.Context
import android.os.Bundle
import androidx.navigation.findNavController
import com.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import com.ihaha.sunny.fox.R
import com.ihaha.sunny.fox.databinding.FragmentSignUpBinding
import com.ihaha.sunny.fox.ui.callback.OnListenerNavigationToMainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpFragment : BaseBindingFragment<FragmentSignUpBinding, SignUpViewModel>(){

    //region variable

    private var onListenerNavigationToMainActivity: OnListenerNavigationToMainActivity? = null

    //endregion

    //region override

    override val viewModel: SignUpViewModel by viewModel()

    override val layoutId: Int = R.layout.fragment_sign_up

    override fun onAttach(context: Context) {
        super.onAttach(context)
        when(context){
            is OnListenerNavigationToMainActivity -> onListenerNavigationToMainActivity = context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initLayout() {
        super.initLayout()
        initComponents()
        initEventListeners()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    //endregion

    //region method
    private fun initComponents(){

    }

    private fun initEventListeners(){
        viewBinding.btnSignUp.setOnClickListener {
            onListenerNavigationToMainActivity?.onNavigation()
        }
        viewBinding.tvSignIn.setOnClickListener {
            it.findNavController().navigate(R.id.action_signUpFragment_to_signInFragment)
        }
    }
    //endregion
}
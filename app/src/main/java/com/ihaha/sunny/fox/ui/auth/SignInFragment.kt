package com.ihaha.sunny.fox.ui.auth

import android.content.Context
import android.os.Bundle
import androidx.navigation.findNavController
import com.rasalexman.coroutinesmanager.launchOnUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import com.ihaha.sunny.fox.R
import com.ihaha.sunny.fox.databinding.FragmentSignInBinding
import com.ihaha.sunny.fox.ui.callback.OnListenerNavigationToMainActivity
import com.ihaha.sunny.ui.extensions.setOnSingleClickListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInFragment : BaseBindingFragment<FragmentSignInBinding, SignInViewModel>() {

    //region variable

    private var onListenerNavigationToMainActivity: OnListenerNavigationToMainActivity? = null

    //endregion

    //region override

    override val viewModel: SignInViewModel by viewModel()

    override val layoutId: Int = R.layout.fragment_sign_in

    override fun onAttach(context: Context) {
        super.onAttach(context)
        when (context) {
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
    private fun initComponents() {

    }

    private fun initEventListeners() {
        viewBinding.btnSignIn.setOnClickListener {
            launch(Dispatchers.IO) {
                val email = viewBinding.edtUserName.text.toString()
                val password = viewBinding.edtUserPassword.text.toString()
                viewModel.signInWithEmailAndPassword(email = email, password = password)
                launchOnUI {
                    onListenerNavigationToMainActivity?.onNavigation()
                }
            }

        }
        viewBinding.tvForgetPassword.setOnSingleClickListener() {
            it.findNavController().navigate(R.id.action_signInFragment_to_resetPasswordFragment)
        }
        viewBinding.tvSignUp.setOnClickListener {
            it.findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }
    }
    //endregion
}
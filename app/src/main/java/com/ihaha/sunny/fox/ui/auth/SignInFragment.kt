package com.ihaha.sunny.fox.ui.auth

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.github.razir.progressbutton.attachTextChangeAnimator
import com.github.razir.progressbutton.bindProgressButton
import com.github.razir.progressbutton.hideProgress
import com.github.razir.progressbutton.showProgress
import com.ihaha.sunny.base.exception.invalidEmail
import com.ihaha.sunny.base.exception.invalidNormalPassword
import com.ihaha.sunny.base.exception.invalidPhoneNumber
import com.ihaha.sunny.base.exception.invalidString
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import com.ihaha.sunny.fox.Constants
import com.ihaha.sunny.fox.R
import com.ihaha.sunny.fox.databinding.FragmentSignInBinding
import com.ihaha.sunny.fox.domain.model.auth.User
import com.ihaha.sunny.fox.ui.callback.OnListenerNavigationToMainActivity
import com.ihaha.sunny.ui.extensions.setOnSingleClickListener
import com.ihaha.sunny.ui.extensions.string
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.viewmodel.ext.android.viewModel

@FlowPreview
@ExperimentalCoroutinesApi
class SignInFragment : BaseBindingFragment<FragmentSignInBinding, SignInViewModel>() {

    //region variable

    private var onListenerNavigationToMainActivity: OnListenerNavigationToMainActivity? = null
    private var currentUser: User? = null

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponents()
        initEventListeners()
    }

    //endregion

    //region method
    private fun initComponents() {
        bindProgressButton(viewBinding.btnSignIn)
        bindProgressButton(viewBinding.btnFacebook)
        bindProgressButton(viewBinding.btnGoogle)
        viewBinding.btnSignIn.attachTextChangeAnimator()
        viewBinding.btnFacebook.attachTextChangeAnimator()
        viewBinding.btnGoogle.attachTextChangeAnimator()

        viewBinding.mlContainer.transitionToEnd()
    }

    private fun initEventListeners() {
        viewBinding.btnSignIn.setOnClickListener {
            launch {
                val email = viewBinding.edtUserName.text.toString()
                val password = viewBinding.edtUserPassword.text.toString()
                if (invalidData(email, password)) {
                    viewModel.signInWithEmailAndPassword(email = email, password = password)
                        .observe(viewLifecycleOwner, Observer {
                            it.addOnCompleteListener { result ->
                                when {
                                    result.isSuccessful -> {
                                        if (result.result != null) {
                                            onListenerNavigationToMainActivity?.onNavigation(
                                                Constants.ACTIVITY_MAIN
                                            )
                                        }
                                    }
                                    else -> {
                                        viewBinding.tvError.text = result.exception?.message
                                    }
                                }
                            }
                        })
                }
            }
        }

        viewBinding.tvForgetPassword.setOnSingleClickListener() {
            val action = SignInFragmentDirections.actionSignInFragmentToResetPasswordFragment()
            it.findNavController().navigate(action)
        }
        viewBinding.tvSignUp.setOnClickListener {
            val action = SignInFragmentDirections.actionSignInFragmentToSignUpFragment()
            it.findNavController().navigate(action)
        }
    }

    private fun invalidData(
        email: String?,
        password: String?
    ): Boolean {
        when {
            !email.invalidEmail() -> {
                viewBinding.tvError.text = string(R.string.error_user_email_empty)
                return false
            }
            !password.invalidNormalPassword() -> {
                viewBinding.tvError.text = string(R.string.error_user_password_empty)
                return false
            }
            else -> {
                return true
            }
        }
    }
    //endregion
}
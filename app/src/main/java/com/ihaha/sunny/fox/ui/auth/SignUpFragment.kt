package com.ihaha.sunny.fox.ui.auth

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.ihaha.sunny.base.exception.invalidEmail
import com.ihaha.sunny.base.exception.invalidNormalPassword
import com.ihaha.sunny.base.exception.invalidString
import com.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import com.ihaha.sunny.fox.Constants
import com.ihaha.sunny.fox.R
import com.ihaha.sunny.fox.databinding.FragmentSignUpBinding
import com.ihaha.sunny.fox.domain.model.auth.User
import com.ihaha.sunny.fox.ui.callback.OnListenerNavigationToMainActivity
import com.ihaha.sunny.ui.extensions.string
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

@FlowPreview
@ExperimentalCoroutinesApi
class SignUpFragment : BaseBindingFragment<FragmentSignUpBinding, SignUpViewModel>() {

    //region variable

    private var onListenerNavigationToMainActivity: OnListenerNavigationToMainActivity? = null
    private var currentUser: User? = null

    //endregion

    //region override

    override val viewModel: SignUpViewModel by viewModel()

    override val layoutId: Int = R.layout.fragment_sign_up

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

    override fun onDestroy() {
        super.onDestroy()
    }

    //endregion

    //region method
    private fun initComponents() {

    }

    private fun initEventListeners() {
        viewBinding.btnSignUp.setOnClickListener {
            launch {
                val email = viewBinding.edtUserName.text.toString()
                val password = viewBinding.edtUserPassword.text.toString()
                val rePassword = viewBinding.edtRePassword.text.toString()
                val userName = viewBinding.edtUserName.text.toString()
                when {
                    !userName.invalidString() -> {
                        viewBinding.tvError.text = string(R.string.error_user_name_empty)
                    }
                    !email.invalidEmail() -> {
                        viewBinding.tvError.text = string(R.string.error_user_email_empty)
                    }
                    !password.invalidNormalPassword() -> {
                        viewBinding.tvError.text = string(R.string.error_user_password_empty)
                    }
                    !rePassword.invalidNormalPassword() -> {
                        viewBinding.tvError.text = string(R.string.error_user_re_password_empty)
                    }
                    password != rePassword -> {
                        viewBinding.tvError.text = string(R.string.error_user_repeated_password_incorrect)
                    }
                    else -> {
                        viewModel.signUpWithEmailAndPassword(email = email, password = password)
                            .observe(viewLifecycleOwner, Observer {
                                it.addOnCompleteListener { result ->
                                    when {
                                        result.isSuccessful -> {
                                            if (result.result != null) {
                                                val userResult = result.result?.user
                                                currentUser = User(
                                                    uid = userResult?.uid,
                                                    username = userResult?.displayName,
                                                    email = userResult?.email,
                                                    phone = userResult?.phoneNumber,
                                                    pictureUrl = userResult?.photoUrl.toString()
                                                )
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
        }
        viewBinding.tvSignIn.setOnClickListener {
            it.findNavController()
                .navigate(SignUpFragmentDirections.actionSignUpFragmentToSignInFragment())
        }
        //endregion
    }
}
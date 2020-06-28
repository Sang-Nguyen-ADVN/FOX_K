package com.ihaha.sunny.fox.ui.auth

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.ihaha.sunny.base.exception.invalidEmail
import com.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import com.ihaha.sunny.fox.R
import com.ihaha.sunny.fox.databinding.FragmentResetPasswordBinding
import com.ihaha.sunny.ui.extensions.string
import com.ihaha.sunny.ui.extensions.successResult
import com.ihaha.sunny.ui.extensions.toSuccessResult
import kotlinx.android.synthetic.main.fragment_sign_in.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

@FlowPreview
@ExperimentalCoroutinesApi
class ResetPasswordFragment :
    BaseBindingFragment<FragmentResetPasswordBinding, ResetPasswordViewModel>() {

    //region variable

    //endregion

    //region override

    override val viewModel: ResetPasswordViewModel by viewModel()

    override val layoutId: Int = R.layout.fragment_reset_password

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        viewBinding.btnResetPassword.setOnClickListener { view ->
            launch {
                val email = viewBinding.edtEmail.text.toString()
                when {
                    !email.invalidEmail() -> {
                        viewBinding.tvError.text = string(R.string.error_user_email_empty)
                    }
                    else -> {
                        viewModel.sendEmailResetPassword(email = email)
                            .observe(viewLifecycleOwner, Observer { result ->
                                result.addOnSuccessListener{
                                    view.findNavController().navigate(ResetPasswordFragmentDirections.actionResetPasswordFragmentToSignInFragment())
                                }
                                result.addOnFailureListener {
                                    viewBinding.tvError.text = it.message
                                }
                            })
                    }
                }
            }
        }
    }
    //endregion
}
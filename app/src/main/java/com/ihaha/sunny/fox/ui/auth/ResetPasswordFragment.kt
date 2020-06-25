package com.ihaha.sunny.fox.ui.auth

import android.os.Bundle
import androidx.navigation.findNavController
import com.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import com.ihaha.sunny.fox.R
import com.ihaha.sunny.fox.databinding.FragmentResetPasswordBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResetPasswordFragment : BaseBindingFragment<FragmentResetPasswordBinding, ResetPasswordViewModel>(){

    //region variable

    //endregion

    //region override

    override val viewModel: ResetPasswordViewModel by viewModel()

    override val layoutId: Int = R.layout.fragment_reset_password

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
        viewBinding.btnResetPassword.setOnClickListener {
            it.findNavController().navigate(R.id.action_resetPasswordFragment_to_signInFragment)
        }
    }
    //endregion
}
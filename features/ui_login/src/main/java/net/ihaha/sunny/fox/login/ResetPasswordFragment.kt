package net.ihaha.sunny.fox.login

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import net.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import net.ihaha.sunny.fox.login.databinding.FragmentResetPasswordBinding
import net.ihaha.sunny.fox.login.di.injectFeature
import net.ihaha.sunny.fox.login.di.removeFeature
import net.ihaha.sunny.navigation.navigateSafe
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResetPasswordFragment : BaseBindingFragment<FragmentResetPasswordBinding, SignUpViewModel>(){

    //region variable

    //endregion

    //region override

    override val viewModel: SignUpViewModel by viewModel()

    override val layoutId: Int = R.layout.fragment_reset_password

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
        viewBinding.btnResetPassword.setOnClickListener {
//            it.findNavController().navigate(R.id.action_resetPasswordFragment_to_signInFragment)
        }
    }
    //endregion
}
package net.ihaha.sunny.fox.login

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import net.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import net.ihaha.sunny.fox.login.databinding.FragmentSignUpBinding
import net.ihaha.sunny.fox.login.di.injectFeature
import net.ihaha.sunny.fox.login.di.removeFeature
import net.ihaha.sunny.fox.ui.callback.OnListenerNavigationToMainActivity
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
        viewBinding.btnSignUp.setOnClickListener {
            onListenerNavigationToMainActivity?.onNavigation()
        }
        viewBinding.tvSignIn.setOnClickListener {
            it.findNavController().navigate(R.id.action_signUpFragment_to_signInFragment)
        }
    }
    //endregion
}
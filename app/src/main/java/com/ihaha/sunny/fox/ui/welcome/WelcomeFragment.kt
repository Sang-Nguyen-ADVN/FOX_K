package com.ihaha.sunny.fox.ui.welcome

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import com.ihaha.sunny.fox.R
import com.ihaha.sunny.fox.databinding.FragmentWelcomeBinding
import com.ihaha.sunny.fox.domain.model.auth.User
import com.ihaha.sunny.ui.extensions.hide
import com.ihaha.sunny.ui.extensions.show
import com.ihaha.sunny.ui.extensions.string
import org.koin.androidx.viewmodel.ext.android.viewModel

class WelcomeFragment : BaseBindingFragment<FragmentWelcomeBinding, WelcomeViewModel>() {

    //region variable

    private var currentUser: User? = null

    //endregion

    //region override

    override val viewModel: WelcomeViewModel by viewModel()

    override val layoutId: Int = R.layout.fragment_welcome


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSubscribeRegister()
        initComponents()
        initEventListener()
    }

    private fun initComponents() {

    }

    private fun initEventListener() {
        launch {
            delay(2000)
            if(currentUser != null){
                viewBinding.tvWelcome.text = String.format("Chào mừng %s đã trở lại", currentUser?.username)
                viewBinding.ivAvatar.show()
                viewBinding.tvName.hide(false)
                val bundle = bundleOf("isAuth" to true)
                findNavController().navigate(R.id.action_welcomeFragment_to_splashFragment, bundle)
            }
            else{
                viewBinding.tvWelcome.text = string(R.string.welcome_text_title)
                viewBinding.ivAvatar.hide()
                viewBinding.tvName.show()
                findNavController().navigate(R.id.action_welcomeFragment_to_splashFragment, null)
            }
        }
    }

    private fun initSubscribeRegister() {
        launch {
            viewModel.getCurrentUser().observe(viewLifecycleOwner, Observer {
                currentUser = User(
                    uid = it?.uid,
                    username = it?.displayName,
                    email = it?.email,
                    phone = it?.phoneNumber,
                    pictureUrl = it?.photoUrl.toString()
                )
            })
        }
    }

    //endregion
}
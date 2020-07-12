package com.ihaha.sunny.fox.ui.welcome

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import com.ihaha.sunny.fox.R
import com.ihaha.sunny.fox.databinding.FragmentWelcomeBinding
import com.ihaha.sunny.fox.domain.model.auth.User
import com.ihaha.sunny.ui.extensions.drawable
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

@FlowPreview
@ExperimentalCoroutinesApi
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
        viewBinding.mlContainer.transitionToEnd()
    }

    private fun initEventListener() {
        launch {
            delay(2000)
            if (currentUser != null) {
                viewBinding.ivAvatar.setImageURI(Uri.parse(currentUser?.pictureUrl))
                val bundle = bundleOf("isAuth" to true)
                findNavController().navigate(R.id.action_welcomeFragment_to_splashFragment, bundle)
            } else {
                viewBinding.ivAvatar.setImageDrawable(drawable(R.drawable.ic_account_circle_white_24))
                val bundle = bundleOf("isAuth" to false)
                findNavController().navigate(R.id.action_welcomeFragment_to_splashFragment, bundle)
            }

        }
    }

    private fun initSubscribeRegister() {
        launch {
            val user = viewModel.getCurrentUser()
            currentUser = User(
                uid = user?.uid,
                username = user?.displayName,
                email = user?.email,
                phone = user?.phoneNumber,
                pictureUrl = user?.photoUrl.toString()
            )
        }
    }
    //endregion
}




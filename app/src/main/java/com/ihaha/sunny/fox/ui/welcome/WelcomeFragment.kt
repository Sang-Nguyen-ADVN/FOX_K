package com.ihaha.sunny.fox.ui.welcome

import android.net.Uri
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
import com.ihaha.sunny.ui.extensions.drawable
import com.ihaha.sunny.ui.extensions.hide
import com.ihaha.sunny.ui.extensions.show
import com.ihaha.sunny.ui.extensions.string
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
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
            if(currentUser != null){
                viewBinding.ivAvatar.setImageURI(Uri.parse(currentUser?.pictureUrl))
                WelcomeFragmentArgs.fromBundle(bundleOf("isAuth" to true))
            }
            else{
                viewBinding.ivAvatar.setImageDrawable(drawable(R.drawable.ic_account_circle_white_24))
                WelcomeFragmentArgs.fromBundle(bundleOf("isAuth" to false))
            }
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToSplashFragment())
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


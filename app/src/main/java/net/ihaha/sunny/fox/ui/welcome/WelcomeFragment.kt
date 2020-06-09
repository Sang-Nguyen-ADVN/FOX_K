package net.ihaha.sunny.fox.ui.welcome

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.ihaha.sunny.base.presentation.fragment.BaseFragment
import net.ihaha.sunny.fox.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class WelcomeFragment : BaseFragment<WelcomeViewModel>() {

    //region override

    override val viewModel: WelcomeViewModel by viewModel()

    override val layoutId: Int = R.layout.fragment_welcome

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        launch {
            delay(2000)
            findNavController().navigate(R.id.action_welcomeFragment_to_splashFragment, null)
        }

    }

    //endregion
}
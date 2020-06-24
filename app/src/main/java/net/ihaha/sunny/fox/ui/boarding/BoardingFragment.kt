package net.ihaha.sunny.fox.ui.boarding

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.launch
import net.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import net.ihaha.sunny.fox.R
import net.ihaha.sunny.fox.databinding.FragmentBoardingBinding
import net.ihaha.sunny.fox.ui.callback.OnListenerNavigationToMainActivity
import net.ihaha.sunny.ui.view.ui.OnClickNavigationToMain
import org.koin.androidx.viewmodel.ext.android.viewModel

class BoardingFragment : BaseBindingFragment<FragmentBoardingBinding, BoardingViewModel>(){

    //region variable

    private var onClickNavigationToMain : OnClickNavigationToMain? = null
    private var onListenerNavigationToMainActivity: OnListenerNavigationToMainActivity? = null

    //endregion

    //region constructor

    companion object{
        fun newInstances() = BoardingFragment()
    }

    //endregion

    //region override

    override val viewModel: BoardingViewModel by viewModel()

    override val layoutId: Int = R.layout.fragment_boarding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        when(context){
            is OnListenerNavigationToMainActivity -> onListenerNavigationToMainActivity = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponents()
        initEventListener()
    }

    private fun initComponents() {

    }

    private fun initEventListener() {
        onClickNavigationToMain = object :
            OnClickNavigationToMain {
            override fun onClickNavigation() {
                viewModel.saveKeyOnBoarding()
                if(onListenerNavigationToMainActivity != null){
                    onListenerNavigationToMainActivity?.onNavigation()
                }
            }
        }
        viewBinding.onBroadingView.setOnclickNavigationToMain(onClickNavigationToMain)
    }




    //endregion
}
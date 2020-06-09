package net.ihaha.sunny.fox.home.video

import androidx.fragment.app.activityViewModels
import net.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import net.ihaha.sunny.fox.home.R
import net.ihaha.sunny.fox.home.databinding.FragmentVideoBinding


/**
 * Create by Sunny date: 25-04-2020
 * Version: 1.0.0
 */

class VideoFragment : BaseBindingFragment<FragmentVideoBinding, VideoViewModel>() {

    //region override

    override val viewModel: VideoViewModel by activityViewModels()

    override val layoutId: Int = R.layout.fragment_video

    //endregion

    companion object{
        fun newInstances() = VideoFragment()
    }


}
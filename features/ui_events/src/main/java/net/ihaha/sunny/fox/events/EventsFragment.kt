package net.ihaha.sunny.fox.events

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import net.ihaha.sunny.base.presentation.fragment.BaseBindingFragment
import net.ihaha.sunny.fox.events.databinding.FragmentEventBinding
import net.ihaha.sunny.fox.events.di.injectFeature
import net.ihaha.sunny.fox.events.di.removeFeature


/**
 * Create by Sunny date: 25-04-2020
 * Version: 1.0.0
 */

class EventsFragment : BaseBindingFragment<FragmentEventBinding, EventsViewModel>() {

    //region override


    override val viewModel: EventsViewModel by activityViewModels()

    override val layoutId: Int = R.layout.fragment_event

    override fun initOnCreate(savedInstanceState: Bundle?) {
        super.initOnCreate(savedInstanceState)
        injectFeature()
    }

    override fun onDestroy() {
        super.onDestroy()
        removeFeature()
    }

    //endregion

    companion object{
        fun newInstances() = EventsFragment()
    }




}
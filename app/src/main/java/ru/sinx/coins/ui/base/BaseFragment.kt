package ru.sinx.coins.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import ru.sinx.coins.navigation.FragmentNavigator

abstract class BaseFragment : Fragment() {

    @get:LayoutRes
    abstract val layout: Int

//    abstract var fragmentNavigator: FragmentNavigator?

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layout, container, false)
    }

    override fun onDestroyView() {
//        fragmentNavigator = null
        super.onDestroyView()
    }
}
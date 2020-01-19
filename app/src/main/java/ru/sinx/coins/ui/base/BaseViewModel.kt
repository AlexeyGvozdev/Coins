package ru.sinx.coins.ui.base

import androidx.lifecycle.ViewModel
import ru.sinx.coins.navigation.FragmentNavigator

open class BaseViewModel : ViewModel() {

    protected var fragmentNavigator: FragmentNavigator? = null
    fun bindNavigator(fragmentNavigator: FragmentNavigator) {
        this.fragmentNavigator = fragmentNavigator
    }

    override fun onCleared() {
        fragmentNavigator = null
        super.onCleared()
    }
}
package ru.sinx.coins.ui.pairs.viewmodel

import androidx.lifecycle.*
import ru.sinx.coins.navigation.FragmentNavigator
import ru.sinx.coins.navigation.NavigationException
import ru.sinx.coins.navigation.pairs.provider.PairNavCommandProvider
import ru.sinx.coins.ui.pairs.status.Status
import java.lang.ref.WeakReference

class PairsViewModule(private val navigation: PairNavCommandProvider, private var fragmentNavigator: FragmentNavigator): ViewModel(), LifecycleObserver {

    val liveData: MutableLiveData<Status> = MutableLiveData<Status>().apply {
        value = Status.Loading
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun loadPairs() {
        val i = 0
    }

    fun onAddPairClick() {
        fragmentNavigator.navigate(navigation.toAddPair) ?: throw NavigationException("navigator is null")
    }
}
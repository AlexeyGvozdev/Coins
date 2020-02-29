package ru.sinx.coins.ui.pairs.viewmodel

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import ru.sinx.coins.navigation.pairs.provider.PairNavCommandProvider
import ru.sinx.coins.repository.pairs.PairRepositoryProvider
import ru.sinx.coins.ui.base.BaseViewModel
import ru.sinx.coins.ui.pairs.status.Status
import ru.sinx.coins.utils.PairCurrency
import javax.inject.Inject

class PairsViewModule @Inject constructor(
    private val repository: PairRepositoryProvider,
    private val navCommands: PairNavCommandProvider
) : BaseViewModel(), LifecycleObserver {

    val liveData: MutableLiveData<Status> = MutableLiveData<Status>().apply {
        value = Status.Loading
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun loadPairs() {
        viewModelScope.launch {
            try {
                val listPair = repository.fetchLocalPairs()
                if (listPair.isEmpty()) {
                    liveData.value = Status.NotHavePairs
                } else {
                    val listPairsWithBidTop = repository.fetchListPairs(listPair)
                    liveData.value = Status.Loaded(listPairsWithBidTop)
                }
            } catch (e: Throwable) {
                liveData.value = Status.Error(e.message ?: e.toString())
            }
        }
    }

    fun onAddPairClick() {
        fragmentNavigator?.navigate(navCommands.toAddPair)
    }

    fun onPairClick(pairCurrency: PairCurrency) {
        fragmentNavigator?.navigate(navCommands.toPairDescription(pairCurrency))
    }

    fun reloadPairs() {
        try {
            viewModelScope.launch {
                try {
                    val listPair = repository.fetchLocalPairs()
                    if (listPair.isEmpty()) {
                        liveData.value = Status.NotHavePairs
                    } else {
                        val listPairsWithBidTop = repository.fetchListPairs(listPair)
                        liveData.value = Status.LoadedRefresh(listPairsWithBidTop)
                    }
                } catch (e: Throwable) {
                    liveData.value = Status.Error(e.message ?: e.toString())
                }
            }
        } catch (t: Throwable) {
            liveData.value = Status.Error(t.message ?: t.toString())
        }
    }
}
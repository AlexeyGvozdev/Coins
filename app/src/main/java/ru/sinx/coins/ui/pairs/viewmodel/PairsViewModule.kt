package ru.sinx.coins.ui.pairs.viewmodel

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import ru.sinx.coins.navigation.FragmentNavigator
import ru.sinx.coins.navigation.NavigationException
import ru.sinx.coins.navigation.pairs.provider.PairNavCommandProvider
import ru.sinx.coins.repository.pairs.PairRepositoryProvider
import ru.sinx.coins.ui.pairs.status.Status
import ru.sinx.coins.utils.Currency
import ru.sinx.coins.utils.PairCurrency

class PairsViewModule(
    private val pairRepositoryProvider: PairRepositoryProvider,
    private val navigation: PairNavCommandProvider,
    private var fragmentNavigator: FragmentNavigator
) : ViewModel(), LifecycleObserver {

    val liveData: MutableLiveData<Status> = MutableLiveData<Status>().apply {
        value = Status.Loading
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun loadPairs() {
        viewModelScope.launch {
            try {
                liveData.value = Status.Loading
                val listPair = listOf(
                    PairCurrency(Currency("BTC"), Currency("USD")),
                    PairCurrency(Currency("BTC"), Currency("RUB")),
                    PairCurrency(Currency("XRP"), Currency("USD")),
                    PairCurrency(Currency("XRP"), Currency("RUB")),
                    PairCurrency(Currency("ETH"), Currency("USD")),
                    PairCurrency(Currency("ETH"), Currency("RUB"))
                )
                val listPairsWithBidTop = pairRepositoryProvider.fetchListPairs(listPair)
                liveData.value = Status.Loaded(listPairsWithBidTop)
            } catch (e: Throwable) {
                liveData.value = Status.Error(e.message ?: e.toString())
            }
        }
    }

    fun onAddPairClick() {
        fragmentNavigator.navigate(navigation.toAddPair)
    }

    fun onPairClick(pairCurrency: PairCurrency) {
        fragmentNavigator.navigate(navigation.toPairDescription(pairCurrency))
    }
}
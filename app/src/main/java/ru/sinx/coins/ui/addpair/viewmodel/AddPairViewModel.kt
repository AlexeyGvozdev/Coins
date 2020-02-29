package ru.sinx.coins.ui.addpair.viewmodel

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import ru.sinx.coins.navigation.addpair.provider.AddPairNavCommandProvider
import ru.sinx.coins.repository.addpair.AddPairRepositoryProvider
import ru.sinx.coins.ui.addpair.status.AddPairStatus
import ru.sinx.coins.ui.base.BaseViewModel
import ru.sinx.coins.utils.Currency
import ru.sinx.coins.utils.DividerPairUI
import ru.sinx.coins.utils.PairCurrency
import javax.inject.Inject

class AddPairViewModel @Inject constructor(
    private val navCommands: AddPairNavCommandProvider,
    private val repository: AddPairRepositoryProvider
) : BaseViewModel(),
    LifecycleObserver {

    val liveData: MutableLiveData<AddPairStatus> = MutableLiveData<AddPairStatus>().apply {
        value = AddPairStatus.Loading
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun loadPairs() {
        viewModelScope.launch {
            try {
                val listStringCurrency = repository.loadCurrency()
                val listPairCurrency = mutableListOf<DividerPairUI>()
                listStringCurrency.forEachIndexed { indexFirst, currencyFirst ->
                    listStringCurrency.forEachIndexed { indexSecond, currencySecond ->
                        if (indexFirst != indexSecond) {
                            listPairCurrency.add(
                                DividerPairUI(
                                    PairCurrency(
                                        Currency(currencyFirst),
                                        Currency(currencySecond)
                                    )
                                )
                            )
                        }
                    }
                }
                liveData.value = AddPairStatus.Loaded(listPairCurrency)
            } catch (t: Throwable) {
                liveData.value = AddPairStatus.Error(t.message ?: t.toString())
            }
        }
    }

    fun onBackClick() {
        fragmentNavigator?.navigate(navCommands.back)
    }

    fun choosePair(pair: String) {
        liveData.value = AddPairStatus.ChoosePair(pair)
    }

    // todo add save to db
    fun onChooseClick() {
        onBackClick()
    }

}
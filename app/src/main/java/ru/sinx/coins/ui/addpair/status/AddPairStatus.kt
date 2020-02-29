package ru.sinx.coins.ui.addpair.status

import ru.sinx.coins.utils.DividerPairUI

sealed class AddPairStatus {
    object Loading : AddPairStatus()
    class Loaded(val data: List<DividerPairUI>) : AddPairStatus()
    class Error(val msg: String) : AddPairStatus()
    class ChoosePair(val pair: String) : AddPairStatus()
}
package ru.sinx.coins.navigation.pairs.provider

import ru.sinx.coins.utils.NavCommand
import ru.sinx.coins.utils.PairCurrency

interface PairNavCommandProvider {
    fun toPairDescription(pairCurrency: PairCurrency): NavCommand
    val toAddPair: NavCommand
}
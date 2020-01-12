package ru.sinx.coins.navigation.pairs.implementation

import ru.sinx.coins.R
import ru.sinx.coins.navigation.pairs.provider.PairNavCommandProvider
import ru.sinx.coins.utils.NavCommand

class PairNavCommandProviderImpl : PairNavCommandProvider {
    override val toAddPair = NavCommand(R.id.action_pairsFragment_to_addPairFragment)
}
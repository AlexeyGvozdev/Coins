package ru.sinx.coins.navigation.pairs.implementation

import ru.sinx.coins.PairDescriptionFragment
import ru.sinx.coins.R
import ru.sinx.coins.navigation.pairs.provider.PairNavCommandProvider
import ru.sinx.coins.utils.NavCommand
import ru.sinx.coins.utils.PairCurrency

class PairNavCommandProviderImpl : PairNavCommandProvider {
    override fun toPairDescription(pairCurrency: PairCurrency): NavCommand {
        return NavCommand(R.id.action_pairsFragment_to_pairDescriptionFragment, PairDescriptionFragment.bundle(pairCurrency))
    }

    override val toAddPair = NavCommand(R.id.action_pairsFragment_to_addPairFragment)
}
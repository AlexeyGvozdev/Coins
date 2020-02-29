package ru.sinx.coins.navigation.addpair.implementation

import ru.sinx.coins.R
import ru.sinx.coins.navigation.addpair.provider.AddPairNavCommandProvider
import ru.sinx.coins.utils.NavCommand

class AddPairNavCommandProviderImpl :
    AddPairNavCommandProvider {
    override val back: NavCommand = NavCommand(R.id.action_back_from_add_pairs_to_pairs_fragment)
}
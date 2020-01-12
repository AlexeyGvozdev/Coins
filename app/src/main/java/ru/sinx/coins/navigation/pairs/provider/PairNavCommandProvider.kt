package ru.sinx.coins.navigation.pairs.provider

import ru.sinx.coins.utils.NavCommand

interface PairNavCommandProvider {
    val toAddPair: NavCommand
}
package ru.sinx.coins.navigation

import ru.sinx.coins.utils.NavCommand

interface FragmentNavigator {
    fun navigate(navCommand: NavCommand)
}
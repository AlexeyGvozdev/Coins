package ru.sinx.coins.utils

import android.os.Bundle
import androidx.navigation.NavOptions

data class NavCommand(
    val action: Int,
    val args: Bundle? = null,
    val navOptions: NavOptions? = null
)

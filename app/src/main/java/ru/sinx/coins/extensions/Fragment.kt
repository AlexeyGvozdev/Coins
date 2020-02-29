package ru.sinx.coins.extensions

import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.sinx.coins.utils.NavCommand

fun Fragment.navigate(navCommand: NavCommand) {
    findNavController().navigate(navCommand.action, navCommand.args, navCommand.navOptions)
}

fun Fragment.toast(msg: String, length: Int = Toast.LENGTH_LONG) {
    activity?.let {
        Toast.makeText(it, msg, length).show()
    }
}
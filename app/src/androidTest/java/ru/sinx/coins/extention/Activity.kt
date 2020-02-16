package ru.sinx.coins.extention

import android.app.Activity
import android.app.ActivityManager
import android.content.Context.ACTIVITY_SERVICE
import androidx.test.platform.app.InstrumentationRegistry


inline fun <reified T : Activity> isVisible(): Boolean {
    val am =
        InstrumentationRegistry.getInstrumentation().targetContext.getSystemService(ACTIVITY_SERVICE) as ActivityManager
    val baseActivity =
        am.takeIf { it.appTasks.isNotEmpty() }?.appTasks?.get(0)?.taskInfo?.baseActivity
    val visibleActivityName = baseActivity?.className
    return visibleActivityName == T::class.java.name
}

inline fun <reified T : Activity> waitUntilActivityVisible() {
    val TIMEOUT = 5000L
    val CONDITION_CHECK_INTERVAL = 100L
    val startTime = System.currentTimeMillis()
    while (!isVisible<T>()) {
        Thread.sleep(CONDITION_CHECK_INTERVAL)
        if (System.currentTimeMillis() - startTime >= TIMEOUT) {
            throw AssertionError("Activity ${T::class.java.simpleName} not visible after $TIMEOUT milliseconds")
        }
    }
}
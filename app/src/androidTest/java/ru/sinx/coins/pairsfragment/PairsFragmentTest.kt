package ru.sinx.coins.pairsfragment

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.sinx.coins.R
import ru.sinx.coins.TestApplication
import ru.sinx.coins.container.ContainerActivity
import ru.sinx.coins.extention.waitUntilActivityVisible
import ru.sinx.coins.pairsfragment.di.DaggerTestApplicationComponent
import ru.sinx.coins.ui.pairs.fragment.PairsFragment

@RunWith(AndroidJUnit4::class)
class PairsFragmentTest {

    @get:Rule
    val activityTestRule: ActivityTestRule<ContainerActivity> =
        ActivityTestRule<ContainerActivity>(ContainerActivity::class.java, true, false)

    @Before
    fun setUp() {
        val app =
            InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as TestApplication
        app.setComponent(
            DaggerTestApplicationComponent
                .factory()
                .create(app)
        )
        activityTestRule.launchActivity(
            Intent(
                app.applicationContext,
                ContainerActivity::class.java
            )
        )
        waitUntilActivityVisible<ContainerActivity>()
        activityTestRule.activity.add(PairsFragment())
    }

    @Test
    fun fragment_on_screen() {
        onView(ViewMatchers.withId(R.id.fb_add_pair)).check(matches(isDisplayed()))
    }

//    @Test
//    fun show_hide_progress() {
//
//
//    }

}
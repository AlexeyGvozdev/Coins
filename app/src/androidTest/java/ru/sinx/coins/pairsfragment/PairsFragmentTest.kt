package ru.sinx.coins.pairsfragment

import android.content.Intent
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.sinx.coins.TestApplication
import ru.sinx.coins.container.ContainerActivity
import ru.sinx.coins.pairsfragment.di.DaggerTestApplicationComponent
import ru.sinx.coins.ui.pairs.fragment.PairsFragment

@RunWith(AndroidJUnit4::class)
class PairsFragmentTest {

    lateinit var scenario: FragmentScenario<PairsFragment>

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
//        activityTestRule.activity.add(PairsFragment())
        scenario = launchFragmentInContainer<PairsFragment>()
        scenario.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun fragment_on_screen() {
//        onView(ViewMatchers.withId(R.id.fb_add_pair)).check(matches(isDisplayed()))
    }

    @Test
    fun show_hide_progress() {


    }

}
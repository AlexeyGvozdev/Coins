package ru.sinx.coins.container

import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import dagger.android.support.DaggerAppCompatActivity
import ru.sinx.coins.R


class ContainerActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.container_activity)
    }

    fun add(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .add(R.id.container_test, fragment, fragment::class.java.simpleName)
            .addToBackStack(null)
            .commit()
    }

}
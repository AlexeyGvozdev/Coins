package ru.sinx.coins.ui.pairs.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_pairs.*
import ru.sinx.coins.R
import ru.sinx.coins.extensions.hide
import ru.sinx.coins.extensions.navigate
import ru.sinx.coins.extensions.show
import ru.sinx.coins.navigation.FragmentNavigator
import ru.sinx.coins.navigation.pairs.implementation.PairNavCommandProviderImpl
import ru.sinx.coins.repository.pairs.PairRepositoryProviderImpl
import ru.sinx.coins.ui.base.BaseFragment
import ru.sinx.coins.ui.pairs.adapter.PairsAdapter
import ru.sinx.coins.ui.pairs.status.Status
import ru.sinx.coins.ui.pairs.viewmodel.PairsViewModule
import ru.sinx.coins.utils.NavCommand
import java.lang.ref.WeakReference

/**
 * A simple [Fragment] subclass.
 */
class PairsFragment : BaseFragment() {

    private val adapter: PairsAdapter = PairsAdapter()

    override fun onDestroyView() {
        rv_pairs.adapter = null
        super.onDestroyView()
    }

    override val layout: Int = R.layout.fragment_pairs

    private var navigator: FragmentNavigator = object : FragmentNavigator {
        override fun navigate(navCommand: NavCommand) {
            this@PairsFragment.navigate(navCommand)
        }

    }

    private val viewModel: PairsViewModule = PairsViewModule(
        PairRepositoryProviderImpl(),
        PairNavCommandProviderImpl(),
        navigator);

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycle.addObserver(viewModel)
        adapter.setOnClickListener {
            viewModel.onPairClick(it)
        }
        rv_pairs.adapter = adapter
        viewModel.liveData.observe(this, Observer {
            when (it) {
                is Status.Loading -> {
                    progress_pairs.show()
                }
                is Status.Error -> {
                    progress_pairs.hide()
                    Toast.makeText(activity, it.msg, Toast.LENGTH_LONG).show()
                }
                is Status.Loaded -> {
                    progress_pairs.hide()
                    adapter.setListPair(it.data)
                }
            }
        })
        fb_add_pair.setOnClickListener {
            viewModel.onAddPairClick()
        }
    }


}

package ru.sinx.coins.ui.pairs.fragment


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_pairs.*
import ru.sinx.coins.R
import ru.sinx.coins.di.services.api.Api
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
        PairRepositoryProviderImpl(Api.FakeApiCorrect()),
        PairNavCommandProviderImpl(),
        navigator
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycle.addObserver(viewModel)
        sr_refresh_pair.setOnRefreshListener {
            viewModel.reloadPairs()
        }
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
                    tv_empty_pairs.hide()
                }
                is Status.LoadedRefresh -> {
                    sr_refresh_pair.isRefreshing = false
                    adapter.setListPair(it.data)
                }
                is Status.Refresh -> {
                    sr_refresh_pair.isRefreshing = true
                }
                is Status.NotHavePairs -> {
                    rv_pairs.hide()
                    sr_refresh_pair.isRefreshing = false
                    progress_pairs.hide()
                    tv_empty_pairs.show()
                }
            }
        })
        fb_add_pair.setOnClickListener {
            viewModel.onAddPairClick()
        }
    }
}

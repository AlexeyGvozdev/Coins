package ru.sinx.coins.ui.pairs.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_pairs.*
import ru.sinx.coins.R
import ru.sinx.coins.extensions.navigate
import ru.sinx.coins.navigation.FragmentNavigator
import ru.sinx.coins.navigation.pairs.implementation.PairNavCommandProviderImpl
import ru.sinx.coins.ui.base.BaseFragment
import ru.sinx.coins.ui.pairs.status.Status
import ru.sinx.coins.ui.pairs.viewmodel.PairsViewModule
import ru.sinx.coins.utils.NavCommand
import java.lang.ref.WeakReference

/**
 * A simple [Fragment] subclass.
 */
class PairsFragment : BaseFragment() {
    override fun onDestroyView() {
        super.onDestroyView()
        val i = 0
    }

    override val layout: Int = R.layout.fragment_pairs

    private var navigator: FragmentNavigator = object : FragmentNavigator {
        override fun navigate(navCommand: NavCommand) {
            this@PairsFragment.navigate(navCommand)
        }

    }

    val viewModel: PairsViewModule = PairsViewModule(PairNavCommandProviderImpl(), navigator);

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycle.addObserver(viewModel)
        viewModel.liveData.observe(this, Observer {
            when (it) {
                is Status.Loading -> {
                }
                is Status.Error -> {
                }
                is Status.Loaded -> {
                }
            }
        })
//        ViewModelProvider(this, findNavController().)
        fb_add_pair.setOnClickListener {
            viewModel.onAddPairClick()
        }
    }


}

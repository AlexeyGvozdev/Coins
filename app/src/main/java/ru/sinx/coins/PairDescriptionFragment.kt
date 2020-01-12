package ru.sinx.coins


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_pair_description.*
import ru.sinx.coins.ui.base.BaseFragment
import ru.sinx.coins.utils.Currency
import ru.sinx.coins.utils.DividerPairUI
import ru.sinx.coins.utils.PairCurrency

/**
 * A simple [Fragment] subclass.
 */
class PairDescriptionFragment : BaseFragment() {
    override val layout = R.layout.fragment_pair_description

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val first = arguments?.getString(keyFirst)
        val second = arguments?.getString(keySecond)
        if (!first.isNullOrEmpty() && !second.isNullOrEmpty()) {
            tv_descr.text = DividerPairUI(PairCurrency(Currency(first), Currency(second))).toString()
        }
    }

    companion object {
        private const val keyFirst = "keyFirst"
        private const val keySecond = "keySecond"
        fun bundle(pairCurrency: PairCurrency): Bundle {
            val bundle = Bundle()
            bundle.putString(keyFirst, pairCurrency.first.toString())
            bundle.putString(keySecond, pairCurrency.second.toString())
            return bundle
        }
    }

}

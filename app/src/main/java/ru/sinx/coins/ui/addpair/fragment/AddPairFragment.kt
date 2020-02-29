package ru.sinx.coins.ui.addpair.fragment


import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import kotlinx.android.synthetic.main.fragment_add_pair.*
import ru.sinx.coins.R
import ru.sinx.coins.extensions.SpinnerLayoutManager
import ru.sinx.coins.extensions.hide
import ru.sinx.coins.extensions.show
import ru.sinx.coins.extensions.toast
import ru.sinx.coins.ui.addpair.adapter.SpinnerPairAdapter
import ru.sinx.coins.ui.addpair.status.AddPairStatus
import ru.sinx.coins.ui.addpair.viewmodel.AddPairViewModel
import ru.sinx.coins.ui.base.BaseFragment
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class AddPairFragment : BaseFragment() {

    private val adapter = SpinnerPairAdapter()

    @Inject
    lateinit var viewModel: AddPairViewModel

    override val layout: Int
        get() = R.layout.fragment_add_pair

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvChoosePairs.adapter = adapter
        val spinnerLayoutManager = SpinnerLayoutManager(activity)
        LinearSnapHelper().attachToRecyclerView(rvChoosePairs)
        spinnerLayoutManager.setOnScrollStopListener(object :
            SpinnerLayoutManager.onScrollStopListener {
            override fun selectedView(view: View?) {
                (view as? ConstraintLayout)?.findViewById<TextView>(R.id.tvItemAddPair)?.let {
                    viewModel.choosePair(it.text.toString())
                }
            }
        })
        rvChoosePairs.layoutManager = spinnerLayoutManager
        btnChoosePair.setOnClickListener {
            viewModel.onChooseClick()
        }
        lifecycle.addObserver(viewModel)
        viewModel.bindNavigator(navigator)
        viewModel.liveData.observe(this, Observer {
            when (it) {
                is AddPairStatus.Loading -> {
                    clProgressAddPair.show()
                }
                is AddPairStatus.Loaded -> {
                    adapter.setListPair(it.data)
                    clProgressAddPair.hide()
                }
                is AddPairStatus.Error -> {
                    toast(it.msg)
                    clProgressAddPair.hide()
                }
                is AddPairStatus.ChoosePair -> {
                    tvChoosenAddPair.text = "You choose: ${it.pair}"
                }
            }
        })
        ivBackAddPair.setOnClickListener {
            viewModel.onBackClick()
        }
    }
}

package com.kok1337.feature_ppn_taxation.api.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kok1337.feature_ppn_taxation.R
import com.kok1337.feature_ppn_taxation.databinding.FragmentPpnTaxationBinding
import com.kok1337.feature_ppn_taxation.internal.di.DaggerFeaturePpnTaxationComponent
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listitem_adapter.ListItemAdapter
import com.kok1337.feature_ppn_taxation.internal.presentation.fragment.PpnTaxationViewModel
import com.kok1337.providing_dependencies.findDependencies
import dagger.Lazy
import javax.inject.Inject

class PpnTaxationFragment : Fragment(R.layout.fragment_ppn_taxation) {
    private val binding by viewBinding(FragmentPpnTaxationBinding::bind)

    @Inject
    internal lateinit var viewModelFactory: Lazy<PpnTaxationViewModel.Factory>
    private val viewModel: PpnTaxationViewModel by viewModels {
        viewModelFactory.get()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFeaturePpnTaxationComponent.factory()
            .create(findDependencies())
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listItemAdapter = ListItemAdapter(viewModel)

        lifecycleScope.launchWhenStarted {
            viewModel.listItemListFlow.collect { listItemAdapter.items = it }
        }

        binding.recyclerView.adapter = listItemAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
    }
}
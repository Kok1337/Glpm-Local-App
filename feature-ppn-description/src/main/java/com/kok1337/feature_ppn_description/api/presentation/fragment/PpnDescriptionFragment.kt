package com.kok1337.feature_ppn_description.api.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kok1337.feature_ppn_description.R
import com.kok1337.feature_ppn_description.api.domain.module.*
import com.kok1337.feature_ppn_description.databinding.FragmentPpnDescriptionBinding
import com.kok1337.feature_ppn_description.internal.di.DaggerPpnDescriptionFragmentComponent
import com.kok1337.feature_ppn_description.internal.presentation.adapter.description_item_adapter.DescriptionItemAdapter
import com.kok1337.feature_ppn_description.internal.presentation.adapter.description_item_adapter.listener.AdapterListener
import com.kok1337.feature_ppn_description.internal.presentation.fragment.PpnDescriptionViewModel
import com.kok1337.providing_dependencies.findDependencies
import dagger.Lazy
import javax.inject.Inject

class PpnDescriptionFragment : Fragment(R.layout.fragment_ppn_description), AdapterListener {
    private val binding by viewBinding(FragmentPpnDescriptionBinding::bind)

    @Inject
    internal lateinit var viewModelFactory: Lazy<PpnDescriptionViewModel.Factory>
    private val viewModel: PpnDescriptionViewModel by viewModels {
        viewModelFactory.get()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerPpnDescriptionFragmentComponent.factory()
            .create(findDependencies())
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val descriptionItemAdapter = DescriptionItemAdapter(this)

        lifecycleScope.launchWhenStarted {
            lifecycleScope.launchWhenStarted {
                viewModel.descriptionItemListFlow.collect { descriptionItemAdapter.items = it }
            }
        }

        binding.recyclerView.adapter = descriptionItemAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun onFederalDistrictClick(federalDistrict: FederalDistrict?) {
        TODO("Not yet implemented")
    }

    override fun onRegionClick(region: Region?) {
    }

    override fun onForestryClick(forestry: Forestry?) {
    }

    override fun onLocalForestryClick(localForestry: LocalForestry?) {
    }

    override fun onSubForestryClick(subForestry: SubForestry?) {
    }

    override fun onAreaClick(area: String?) {
    }
}
package com.kok1337.feature_ppn.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.kok1337.address.domain.model.*
import com.kok1337.feature_ppn.R
import com.kok1337.feature_ppn.databinding.FragmentPpnBinding
import com.kok1337.feature_ppn.di.DaggerFeaturePpnFragmentComponent
import com.kok1337.feature_ppn.presentation.adapter.PpnFragmentPagerAdapter
import com.kok1337.feature_ppn_description.di.LocalityInMemoryRepository
import com.kok1337.providing_dependencies.DepsMap
import com.kok1337.providing_dependencies.HasDependencies
import com.kok1337.providing_dependencies.findDependencies
import dagger.Lazy
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class PpnFragment : Fragment(R.layout.fragment_ppn), HasDependencies {
    private val binding by viewBinding(FragmentPpnBinding::bind)

    @Inject
    lateinit var viewModelFactory: Lazy<PpnViewModel.Factory>
    private val viewModel: PpnViewModel by viewModels {
        viewModelFactory.get()
    }

    @Inject
    override lateinit var depsMap: DepsMap

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFeaturePpnFragmentComponent.factory()
            .create(
                featurePpnFragmentDeps = findDependencies(),
                localityInMemoryRepository = LocalityInMemoryRepositoryImpl()
            ).inject(this)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ppnFragmentPagerAdapter = PpnFragmentPagerAdapter(this)
        binding.viewPager.adapter = ppnFragmentPagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Описание"
                1 -> "ТО"
                else -> throw IllegalStateException()
            }
        }.attach()

        binding.button.setOnClickListener {
            ppnFragmentPagerAdapter.isTaxEnabled = !ppnFragmentPagerAdapter.isTaxEnabled
        }
    }

    inner class LocalityInMemoryRepositoryImpl : LocalityInMemoryRepository {
        override fun getLocalityStateFlow(): StateFlow<Locality> {
            return viewModel.localityStateFlow
        }

        override fun updateRegion(region: Region?) = viewModel.updateRegion(region)

        override fun updateForestry(forestry: Forestry?) = viewModel.updateForestry(forestry)

        override fun updateLocalForestry(localForestry: LocalForestry?) =
            viewModel.updateLocalForestry(localForestry)

        override fun updateSubForestry(subForestry: SubForestry?) =
            viewModel.updateSubForestry(subForestry)

        override fun updateArea(area: String?) = viewModel.updateArea(area)
    }
}
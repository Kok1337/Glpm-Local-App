package com.kok1337.feature_ppn.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.kok1337.address.domain.model.*
import com.kok1337.feature_ppn.R
import com.kok1337.feature_ppn.databinding.FragmentPpnBinding
import com.kok1337.feature_ppn.di.DaggerFeaturePpnFragmentComponent
import com.kok1337.feature_ppn.presentation.adapter.PpnFragmentPagerAdapter
import com.kok1337.feature_ppn_description.data.repository.DescriptionLocalityInMemoryRepository
import com.kok1337.feature_ppn_description.data.repository.DescriptionTaxInMemoryRepository
import com.kok1337.feature_ppn_taxation.data.repository.TaxationTaxInMemoryRepository
import com.kok1337.feature_ppn_taxation.data.repository.TaxationTaxLayerInMemoryRepository
import com.kok1337.feature_ppn_taxation.data.repository.TaxationTaxSpeciesInMemoryRepository
import com.kok1337.providing_dependencies.DepsMap
import com.kok1337.providing_dependencies.HasDependencies
import com.kok1337.providing_dependencies.findDependencies
import com.kok1337.species.domain.model.Species
import com.kok1337.taxation.domain.model.*
import dagger.Lazy
import kotlinx.coroutines.flow.StateFlow
import java.util.*
import javax.inject.Inject

class PpnFragment : Fragment(R.layout.fragment_ppn), HasDependencies {
    private val binding by viewBinding(FragmentPpnBinding::bind)

    @Inject
    internal lateinit var viewModelFactory: Lazy<PpnViewModel.Factory>
    private val viewModel: PpnViewModel by viewModels {
        viewModelFactory.get()
    }

    @Inject
    override lateinit var depsMap: DepsMap

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFeaturePpnFragmentComponent.factory().create(
            featurePpnFragmentDeps = findDependencies(),
            descriptionLocalityInMemoryRepository = DescriptionLocalityInMemoryRepositoryImpl(),
            descriptionTaxInMemoryRepository = DescriptionTaxInMemoryRepositoryImpl(),
            taxationTaxInMemoryRepository = TaxationTaxInMemoryRepositoryImpl(),
            taxationTaxLayerInMemoryRepository = TaxationTaxLayerInMemoryRepositoryImpl(),
            taxationTaxSpeciesInMemoryRepository = TaxationTaxSpeciesInMemoryRepositoryImpl(),
        ).inject(this)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ppnFragmentPagerAdapter = PpnFragmentPagerAdapter(this)
        binding.viewPager.adapter = ppnFragmentPagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = getTabTextByPosition(position)
        }.attach()

        lifecycleScope.launchWhenStarted {
            viewModel.taxStateFlow.collect { tax: Tax? ->
                ppnFragmentPagerAdapter.isTaxEnabled = tax != null
            }
        }
    }

    private fun getTabTextByPosition(position: Int) = when (position) {
        0 -> "Описание"
        1 -> "ТО"
        else -> throw IllegalStateException()
    }

    inner class DescriptionLocalityInMemoryRepositoryImpl : DescriptionLocalityInMemoryRepository {
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

    inner class DescriptionTaxInMemoryRepositoryImpl : DescriptionTaxInMemoryRepository {
        override fun getTaxStateFlow(): StateFlow<Tax?> = viewModel.taxStateFlow

        override fun enterTaxPreview(taxPreview: TaxPreview) {
            viewModel.getTaxById(taxPreview.id)
        }
    }

    inner class TaxationTaxInMemoryRepositoryImpl : TaxationTaxInMemoryRepository {
        override fun getTaxStateFlow(): StateFlow<Tax?> = viewModel.taxStateFlow

        override fun updateUnforestedLand(unforestedLand: UnforestedLand?) =
            viewModel.updateTaxUnforestedLand(unforestedLand)

        override fun updateNonForestLand(nonForestLand: NonForestLand?) =
            viewModel.updateTaxNonForestLand(nonForestLand)

        override fun updateForestPurpose(forestPurpose: ForestPurpose?) =
            viewModel.updateTaxForestPurpose(forestPurpose)

        override fun updateProtectionCategory(protectionCategory: ProtectionCategory?) =
            viewModel.updateTaxProtectionCategory(protectionCategory)

        override fun updateBonitet(bonitet: Bonitet?) = viewModel.updateTaxBonitet(bonitet)

        override fun updateForestType(forestType: String?) =
            viewModel.updateTaxForestType(forestType)

        override fun updateOzu(ozu: Ozu?) = viewModel.updateTaxOzu(ozu)

        override fun addTaxLayer() = viewModel.addTaxLayer()
    }

    inner class TaxationTaxLayerInMemoryRepositoryImpl : TaxationTaxLayerInMemoryRepository {
        override fun updateHeight(taxLayerId: UUID, height: Int?) =
            viewModel.updateTaxLayerHeight(taxLayerId, height)

        override fun updateAgeClass(taxLayerId: UUID, ageClass: Int?) =
            viewModel.updateTaxLayerAgeClass(taxLayerId, ageClass)

        override fun updateAgeGroup(taxLayerId: UUID, ageGroup: AgeGroup?) =
            viewModel.updateTaxLayerAgeGroup(taxLayerId, ageGroup)

        override fun updateFullness(taxLayerId: UUID, fullness: Double?) =
            viewModel.updateTaxLayerFullness(taxLayerId, fullness)

        override fun updateStock(taxLayerId: UUID, stock: Double?) =
            viewModel.updateTaxLayerStock(taxLayerId, stock)

        override fun addTaxSpecies(taxLayerId: UUID) =
            viewModel.addTaxSpeciesByTaxLayerId(taxLayerId)

        override fun deleteTaxLayer(taxLayerId: UUID) = viewModel.deleteTaxLayerById(taxLayerId)
    }

    inner class TaxationTaxSpeciesInMemoryRepositoryImpl : TaxationTaxSpeciesInMemoryRepository {
        override fun updateCoeff(taxSpeciesId: UUID, coeff: Int?) =
            viewModel.updateTaxSpeciesCoeff(taxSpeciesId, coeff)

        override fun updateSpecies(taxSpeciesId: UUID, species: Species?) =
            viewModel.updateTaxSpeciesSpecies(taxSpeciesId, species)

        override fun updateAge(taxSpeciesId: UUID, age: Int?) =
            viewModel.updateTaxSpeciesAge(taxSpeciesId, age)

        override fun updateHeight(taxSpeciesId: UUID, height: Int?) =
            viewModel.updateTaxSpeciesHeight(taxSpeciesId, height)

        override fun updateDiameter(taxSpeciesId: UUID, diameter: Int?) =
            viewModel.updateTaxSpeciesDiameter(taxSpeciesId, diameter)

        override fun deleteTaxLayerSpecies(taxSpeciesId: UUID) =
            viewModel.deleteTaxSpeciesById(taxSpeciesId)
    }
}
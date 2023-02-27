package com.kok1337.feature_ppn_taxation.api.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.kok1337.dialog.presentation.dialog.InputStringDialog
import com.kok1337.extensions.showDialog
import com.kok1337.feature_ppn_taxation.R
import com.kok1337.feature_ppn_taxation.databinding.FragmentPpnTaxationBinding
import com.kok1337.feature_ppn_taxation.internal.di.DaggerFeaturePpnTaxationComponent
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.TaxAdapter
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listener.AdapterListener
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.spinner.*
import com.kok1337.feature_ppn_taxation.internal.presentation.fragment.PpnTaxationViewModel
import com.kok1337.land.api.model.Land
import com.kok1337.providing_dependencies.findDependencies
import com.kok1337.searchable_spinner.presentation.dialog.SearchableSpinnerDialog
import com.kok1337.tax.api.model.Tax
import com.kok1337.tax_layer.api.model.TaxLayer
import com.kok1337.tax_layer_species.api.model.TaxLayerSpecies
import dagger.Lazy
import java.util.*
import javax.inject.Inject

class PpnTaxationFragment : Fragment(R.layout.fragment_ppn_taxation), AdapterListener {
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
        val taxAdapter = TaxAdapter(this)

        lifecycleScope.launchWhenStarted {
            viewModel.taxItemFlow.collect { taxAdapter.setTaxItem(it) }
        }

        binding.recyclerView.adapter = taxAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

//        viewModel
    }

    override fun onDeleteTaxLayerClick(taxLayer: TaxLayer) {
        viewModel.deleteTaxLayer(taxLayer)
    }

    override fun onForestTypeClick(tax: Tax) {
        val dialog = InputStringDialog(
            "Введите тип леса",
            tax.forestType
        ) { forestType -> viewModel.updateTax(tax.copy(forestType = forestType)) }
        showDialog(dialog, requireContext())
    }

    override fun onNotCoveredForestClick(isCovered: Boolean) {
        viewModel.setIsCoveredForest(isCovered)
    }

    override fun onLandClick(land: Land?) {
        val searchableSpinnerDialog = SearchableSpinnerDialog(
            "Выберите земли",
            LandSpinnerAdapter(),
            viewModel.landSpinnerRepository,
        ) { newLand -> viewModel.setLand(newLand) }
        showDialog(searchableSpinnerDialog, requireContext())
    }

    override fun onUnforestedLandClick(tax: Tax) {
        val searchableSpinnerDialog = SearchableSpinnerDialog(
            "Выберите не лесные земли",
            UnforestedLandSpinnerAdapter(),
            viewModel.unforestedLandSpinnerRepository,
        ) { unforestedLand -> viewModel.updateTax(tax.copy(unforestedLand = unforestedLand)) }
        showDialog(searchableSpinnerDialog, requireContext())
    }

    override fun onNonForestLandClick(tax: Tax) {
        val searchableSpinnerDialog = SearchableSpinnerDialog(
            "Выберите лесные земли",
            NonForestLandSpinnerAdapter(),
            viewModel.nonForestLandSpinnerRepository,
        ) { nonForestLand -> viewModel.updateTax(tax.copy(nonForestLand = nonForestLand)) }
        showDialog(searchableSpinnerDialog, requireContext())
    }

    override fun onForestPurposeClick(tax: Tax) {
        val searchableSpinnerDialog = SearchableSpinnerDialog(
            "Выберите целевое назначение",
            ForestPurposeSpinnerAdapter(),
            viewModel.forestPurposeSpinnerRepository,
        ) { forestPurpose -> viewModel.updateTax(tax.copy(forestPurpose = forestPurpose)) }
        showDialog(searchableSpinnerDialog, requireContext())
    }

    override fun onProtectionCategoryClick(tax: Tax) {
        val searchableSpinnerDialog = SearchableSpinnerDialog(
            "Выберите категорию защитности",
            ProtectionCategorySpinnerAdapter(),
            viewModel.protectionCategorySpinnerRepository,
        ) { protectionCategory -> viewModel.updateTax(tax.copy(protectionCategory = protectionCategory)) }
        showDialog(searchableSpinnerDialog, requireContext())
    }

    override fun onBonitetClick(tax: Tax) {
        val searchableSpinnerDialog = SearchableSpinnerDialog(
            "Выберите бонитет",
            BonitetSpinnerAdapter(),
            viewModel.bonitetSpinnerRepository,
        ) { bonitet -> viewModel.updateTax(tax.copy(bonitet = bonitet)) }
        showDialog(searchableSpinnerDialog, requireContext())
    }

    override fun onOzuClick(tax: Tax) {
        val searchableSpinnerDialog = SearchableSpinnerDialog(
            "Выберите ОЗУ",
            OzuSpinnerAdapter(),
            viewModel.ozuSpinnerRepository,
        ) { ozu -> viewModel.updateTax(tax.copy(ozu = ozu)) }
        showDialog(searchableSpinnerDialog, requireContext())
    }

    override fun onDeleteTaxLayerSpeciesClick(taxLayerSpecies: TaxLayerSpecies) {
        viewModel.deleteTaxLayerSpecies(taxLayerSpecies)

    }

    override fun onAddTaxLayerClick(taxId: UUID) {
        viewModel.addTaxLayer(taxId)
    }

    override fun onAddTaxLayerSpeciesClick(taxLayerId: UUID) {
        viewModel.addTaxLayerSpecies(taxLayerId)
    }
}
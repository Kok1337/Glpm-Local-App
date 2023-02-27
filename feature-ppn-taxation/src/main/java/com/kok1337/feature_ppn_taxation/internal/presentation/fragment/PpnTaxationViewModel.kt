package com.kok1337.feature_ppn_taxation.internal.presentation.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.kok1337.bonitet.api.model.Bonitet
import com.kok1337.feature_ppn_taxation.api.dependencies.TaxRedactor
import com.kok1337.feature_ppn_taxation.api.dependencies.TaxRedactorProvider
import com.kok1337.feature_ppn_taxation.api.dependencies.TaxStateFlowProvider
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listener.*
import com.kok1337.feature_ppn_taxation.internal.presentation.item.TaxItem
import com.kok1337.forest_purpose.api.model.ForestPurpose
import com.kok1337.land.api.model.Land
import com.kok1337.non_forest_land.api.model.NonForestLand
import com.kok1337.ozu.api.model.Ozu
import com.kok1337.protection_category.api.model.ProtectionCategory
import com.kok1337.searchable_spinner.domain.repository.SearchableSpinnerRepository
import com.kok1337.tax.api.model.Tax
import com.kok1337.tax_layer.api.model.TaxLayer
import com.kok1337.tax_layer_species.api.model.TaxLayerSpecies
import com.kok1337.unforested_land.api.model.UnforestedLand
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

internal class PpnTaxationViewModel(
    private val taxFlow: StateFlow<Tax>,
    private val taxRedactor: TaxRedactor,
    val landSpinnerRepository: SearchableSpinnerRepository<Land>,
    val unforestedLandSpinnerRepository: SearchableSpinnerRepository<UnforestedLand>,
    val nonForestLandSpinnerRepository: SearchableSpinnerRepository<NonForestLand>,
    val forestPurposeSpinnerRepository: SearchableSpinnerRepository<ForestPurpose>,
    val protectionCategorySpinnerRepository: SearchableSpinnerRepository<ProtectionCategory>,
    val bonitetSpinnerRepository: SearchableSpinnerRepository<Bonitet>,
    val ozuSpinnerRepository: SearchableSpinnerRepository<Ozu>,
) : ViewModel() {
    private val _isCoveredForestFlow =
        MutableStateFlow(isCoveredForestByTax(taxFlow.value))
    private val _landFlow = MutableStateFlow<Land?>(null)

    val taxItemFlow: Flow<TaxItem> = combineTransform(
        _isCoveredForestFlow, taxFlow, _landFlow
    ) { isCoveredForest, tax, land ->
        emit(TaxItem(tax, isCoveredForest, land))
    }

    private fun isCoveredForestByTax(tax: Tax): Boolean {
        return true
    }

    fun setIsCoveredForest(isCoveredForest: Boolean) {
        _isCoveredForestFlow.value = isCoveredForest
    }

    fun setLand(land: Land?) {
        _landFlow.value = land
    }

    fun updateTax(updatedTax: Tax) =
        viewModelScope.launch(Dispatchers.IO) {
            taxRedactor.updateTax(updatedTax)
        }

    fun updateTaxLayer(updatedTaxLayer: TaxLayer) =
        viewModelScope.launch(Dispatchers.IO) {
            taxRedactor.updateTaxLayer(updatedTaxLayer)
        }

    fun updateTaxLayerSpecies(updatedTaxLayerSpecies: TaxLayerSpecies) =
        viewModelScope.launch(Dispatchers.IO) {
            taxRedactor.updateTaxLayerSpecies(updatedTaxLayerSpecies)
        }

    fun deleteTaxLayer(taxLayer: TaxLayer) =
        viewModelScope.launch(Dispatchers.IO) {
            taxRedactor.deleteTaxLayer(taxLayer)
        }

    fun deleteTaxLayerSpecies(taxLayerSpecies: TaxLayerSpecies) =
        viewModelScope.launch(Dispatchers.IO) {
            taxRedactor.deleteTaxLayerSpecies(taxLayerSpecies)
        }

    fun addTaxLayer(taxId: UUID) = viewModelScope.launch(Dispatchers.IO) {
        taxRedactor.addTaxLayer(taxId)
    }

    fun addTaxLayerSpecies(taxLayerId: UUID) = viewModelScope.launch(Dispatchers.IO) {
        taxRedactor.addTaxLayerSpecies(taxLayerId)
    }

    class Factory @Inject constructor(
        private val taxStateFlowProvider: TaxStateFlowProvider,
        private val taxRedactorProvider: TaxRedactorProvider,
        private val landSpinnerRepository: SearchableSpinnerRepository<Land>,
        private val unforestedLandSpinnerRepository: SearchableSpinnerRepository<UnforestedLand>,
        private val nonForestLandSpinnerRepository: SearchableSpinnerRepository<NonForestLand>,
        private val forestPurposeSpinnerRepository: SearchableSpinnerRepository<ForestPurpose>,
        private val protectionCategorySpinnerRepository: SearchableSpinnerRepository<ProtectionCategory>,
        private val bonitetSpinnerRepository: SearchableSpinnerRepository<Bonitet>,
        private val ozuSpinnerRepository: SearchableSpinnerRepository<Ozu>,
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == PpnTaxationViewModel::class.java)
            return PpnTaxationViewModel(
                taxFlow = taxStateFlowProvider.get(),
                taxRedactor = taxRedactorProvider.get(),
                landSpinnerRepository = landSpinnerRepository,
                unforestedLandSpinnerRepository = unforestedLandSpinnerRepository,
                nonForestLandSpinnerRepository = nonForestLandSpinnerRepository,
                forestPurposeSpinnerRepository = forestPurposeSpinnerRepository,
                protectionCategorySpinnerRepository = protectionCategorySpinnerRepository,
                bonitetSpinnerRepository = bonitetSpinnerRepository,
                ozuSpinnerRepository = ozuSpinnerRepository
            ) as T
        }
    }
}
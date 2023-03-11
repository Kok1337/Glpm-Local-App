package com.kok1337.feature_ppn_taxation.presentation.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.kok1337.feature_ppn_taxation.di.*
import com.kok1337.feature_ppn_taxation.domain.use_case.*
import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.TaxationItem
import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.TaxationItemTransformer
import com.kok1337.taxation.domain.model.Land
import com.kok1337.taxation.domain.model.Tax
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

internal class PpnTaxationViewModel(
    private val getLandByIsForestedLandUseCase: GetLandByIsForestedLandUseCase,
    private val getObservableTaxUseCase: GetObservableTaxUseCase,

    val getAllLandUseCase: GetAllLandUseCase,
    val getAllUnforestedLandWithSearchUseCase: GetAllUnforestedLandWithSearchUseCase,
    val getAllNonForestLandWithSearchUseCase: GetAllNonForestLandWithSearchUseCase,
    val getAllForestPurposeWithSearchUseCase: GetAllForestPurposeWithSearchUseCase,
    val getAllProtectionCategoryWithSearchUseCase: GetAllProtectionCategoryWithSearchUseCase,
    val getAllBonitetWithSearchUseCase: GetAllBonitetWithSearchUseCase,
    val getAllOzuWithSearchUseCase: GetAllOzuWithSearchUseCase,
    val getAllAgeGroupWithSearchUseCase: GetAllAgeGroupWithSearchUseCase,
    val getAllSpeciesUseCase: GetAllSpeciesUseCase,

    val enterTaxNonForestLandUseCase: EnterTaxNonForestLandUseCase,
    val enterTaxUnforestedLandUseCase: EnterTaxUnforestedLandUseCase,
    val enterTaxForestPurposeUseCase: EnterTaxForestPurposeUseCase,
    val enterTaxProtectionCategoryUseCase: EnterTaxProtectionCategoryUseCase,
    val enterTaxBonitetUseCase: EnterTaxBonitetUseCase,
    val enterTaxForestTypeUseCase: EnterTaxForestTypeUseCase,
    val enterTaxOzuUseCase: EnterTaxOzuUseCase,

    val enterTaxLayerHeightByIdUseCase: EnterTaxLayerHeightByIdUseCase,
    val enterTaxLayerAgeClassByIdUseCase: EnterTaxLayerAgeClassByIdUseCase,
    val enterTaxLayerAgeGroupByIdUseCase: EnterTaxLayerAgeGroupByIdUseCase,
    val enterTaxLayerFullnessByIdUseCase: EnterTaxLayerFullnessByIdUseCase,
    val enterTaxLayerStockByIdUseCase: EnterTaxLayerStockByIdUseCase,

    val enterTaxSpeciesCoeffByIdUseCase: EnterTaxSpeciesCoeffByIdUseCase,
    val enterTaxSpeciesSpeciesByIdUseCase: EnterTaxSpeciesSpeciesByIdUseCase,
    val enterTaxSpeciesAgeByIdUseCase: EnterTaxSpeciesAgeByIdUseCase,
    val enterTaxSpeciesHeightByIdUseCase: EnterTaxSpeciesHeightByIdUseCase,
    val enterTaxSpeciesDiameterByIdUseCase: EnterTaxSpeciesDiameterByIdUseCase,

    val addTaxLayerUseCase: AddTaxLayerUseCase,
    val addTaxSpeciesByTaxLayerIdUseCase: AddTaxSpeciesByTaxLayerIdUseCase,
    val deleteTaxLayerByIdUseCase: DeleteTaxLayerByIdUseCase,
    val deleteTaxSpeciesByIdUseCase: DeleteTaxSpeciesByIdUseCase,
) : ViewModel() {
    private val _taxStateFlow = getObservableTaxUseCase()
    private val _isCoveredForestStateFlow = MutableStateFlow(false)
    private val _landLandFlow = MutableStateFlow<Land?>(null)

    val taxationItemListStateFlow: Flow<List<TaxationItem>> = combineTransform(
        _taxStateFlow, _isCoveredForestStateFlow, _landLandFlow
    ) { tax, isCoveredForest, land ->
        emit(TaxationItemTransformer.transformToTaxationItemList(tax, isCoveredForest, land))
    }

    init {
        var prevTaxId: UUID? = null
        viewModelScope.launch(Dispatchers.IO) {
            _taxStateFlow.collectLatest { tax ->
                if (tax?.id != prevTaxId) {
                    _isCoveredForestStateFlow.value = getIsCoveredForestByTax(tax)
                    _landLandFlow.value = getLandByTax(tax)
                    prevTaxId = tax?.id
                }
            }
        }
    }

    private fun getIsCoveredForestByTax(tax: Tax?): Boolean {
        if (tax == null) return false
        if (tax.unforestedLand != null || tax.nonForestLand != null) return false
        return true
    }

    private suspend fun getLandByTax(tax: Tax?): Land? {
        if (tax == null) return null
        if (tax.unforestedLand != null) return getLandByIsForestedLandUseCase(true)
        if (tax.nonForestLand != null) return getLandByIsForestedLandUseCase(false)
        return null
    }

    fun updateIsCoveredForest(isCoveredForest: Boolean) {
        _isCoveredForestStateFlow.value = isCoveredForest
    }

    fun updateLand(land: Land?) {
        _landLandFlow.value = land
    }

    class Factory @Inject constructor(
        private val getLandByIsForestedLandUseCase: GetLandByIsForestedLandUseCase,
        private val getObservableTaxUseCase: GetObservableTaxUseCase,

        private val getAllLandUseCase: GetAllLandUseCase,
        private val getAllUnforestedLandWithSearchUseCase: GetAllUnforestedLandWithSearchUseCase,
        private val getAllNonForestLandWithSearchUseCase: GetAllNonForestLandWithSearchUseCase,
        private val getAllForestPurposeWithSearchUseCase: GetAllForestPurposeWithSearchUseCase,
        private val getAllProtectionCategoryWithSearchUseCase: GetAllProtectionCategoryWithSearchUseCase,
        private val getAllBonitetWithSearchUseCase: GetAllBonitetWithSearchUseCase,
        private val getAllOzuWithSearchUseCase: GetAllOzuWithSearchUseCase,
        private val getAllAgeGroupWithSearchUseCase: GetAllAgeGroupWithSearchUseCase,
        private val getAllSpeciesUseCase: GetAllSpeciesUseCase,

        private val enterTaxNonForestLandUseCase: EnterTaxNonForestLandUseCase,
        private val enterTaxUnforestedLandUseCase: EnterTaxUnforestedLandUseCase,
        private val enterTaxForestPurposeUseCase: EnterTaxForestPurposeUseCase,
        private val enterTaxProtectionCategoryUseCase: EnterTaxProtectionCategoryUseCase,
        private val enterTaxBonitetUseCase: EnterTaxBonitetUseCase,
        private val enterTaxForestTypeUseCase: EnterTaxForestTypeUseCase,
        private val enterTaxOzuUseCase: EnterTaxOzuUseCase,

        private val enterTaxLayerHeightByIdUseCase: EnterTaxLayerHeightByIdUseCase,
        private val enterTaxLayerAgeClassByIdUseCase: EnterTaxLayerAgeClassByIdUseCase,
        private val enterTaxLayerAgeGroupByIdUseCase: EnterTaxLayerAgeGroupByIdUseCase,
        private val enterTaxLayerFullnessByIdUseCase: EnterTaxLayerFullnessByIdUseCase,
        private val enterTaxLayerStockByIdUseCase: EnterTaxLayerStockByIdUseCase,

        private val enterTaxSpeciesCoeffByIdUseCase: EnterTaxSpeciesCoeffByIdUseCase,
        private val enterTaxSpeciesSpeciesByIdUseCase: EnterTaxSpeciesSpeciesByIdUseCase,
        private val enterTaxSpeciesAgeByIdUseCase: EnterTaxSpeciesAgeByIdUseCase,
        private val enterTaxSpeciesHeightByIdUseCase: EnterTaxSpeciesHeightByIdUseCase,
        private val enterTaxSpeciesDiameterByIdUseCase: EnterTaxSpeciesDiameterByIdUseCase,

        private val addTaxLayerUseCase: AddTaxLayerUseCase,
        private val addTaxSpeciesByTaxLayerIdUseCase: AddTaxSpeciesByTaxLayerIdUseCase,
        private val deleteTaxLayerByIdUseCase: DeleteTaxLayerByIdUseCase,
        private val deleteTaxSpeciesByIdUseCase: DeleteTaxSpeciesByIdUseCase,
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == PpnTaxationViewModel::class.java)
            return PpnTaxationViewModel(
                getAllLandUseCase = getAllLandUseCase,
                getLandByIsForestedLandUseCase = getLandByIsForestedLandUseCase,
                getObservableTaxUseCase = getObservableTaxUseCase,

                getAllUnforestedLandWithSearchUseCase = getAllUnforestedLandWithSearchUseCase,
                getAllNonForestLandWithSearchUseCase = getAllNonForestLandWithSearchUseCase,
                getAllForestPurposeWithSearchUseCase = getAllForestPurposeWithSearchUseCase,
                getAllProtectionCategoryWithSearchUseCase = getAllProtectionCategoryWithSearchUseCase,
                getAllBonitetWithSearchUseCase = getAllBonitetWithSearchUseCase,
                getAllOzuWithSearchUseCase = getAllOzuWithSearchUseCase,
                getAllAgeGroupWithSearchUseCase = getAllAgeGroupWithSearchUseCase,
                getAllSpeciesUseCase = getAllSpeciesUseCase,

                enterTaxNonForestLandUseCase = enterTaxNonForestLandUseCase,
                enterTaxUnforestedLandUseCase = enterTaxUnforestedLandUseCase,
                enterTaxForestPurposeUseCase = enterTaxForestPurposeUseCase,
                enterTaxForestTypeUseCase = enterTaxForestTypeUseCase,
                enterTaxOzuUseCase = enterTaxOzuUseCase,
                enterTaxProtectionCategoryUseCase = enterTaxProtectionCategoryUseCase,
                enterTaxBonitetUseCase = enterTaxBonitetUseCase,

                enterTaxLayerHeightByIdUseCase = enterTaxLayerHeightByIdUseCase,
                enterTaxLayerAgeClassByIdUseCase = enterTaxLayerAgeClassByIdUseCase,
                enterTaxLayerAgeGroupByIdUseCase = enterTaxLayerAgeGroupByIdUseCase,
                enterTaxLayerFullnessByIdUseCase = enterTaxLayerFullnessByIdUseCase,
                enterTaxLayerStockByIdUseCase = enterTaxLayerStockByIdUseCase,

                enterTaxSpeciesCoeffByIdUseCase = enterTaxSpeciesCoeffByIdUseCase,
                enterTaxSpeciesSpeciesByIdUseCase = enterTaxSpeciesSpeciesByIdUseCase,
                enterTaxSpeciesAgeByIdUseCase = enterTaxSpeciesAgeByIdUseCase,
                enterTaxSpeciesHeightByIdUseCase = enterTaxSpeciesHeightByIdUseCase,
                enterTaxSpeciesDiameterByIdUseCase = enterTaxSpeciesDiameterByIdUseCase,

                addTaxLayerUseCase = addTaxLayerUseCase,
                addTaxSpeciesByTaxLayerIdUseCase = addTaxSpeciesByTaxLayerIdUseCase,
                deleteTaxLayerByIdUseCase = deleteTaxLayerByIdUseCase,
                deleteTaxSpeciesByIdUseCase = deleteTaxSpeciesByIdUseCase,
            ) as T
        }
    }
}
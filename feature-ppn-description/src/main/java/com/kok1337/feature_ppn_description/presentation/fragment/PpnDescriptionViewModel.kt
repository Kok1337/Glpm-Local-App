package com.kok1337.feature_ppn_description.presentation.fragment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kok1337.address.domain.model.*
import com.kok1337.feature_ppn_description.domain.use_case.*
import com.kok1337.feature_ppn_description.presentation.adapter.description_item_adapter.DescriptionItem
import com.kok1337.feature_ppn_description.presentation.adapter.description_item_adapter.DescriptionItemTransformer
import com.kok1337.taxation.domain.model.TaxPreview
import kotlinx.coroutines.flow.*
import javax.inject.Inject

internal class PpnDescriptionViewModel(
    private val enterRegionUseCase: EnterRegionUseCase,
    private val enterForestryUseCase: EnterForestryUseCase,
    private val enterLocalForestryUseCase: EnterLocalForestryUseCase,
    private val enterSubForestryUseCase: EnterSubForestryUseCase,
    private val enterAreaUseCase: EnterAreaUseCase,
    private val enterTaxPreviewUseCase: EnterTaxPreviewUseCase,

    private val getAllRegionWithSearchUseCase: GetAllRegionWithSearchUseCase,
    private val getAllForestryWithSearchUseCase: GetAllForestryWithSearchUseCase,
    private val getAllLocalForestryWithSearchUseCase: GetAllLocalForestryWithSearchUseCase,
    private val getAllSubForestryWithSearchUseCase: GetAllSubForestryWithSearchUseCase,
    private val getAllTaxPreviewUseCase: GetAllTaxPreviewUseCase,

    private val getObservableLocalityUseCase: GetObservableLocalityUseCase,
    private val getObservableTaxUseCase: GetObservableTaxUseCase,
) : ViewModel() {
    private val _localityStateFlow = getObservableLocalityUseCase()
    private val _taxStateFlow = getObservableTaxUseCase()

    val descriptionItemListFlow: Flow<List<DescriptionItem>> = combineTransform(
        _localityStateFlow, _taxStateFlow,
    ) { locality, tax ->
        Log.e("PpnDescriptionViewModel", locality.toString())
        val descriptionItemList =
            DescriptionItemTransformer.transformToDescriptionItemList(locality, tax)
        emit(descriptionItemList)
    }

    fun updateRegion(region: Region?) = enterRegionUseCase(region)

    suspend fun getAllRegionBySearch(search: String): List<Region> {
        val federalDistrict = _localityStateFlow.first().federalDistrict!!
        return getAllRegionWithSearchUseCase(federalDistrict, search)
    }

    fun updateForestry(forestry: Forestry?) = enterForestryUseCase(forestry)

    suspend fun getAllForestryBySearch(search: String): List<Forestry> {
        val region = _localityStateFlow.first().region!!
        return getAllForestryWithSearchUseCase(region, search)
    }

    fun updateLocalForestry(localForestry: LocalForestry?) =
        enterLocalForestryUseCase(localForestry)

    suspend fun getAllLocalForestryWithSearch(search: String): List<LocalForestry> {
        val forestry = _localityStateFlow.first().forestry!!
        return getAllLocalForestryWithSearchUseCase(forestry, search)
    }

    fun updateSubForestry(subForestry: SubForestry?) = enterSubForestryUseCase(subForestry)

    suspend fun getAllSubForestryWithSearch(search: String): List<SubForestry> {
        val localForestry = _localityStateFlow.first().localForestry!!
        return getAllSubForestryWithSearchUseCase(localForestry, search)
    }

    fun updateArea(area: String?) = enterAreaUseCase(area)

    suspend fun getAllTaxPreview(section: String): List<TaxPreview> {
        val localityId = _localityStateFlow.value.id
        return getAllTaxPreviewUseCase(localityId!!, section)
    }

    fun enterTaxPreview(taxPreview: TaxPreview) = enterTaxPreviewUseCase(taxPreview)

    class Factory @Inject constructor(
        private val enterRegionUseCase: EnterRegionUseCase,
        private val enterForestryUseCase: EnterForestryUseCase,
        private val enterLocalForestryUseCase: EnterLocalForestryUseCase,
        private val enterSubForestryUseCase: EnterSubForestryUseCase,
        private val enterAreaUseCase: EnterAreaUseCase,
        private val enterTaxPreviewUseCase: EnterTaxPreviewUseCase,

        private val getAllRegionWithSearchUseCase: GetAllRegionWithSearchUseCase,
        private val getAllForestryWithSearchUseCase: GetAllForestryWithSearchUseCase,
        private val getAllLocalForestryWithSearchUseCase: GetAllLocalForestryWithSearchUseCase,
        private val getAllSubForestryWithSearchUseCase: GetAllSubForestryWithSearchUseCase,
        private val getAllTaxPreviewUseCase: GetAllTaxPreviewUseCase,

        private val getObservableLocalityUseCase: GetObservableLocalityUseCase,
        private val getObservableTaxUseCase: GetObservableTaxUseCase,
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == PpnDescriptionViewModel::class.java)
            return PpnDescriptionViewModel(
                enterRegionUseCase = enterRegionUseCase,
                enterForestryUseCase = enterForestryUseCase,
                enterLocalForestryUseCase = enterLocalForestryUseCase,
                enterSubForestryUseCase = enterSubForestryUseCase,
                enterAreaUseCase = enterAreaUseCase,
                enterTaxPreviewUseCase = enterTaxPreviewUseCase,

                getAllRegionWithSearchUseCase = getAllRegionWithSearchUseCase,
                getAllForestryWithSearchUseCase = getAllForestryWithSearchUseCase,
                getAllLocalForestryWithSearchUseCase = getAllLocalForestryWithSearchUseCase,
                getAllSubForestryWithSearchUseCase = getAllSubForestryWithSearchUseCase,
                getAllTaxPreviewUseCase = getAllTaxPreviewUseCase,

                getObservableLocalityUseCase = getObservableLocalityUseCase,
                getObservableTaxUseCase = getObservableTaxUseCase
            ) as T
        }
    }
}

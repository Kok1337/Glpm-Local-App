package com.kok1337.feature_ppn_description.presentation.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kok1337.address.domain.model.*
import com.kok1337.feature_ppn_description.domain.use_case.*
import com.kok1337.feature_ppn_description.presentation.adapter.description_item_adapter.DescriptionItem
import com.kok1337.feature_ppn_description.presentation.adapter.description_item_adapter.DescriptionItemTransformer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

internal class PpnDescriptionViewModel(
    private val enterRegionUseCase: EnterRegionUseCase,
    private val enterForestryUseCase: EnterForestryUseCase,
    private val enterLocalForestryUseCase: EnterLocalForestryUseCase,
    private val enterSubForestryUseCase: EnterSubForestryUseCase,
    private val enterAreaUseCase: EnterAreaUseCase,

    private val getAllRegionWithSearchUseCase: GetAllRegionWithSearchUseCase,
    private val getAllForestryWithSearchUseCase: GetAllForestryWithSearchUseCase,
    private val getAllLocalForestryWithSearchUseCase: GetAllLocalForestryWithSearchUseCase,
    private val getAllSubForestryWithSearchUseCase: GetAllSubForestryWithSearchUseCase,

    private val getObservableLocalityUseCase: GetObservableLocalityUseCase,
) : ViewModel() {
    private val _localityStateFlow = getObservableLocalityUseCase()
    val descriptionItemListFlow: Flow<List<DescriptionItem>> =
        _localityStateFlow.transform { locality ->
            emit(DescriptionItemTransformer.transformToDescriptionItemList(locality))
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

    class Factory @Inject constructor(
        private val enterRegionUseCase: EnterRegionUseCase,
        private val enterForestryUseCase: EnterForestryUseCase,
        private val enterLocalForestryUseCase: EnterLocalForestryUseCase,
        private val enterSubForestryUseCase: EnterSubForestryUseCase,
        private val enterAreaUseCase: EnterAreaUseCase,

        private val getAllRegionWithSearchUseCase: GetAllRegionWithSearchUseCase,
        private val getAllForestryWithSearchUseCase: GetAllForestryWithSearchUseCase,
        private val getAllLocalForestryWithSearchUseCase: GetAllLocalForestryWithSearchUseCase,
        private val getAllSubForestryWithSearchUseCase: GetAllSubForestryWithSearchUseCase,

        private val getObservableLocalityUseCase: GetObservableLocalityUseCase,
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

                getAllRegionWithSearchUseCase = getAllRegionWithSearchUseCase,
                getAllForestryWithSearchUseCase = getAllForestryWithSearchUseCase,
                getAllLocalForestryWithSearchUseCase = getAllLocalForestryWithSearchUseCase,
                getAllSubForestryWithSearchUseCase = getAllSubForestryWithSearchUseCase,

                getObservableLocalityUseCase = getObservableLocalityUseCase,
            ) as T
        }
    }
}

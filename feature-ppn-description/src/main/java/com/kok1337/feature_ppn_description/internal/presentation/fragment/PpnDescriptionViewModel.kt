package com.kok1337.feature_ppn_description.internal.presentation.fragment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kok1337.feature_ppn_description.api.domain.module.Forestry
import com.kok1337.feature_ppn_description.api.domain.module.LocalForestry
import com.kok1337.feature_ppn_description.api.domain.module.Region
import com.kok1337.feature_ppn_description.api.domain.module.SubForestry
import com.kok1337.feature_ppn_description.api.domain.use_case.*
import com.kok1337.feature_ppn_description.internal.presentation.adapter.description_item_adapter.DescriptionItem
import com.kok1337.feature_ppn_description.internal.presentation.adapter.description_item_adapter.DescriptionItemTransformer
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

    private val getObservableAddressUseCase: GetObservableAddressUseCase,
) : ViewModel() {
    private val TAG = javaClass.simpleName

    init {
        Log.e(TAG, "init")
    }

    override fun onCleared() {
        super.onCleared()
        Log.e(TAG, "onCleared")
    }

    private val _addressFlow = getObservableAddressUseCase()
    val descriptionItemListFlow: Flow<List<DescriptionItem>> = _addressFlow.transform { address ->
        emit(DescriptionItemTransformer.transformToDescriptionItemList(address))
    }

    fun updateRegion(region: Region?) = enterRegionUseCase(region)
    suspend fun getAllRegionBySearch(search: String): List<Region> {
        val federalDistrict = _addressFlow.first().federalDistrict!!
        return getAllRegionWithSearchUseCase(federalDistrict, search)
    }

    fun updateForestry(forestry: Forestry?) = enterForestryUseCase(forestry)
    suspend fun getAllForestryBySearch(search: String): List<Forestry> {
        val region = _addressFlow.first().region!!
        return getAllForestryWithSearchUseCase(region, search)
    }

    fun updateLocalForestry(localForestry: LocalForestry?) =
        enterLocalForestryUseCase(localForestry)

    suspend fun getAllLocalForestryWithSearch(search: String): List<LocalForestry> {
        val forestry = _addressFlow.first().forestry!!
        return getAllLocalForestryWithSearchUseCase(forestry, search)
    }

    fun updateSubForestry(subForestry: SubForestry?) =
        enterSubForestryUseCase(subForestry)

    suspend fun getAllSubForestryWithSearch(search: String): List<SubForestry> {
        val localForestry = _addressFlow.first().localForestry!!
        return getAllSubForestryWithSearchUseCase(localForestry, search)
    }

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

        private val getObservableAddressUseCase: GetObservableAddressUseCase,
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

                getObservableAddressUseCase = getObservableAddressUseCase,
            ) as T
        }
    }
}

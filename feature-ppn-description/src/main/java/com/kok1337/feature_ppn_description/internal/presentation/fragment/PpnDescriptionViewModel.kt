package com.kok1337.feature_ppn_description.internal.presentation.fragment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kok1337.feature_ppn_description.api.domain.use_case.*
import com.kok1337.feature_ppn_description.internal.presentation.adapter.description_item_adapter.DescriptionItem
import com.kok1337.feature_ppn_description.internal.presentation.adapter.description_item_adapter.DescriptionItemTransformer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combineTransform
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

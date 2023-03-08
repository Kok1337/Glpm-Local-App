package com.kok1337.feature_ppn_description_sample.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.kok1337.feature_ppn_description.api.domain.module.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FeaturePpnDescriptionViewModel : ViewModel() {
    private val TAG = javaClass.simpleName

    private val _addressStateFlow =
        MutableStateFlow(Address(federalDistrict = FederalDistrict(5, "df")))
    val addressFlow = _addressStateFlow.asStateFlow()

    init {
        Log.e(TAG, "init")
    }

    override fun onCleared() {
        super.onCleared()
        Log.e(TAG, "onCleared")
    }

    fun updateRegion(region: Region?) {
        val currentAddress = _addressStateFlow.value
        if (currentAddress.region == region) return
        val newAddress = Address(currentAddress.federalDistrict, region)
        _addressStateFlow.value = newAddress
    }

    fun updateForestry(forestry: Forestry?) {
        val currentAddress = _addressStateFlow.value
        if (currentAddress.forestry == forestry) return
        val newAddress = Address(currentAddress.federalDistrict, currentAddress.region, forestry)
        _addressStateFlow.value = newAddress
    }

    fun updateLocalForestry(localForestry: LocalForestry?) {
        val currentAddress = _addressStateFlow.value
        if (currentAddress.localForestry == localForestry) return
        val newAddress =
            currentAddress.copy(localForestry = localForestry, subForestry = null, area = null)
        _addressStateFlow.value = newAddress
    }

    fun updateSubForestry(subForestry: SubForestry?) {
        val currentAddress = _addressStateFlow.value
        if (currentAddress.subForestry == subForestry) return
        val newAddress = currentAddress.copy(subForestry = subForestry, area = null)
        _addressStateFlow.value = newAddress
    }

    fun updateArea(area: String?) {
        val currentAddress = _addressStateFlow.value
        if (currentAddress.area == area) return
        val newAddress = currentAddress.copy(area = area)
        _addressStateFlow.value = newAddress
    }
}
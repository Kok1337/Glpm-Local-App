package com.kok1337.feature_ppn_description_sample.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.kok1337.feature_ppn_description.api.domain.module.Address
import com.kok1337.feature_ppn_description.api.domain.module.FederalDistrict
import com.kok1337.feature_ppn_description.api.domain.module.Forestry
import com.kok1337.feature_ppn_description.api.domain.module.Region
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
}
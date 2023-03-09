package com.kok1337.feature_ppn_description_sample.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.kok1337.feature_ppn_description.api.domain.module.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FeaturePpnDescriptionViewModel : ViewModel() {
    private val TAG = javaClass.simpleName

    private val _localityStateFlow =
        MutableStateFlow(Locality(federalDistrict = FederalDistrict(5, "df")))
    val localityStateFlow = _localityStateFlow.asStateFlow()

    init {
        Log.e(TAG, "init")
    }

    override fun onCleared() {
        super.onCleared()
        Log.e(TAG, "onCleared")
    }

    fun updateRegion(region: Region?) {
        val currentLocality = _localityStateFlow.value
        if (currentLocality.region == region) return
        val newLocality = Locality(
            federalDistrict = currentLocality.federalDistrict,
            region = region,
        )
        _localityStateFlow.value = newLocality
    }

    fun updateForestry(forestry: Forestry?) {
        val currentLocality = _localityStateFlow.value
        if (currentLocality.forestry == forestry) return
        val newLocality = Locality(
            federalDistrict = currentLocality.federalDistrict,
            region = currentLocality.region,
            forestry = forestry
        )
        _localityStateFlow.value = newLocality
    }

    fun updateLocalForestry(localForestry: LocalForestry?) {
        val currentLocality = _localityStateFlow.value
        if (currentLocality.localForestry == localForestry) return
        val newLocality = Locality(
            federalDistrict = currentLocality.federalDistrict,
            region = currentLocality.region,
            forestry = currentLocality.forestry,
            localForestry = localForestry
        )
        _localityStateFlow.value = newLocality
    }

    fun updateSubForestry(subForestry: SubForestry?) {
        val currentLocality = _localityStateFlow.value
        if (currentLocality.subForestry == subForestry) return
        val newLocality = Locality(
            federalDistrict = currentLocality.federalDistrict,
            region = currentLocality.region,
            forestry = currentLocality.forestry,
            localForestry = currentLocality.localForestry,
            subForestry = subForestry,
        )
        _localityStateFlow.value = newLocality
    }

    fun updateArea(area: String?) {
        val currentLocality = _localityStateFlow.value
        if (currentLocality.area == area) return
        val newLocality = Locality(
            federalDistrict = currentLocality.federalDistrict,
            region = currentLocality.region,
            forestry = currentLocality.forestry,
            localForestry = currentLocality.localForestry,
            subForestry = currentLocality.subForestry,
            area = area,
        )
        _localityStateFlow.value = newLocality
    }
}
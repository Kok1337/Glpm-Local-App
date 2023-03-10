package com.kok1337.feature_ppn.presentation.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.kok1337.address.domain.model.*
import com.kok1337.feature_ppn.domain.use_case.GetLocalityWithIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class PpnViewModel(
    private val getLocalityWithIdUseCase: GetLocalityWithIdUseCase,
) : ViewModel() {
    private val _localityStateFlow =
        MutableStateFlow(Locality(federalDistrict = FederalDistrict(5, "")))
    val localityStateFlow = _localityStateFlow.asStateFlow()

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
        getLocalityWithId()
    }

    private fun getLocalityWithId() = viewModelScope.launch(Dispatchers.IO) {
        _localityStateFlow.update {
            getLocalityWithIdUseCase(it)
        }
    }

    class Factory @Inject constructor(
        private val getLocalityWithIdUseCase: GetLocalityWithIdUseCase,
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == PpnViewModel::class.java)
            return PpnViewModel(
                getLocalityWithIdUseCase = getLocalityWithIdUseCase,
            ) as T
        }
    }
}
package com.kok1337.feature_ppn_description_sample.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.kok1337.feature_ppn_description.api.domain.module.Address
import com.kok1337.feature_ppn_description.api.domain.module.FederalDistrict
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FeaturePpnDescriptionViewModel : ViewModel() {
    private val TAG = javaClass.simpleName

    private val _addressStateFlow = MutableStateFlow(Address(federalDistrict = FederalDistrict(5, "df")))
    val addressFlow = _addressStateFlow.asStateFlow()

    init {
        Log.e(TAG, "init")
    }

    override fun onCleared() {
        super.onCleared()
        Log.e(TAG, "onCleared")
    }
}
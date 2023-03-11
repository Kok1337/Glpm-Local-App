package com.kok1337.feature_ppn_description.data.repository

import com.kok1337.address.domain.model.*
import kotlinx.coroutines.flow.StateFlow

interface DescriptionLocalityInMemoryRepository {
    fun getLocalityStateFlow(): StateFlow<Locality>
    fun updateRegion(region: Region?)
    fun updateForestry(forestry: Forestry?)
    fun updateLocalForestry(localForestry: LocalForestry?)
    fun updateSubForestry(subForestry: SubForestry?)
    fun updateArea(area: String?)
}
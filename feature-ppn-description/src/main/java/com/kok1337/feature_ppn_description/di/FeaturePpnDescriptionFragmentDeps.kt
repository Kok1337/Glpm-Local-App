package com.kok1337.feature_ppn_description.di

import com.kok1337.address.data.repository.*
import com.kok1337.address.domain.model.*
import com.kok1337.providing_dependencies.Dependencies
import kotlinx.coroutines.flow.StateFlow

interface FeaturePpnDescriptionFragmentDeps : Dependencies {
    val federalDistrictTermuxRepository: FederalDistrictTermuxRepository
    val regionTermuxRepository: RegionTermuxRepository
    val forestryTermuxRepository: ForestryTermuxRepository
    val localForestryTermuxRepository: LocalForestryTermuxRepository
    val subForestryTermuxRepository: SubForestryTermuxRepository
    val localityInMemoryRepository: LocalityInMemoryRepository
}

interface LocalityInMemoryRepository {
    fun getLocalityStateFlow(): StateFlow<Locality>
    fun updateRegion(region: Region?)
    fun updateForestry(forestry: Forestry?)
    fun updateLocalForestry(localForestry: LocalForestry?)
    fun updateSubForestry(subForestry: SubForestry?)
    fun updateArea(area: String?)
}
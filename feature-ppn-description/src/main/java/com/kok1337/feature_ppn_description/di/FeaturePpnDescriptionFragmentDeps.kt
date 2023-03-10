package com.kok1337.feature_ppn_description.di

import com.kok1337.address.data.repository.*
import com.kok1337.feature_ppn_description.data.repository.LocalityInMemoryRepository
import com.kok1337.feature_ppn_description.data.repository.TaxInMemoryRepository
import com.kok1337.providing_dependencies.Dependencies
import com.kok1337.taxation.data.repository.TaxPreviewTermuxRepository

interface FeaturePpnDescriptionFragmentDeps : Dependencies {
    val federalDistrictTermuxRepository: FederalDistrictTermuxRepository
    val regionTermuxRepository: RegionTermuxRepository
    val forestryTermuxRepository: ForestryTermuxRepository
    val localForestryTermuxRepository: LocalForestryTermuxRepository
    val subForestryTermuxRepository: SubForestryTermuxRepository
    val taxPreviewTermuxRepository: TaxPreviewTermuxRepository
    val localityInMemoryRepository: LocalityInMemoryRepository
    val taxInMemoryRepository: TaxInMemoryRepository
}
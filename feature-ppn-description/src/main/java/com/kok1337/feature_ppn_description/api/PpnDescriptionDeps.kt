package com.kok1337.feature_ppn_description.api

import com.kok1337.feature_ppn_description.api.data.data_source.termux.DatabaseFactory
import com.kok1337.feature_ppn_description.api.domain.module.*
import com.kok1337.providing_dependencies.Dependencies
import kotlinx.coroutines.flow.Flow

interface PpnDescriptionDeps : Dependencies {
    val databaseFactory: DatabaseFactory
    val addressInMemoryRepository: AddressInMemoryRepository
}

interface AddressInMemoryRepository {
    fun getAddressFlow(): Flow<Address>
    fun updateRegion(region: Region?)
    fun updateForestry(forestry: Forestry?)
    fun updateLocalForestry(localForestry: LocalForestry?)
    fun updateSubForestry(subForestry: SubForestry?)
    fun updateArea(area: String?)
}
package com.kok1337.feature_ppn_description.internal.data.repository

import com.kok1337.feature_ppn_description.api.data.model.SubForestryApiModel
import com.kok1337.feature_ppn_description.api.data.repository.FederalDistrictRepository
import javax.inject.Inject

internal class FederalDistrictRepositoryImpl @Inject constructor(
) : FederalDistrictRepository {
    override suspend fun findById(id: Int): SubForestryApiModel? {
        TODO("Not yet implemented")
    }

    override suspend fun findAll(): Iterable<SubForestryApiModel> {
        TODO("Not yet implemented")
    }
}
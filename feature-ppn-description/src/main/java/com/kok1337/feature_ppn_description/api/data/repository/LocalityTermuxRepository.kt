package com.kok1337.feature_ppn_description.api.data.repository

import com.kok1337.feature_ppn_description.api.data.data_source.termux.dao.LocalityDao
import com.kok1337.feature_ppn_description.api.data.model.*
import com.kok1337.feature_ppn_description.api.domain.module.Locality
import java.util.*
import javax.inject.Inject

internal class LocalityTermuxRepository @Inject constructor(
    private val localityDao: LocalityDao,

){
    suspend fun findById(id: UUID): Locality? {
//        val localityApiModel = localityDao.getById()
        throw Error()
    }


    suspend fun findLocalityByLocalityFields(
        federalDistrictId: Int,
        regionId: Int,
        forestryId: Int,
        localForestryId: Int,
        subForestryId: Int?,
        area: String,
    ): LocalityApiModel? {
        throw Error()
    }
}
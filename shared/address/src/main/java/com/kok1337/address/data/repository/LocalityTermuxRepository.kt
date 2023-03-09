package com.kok1337.address.data.repository

import com.kok1337.address.data.data_source.dao.LocalityDao
import com.kok1337.address.data.model.LocalityApiModel
import com.kok1337.address.domain.model.Locality
import java.util.*

class LocalityTermuxRepository(
    private val localityDao: LocalityDao,

    ) {
    suspend fun findById(id: UUID): Locality? {
//        val localityApiModel = localityDao.getById()
        throw Error()
    }


//    suspend fun findLocalityByLocalityFields(
//        federalDistrictId: Int,
//        regionId: Int,
//        forestryId: Int,
//        localForestryId: Int,
//        subForestryId: Int?,
//        area: String,
//    ): LocalityApiModel? {
//        throw Error()
//    }
}
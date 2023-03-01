package com.kok1337.district.internal.repository

import com.kok1337.district.api.module.District
import com.kok1337.district.api.repository.DistrictRepository
import com.kok1337.district.internal.data_source.termux.dao.DistrictDao
import javax.inject.Inject

internal class DistrictRepositoryImpl @Inject constructor(
    private val districtDao: DistrictDao,
) : DistrictRepository {
    override suspend fun findById(id: Int): District =
        districtDao.getById(id)

    override suspend fun findAll(): List<District> =
        districtDao.getAll()

    override suspend fun findAllWithSearch(search: String): List<District> =
        districtDao.getWithSearch(search)
}
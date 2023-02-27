package com.kok1337.non_forest_land.internal.repository

import com.kok1337.dictionary.api.DictionaryDao
import com.kok1337.non_forest_land.api.NonForestLandApiModel
import com.kok1337.non_forest_land.api.NonForestLandRepository

internal class NonForestLandRepositoryImpl(
    private val dictionaryDao: DictionaryDao<NonForestLandApiModel>,
) : NonForestLandRepository {
    override suspend fun findById(id: Int): NonForestLandApiModel =
        dictionaryDao.getById(id)

    override suspend fun findAll(): List<NonForestLandApiModel> =
        dictionaryDao.getAll()

    override suspend fun findAllWithSearch(search: String): List<NonForestLandApiModel> =
        dictionaryDao.getWithSearch(search)
}
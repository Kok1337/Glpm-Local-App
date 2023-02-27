package com.kok1337.unforested_land.internal.repository

import com.kok1337.dictionary.api.DictionaryDao
import com.kok1337.unforested_land.api.UnforestedLandApiModel
import com.kok1337.unforested_land.api.UnforestedLandRepository

internal class UnforestedLandRepositoryImpl(
    private val dictionaryDao: DictionaryDao<UnforestedLandApiModel>,
) : UnforestedLandRepository {
    override suspend fun findById(id: Int): UnforestedLandApiModel =
        dictionaryDao.getById(id)

    override suspend fun findAll(): List<UnforestedLandApiModel> =
        dictionaryDao.getAll()

    override suspend fun findAllWithSearch(search: String): List<UnforestedLandApiModel> =
        dictionaryDao.getWithSearch(search)
}
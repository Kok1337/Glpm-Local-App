package com.kok1337.forest_purpose.internal.repository

import com.kok1337.dictionary.api.DictionaryDao
import com.kok1337.forest_purpose.api.ForestPurposeApiModel
import com.kok1337.forest_purpose.api.ForestPurposeRepository

internal class ForestPurposeRepositoryImpl(
    private val dictionaryDao: DictionaryDao<ForestPurposeApiModel>,
) : ForestPurposeRepository {
    override suspend fun findById(id: Int): ForestPurposeApiModel =
        dictionaryDao.getById(id)

    override suspend fun findAll(): List<ForestPurposeApiModel> =
        dictionaryDao.getAll()

    override suspend fun findAllWithSearch(search: String): List<ForestPurposeApiModel> =
        dictionaryDao.getWithSearch(search)
}
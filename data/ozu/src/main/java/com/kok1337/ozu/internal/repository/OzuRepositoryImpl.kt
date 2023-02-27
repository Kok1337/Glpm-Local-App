package com.kok1337.ozu.internal.repository

import com.kok1337.dictionary.api.DictionaryDao
import com.kok1337.ozu.api.OzuApiModel
import com.kok1337.ozu.api.OzuRepository

internal class OzuRepositoryImpl(
    private val dictionaryDao: DictionaryDao<OzuApiModel>,
) : OzuRepository {
    override suspend fun findById(id: Int): OzuApiModel =
        dictionaryDao.getById(id)

    override suspend fun findAll(): List<OzuApiModel> =
        dictionaryDao.getAll()

    override suspend fun findAllWithSearch(search: String): List<OzuApiModel> =
        dictionaryDao.getWithSearch(search)
}
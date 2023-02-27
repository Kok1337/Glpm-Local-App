package com.kok1337.bonitet.internal.repository

import com.kok1337.dictionary.api.DictionaryDao
import com.kok1337.bonitet.api.BonitetApiModel
import com.kok1337.bonitet.api.BonitetRepository

internal class BonitetRepositoryImpl(
    private val dictionaryDao: DictionaryDao<BonitetApiModel>,
) : BonitetRepository {
    override suspend fun findById(id: Int): BonitetApiModel =
        dictionaryDao.getById(id)

    override suspend fun findAll(): List<BonitetApiModel> =
        dictionaryDao.getAll()

    override suspend fun findAllWithSearch(search: String): List<BonitetApiModel> =
        dictionaryDao.getWithSearch(search)
}
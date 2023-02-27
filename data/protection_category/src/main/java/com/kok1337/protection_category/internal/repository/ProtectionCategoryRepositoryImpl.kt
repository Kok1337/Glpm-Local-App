package com.kok1337.protection_category.internal.repository

import com.kok1337.dictionary.api.DictionaryDao
import com.kok1337.protection_category.api.ProtectionCategoryApiModel
import com.kok1337.protection_category.api.ProtectionCategoryRepository

internal class ProtectionCategoryRepositoryImpl(
    private val dictionaryDao: DictionaryDao<ProtectionCategoryApiModel>,
) : ProtectionCategoryRepository {
    override suspend fun findById(id: Int): ProtectionCategoryApiModel =
        dictionaryDao.getById(id)

    override suspend fun findAll(): List<ProtectionCategoryApiModel> =
        dictionaryDao.getAll()

    override suspend fun findAllWithSearch(search: String): List<ProtectionCategoryApiModel> =
        dictionaryDao.getWithSearch(search)
}
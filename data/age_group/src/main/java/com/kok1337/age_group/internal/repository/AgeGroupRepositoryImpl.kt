package com.kok1337.age_group.internal.repository

import com.kok1337.dictionary.api.DictionaryDao
import com.kok1337.age_group.api.AgeGroupApiModel
import com.kok1337.age_group.api.AgeGroupRepository

internal class AgeGroupRepositoryImpl(
    private val dictionaryDao: DictionaryDao<AgeGroupApiModel>,
) : AgeGroupRepository {
    override suspend fun findById(id: Int): AgeGroupApiModel =
        dictionaryDao.getById(id)

    override suspend fun findAll(): List<AgeGroupApiModel> =
        dictionaryDao.getAll()

    override suspend fun findAllWithSearch(search: String): List<AgeGroupApiModel> =
        dictionaryDao.getWithSearch(search)
}
package com.kok1337.forest_purpose.api

import com.kok1337.dictionary.api.DictionaryDao
import com.kok1337.dictionary.api.DictionaryEntity
import com.kok1337.forest_purpose.internal.repository.ForestPurposeRepositoryImpl

object ForestPurposeRepositoryFactory {
    fun create(dependencies: ForestPurposeDependencies): ForestPurposeRepository {
        val tableName = "info_forest_purpose"
        val jdbcTemplate = dependencies.jdbcTemplate
        val mapper: (DictionaryEntity) -> ForestPurposeApiModel = { entity ->
            ForestPurposeApiModel(entity.id!!, entity.name!!)
        }
        val dictionaryDao = DictionaryDao(jdbcTemplate, tableName, mapper)
        return ForestPurposeRepositoryImpl(dictionaryDao)
    }
}
package com.kok1337.ozu.api

import com.kok1337.dictionary.api.DictionaryDao
import com.kok1337.dictionary.api.DictionaryEntity
import com.kok1337.ozu.internal.repository.OzuRepositoryImpl

object OzuRepositoryFactory {
    fun create(dependencies: OzuDependencies): OzuRepository {
        val tableName = "info_ozu"
        val jdbcTemplate = dependencies.jdbcTemplate
        val mapper: (DictionaryEntity) -> OzuApiModel = { entity ->
            OzuApiModel(entity.id!!, entity.name!!)
        }
        val dictionaryDao = DictionaryDao(jdbcTemplate, tableName, mapper)
        return OzuRepositoryImpl(dictionaryDao)
    }
}
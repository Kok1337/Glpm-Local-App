package com.kok1337.bonitet.api

import com.kok1337.dictionary.api.DictionaryDao
import com.kok1337.dictionary.api.DictionaryEntity
import com.kok1337.bonitet.internal.repository.BonitetRepositoryImpl

object BonitetRepositoryFactory {
    fun create(dependencies: BonitetDependencies): BonitetRepository {
        val tableName = "info_bonitet"
        val jdbcTemplate = dependencies.jdbcTemplate
        val mapper: (DictionaryEntity) -> BonitetApiModel = { entity ->
            BonitetApiModel(entity.id!!, entity.name!!)
        }
        val dictionaryDao = DictionaryDao(jdbcTemplate, tableName, mapper)
        return BonitetRepositoryImpl(dictionaryDao)
    }
}
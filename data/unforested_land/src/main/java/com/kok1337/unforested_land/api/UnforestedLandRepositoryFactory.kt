package com.kok1337.unforested_land.api

import com.kok1337.dictionary.api.DictionaryDao
import com.kok1337.dictionary.api.DictionaryEntity
import com.kok1337.unforested_land.internal.repository.UnforestedLandRepositoryImpl

object UnforestedLandRepositoryFactory {
    fun create(dependencies: UnforestedLandDependencies): UnforestedLandRepository {
        val tableName = "info_unforested_land"
        val jdbcTemplate = dependencies.jdbcTemplate
        val mapper: (DictionaryEntity) -> UnforestedLandApiModel = { entity ->
            UnforestedLandApiModel(entity.id!!, entity.name!!)
        }
        val dictionaryDao = DictionaryDao(jdbcTemplate, tableName, mapper)
        return UnforestedLandRepositoryImpl(dictionaryDao)
    }
}
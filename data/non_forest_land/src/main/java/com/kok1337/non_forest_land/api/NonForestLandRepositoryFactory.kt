package com.kok1337.non_forest_land.api

import com.kok1337.dictionary.api.DictionaryDao
import com.kok1337.dictionary.api.DictionaryEntity
import com.kok1337.non_forest_land.internal.repository.NonForestLandRepositoryImpl

object NonForestLandRepositoryFactory {
    fun create(dependencies: NonForestLandDependencies): NonForestLandRepository {
        val tableName = "info_non_forest_land"
        val jdbcTemplate = dependencies.jdbcTemplate
        val mapper: (DictionaryEntity) -> NonForestLandApiModel = { entity ->
            NonForestLandApiModel(entity.id!!, entity.name!!)
        }
        val dictionaryDao = DictionaryDao(jdbcTemplate, tableName, mapper)
        return NonForestLandRepositoryImpl(dictionaryDao)
    }
}
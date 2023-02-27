package com.kok1337.age_group.api

import com.kok1337.dictionary.api.DictionaryDao
import com.kok1337.dictionary.api.DictionaryEntity
import com.kok1337.age_group.internal.repository.AgeGroupRepositoryImpl

object AgeGroupRepositoryFactory {
    fun create(dependencies: AgeGroupDependencies): AgeGroupRepository {
        val tableName = "info_age_groups"
        val jdbcTemplate = dependencies.jdbcTemplate
        val mapper: (DictionaryEntity) -> AgeGroupApiModel = { entity ->
            AgeGroupApiModel(entity.id!!, entity.name!!)
        }
        val dictionaryDao = DictionaryDao(jdbcTemplate, tableName, mapper)
        return AgeGroupRepositoryImpl(dictionaryDao)
    }
}
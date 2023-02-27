package com.kok1337.protection_category.api

import com.kok1337.dictionary.api.DictionaryDao
import com.kok1337.dictionary.api.DictionaryEntity
import com.kok1337.protection_category.internal.repository.ProtectionCategoryRepositoryImpl

object ProtectionCategoryRepositoryFactory {
    fun create(dependencies: ProtectionCategoryDependencies): ProtectionCategoryRepository {
        val tableName = "info_protection_category"
        val jdbcTemplate = dependencies.jdbcTemplate
        val mapper: (DictionaryEntity) -> ProtectionCategoryApiModel = { entity ->
            ProtectionCategoryApiModel(entity.id!!, entity.name!!)
        }
        val dictionaryDao = DictionaryDao(jdbcTemplate, tableName, mapper)
        return ProtectionCategoryRepositoryImpl(dictionaryDao)
    }
}
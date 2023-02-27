package com.kok1337.protection_category.api

interface ProtectionCategoryRepository {
    suspend fun findById(id: Int): ProtectionCategoryApiModel
    suspend fun findAll(): List<ProtectionCategoryApiModel>
    suspend fun findAllWithSearch(search: String = ""): List<ProtectionCategoryApiModel>
}